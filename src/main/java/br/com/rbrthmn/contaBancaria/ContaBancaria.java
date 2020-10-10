package main.java.br.com.rbrthmn.contaBancaria;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ContaBancaria {
    ReentrantLock lock = new ReentrantLock();
    int numero;
    int saldo;

    private static final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool((int) (Math.random() * 30));

    public ContaBancaria(int numero, int saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    int sacar(int valor) {
        while (saldo < 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (saldo > 0) {
            lock.lock();
            try {
                saldo -= valor;
                System.out.println("Saque de " + valor + " reais.");
                this.notifyAll();
            } finally {
                lock.unlock();
                return 1;
            }
        }

        return 0;
    }

    int depositar(int valor) {
        while (saldo > 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (saldo < 501) {
            lock.lock();
            try {
                saldo += valor;
                System.out.println("Depósito de " + valor + " reais.");
                this.notifyAll();
            } finally {
                lock.unlock();
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1, 0);

        CaixaBancaria caixa = new CaixaBancaria(conta);
        Thread thread = new Thread(caixa);

        final ScheduledFuture<?> depositarHandle = scheduler.scheduleAtFixedRate(() -> {
            thread.start();
        }, 1, 1, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            depositarHandle.cancel(true);
        }, 15, TimeUnit.SECONDS);

        if (depositarHandle.isCancelled()) {
            System.out.println("Saldo da conta: " + conta.saldo + " reais.");
        }
    }
}
