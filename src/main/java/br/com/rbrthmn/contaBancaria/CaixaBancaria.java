package main.java.br.com.rbrthmn.contaBancaria;

public class CaixaBancaria implements Runnable {
    ContaBancaria conta;

    public CaixaBancaria(ContaBancaria conta) {
        this.conta = conta;
    }

    @Override
    public void run() {
            conta.depositar(500);
            conta.sacar(500);
    }
}
