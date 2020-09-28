package main.java.br.com.rbrthmn.exercicio1;

import java.lang.*;


public class PrimeNumbers extends Thread {
    public static void main(String[] args) {
        /** Comentar método restante aquele que deseja executar
         **/
        exercicioA();
        exercicioB();
    }

    private static void exercicioA() {
        long ti1 = System.currentTimeMillis();

        MyThread t1 = new MyThread(1000001, 7499999);
        t1.setName("Thread1");
        MyThread t2 = new MyThread(7500001, 14999999);
        t2.setName("Thread2");
        MyThread t3 = new MyThread(15000001, 22499999);
        t3.setName("Thread3");
        MyThread t4 = new MyThread(22500001, 30000000);
        t4.setName("Thread4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Time A: " + (System.currentTimeMillis() - ti1));
        System.out.println("Total A: " + (t1.getTotal() + t2.getTotal() + t3.getTotal() + t4.getTotal()));
    }

    private static void exercicioB() {
        long ti2 = System.currentTimeMillis();

        MyThread t1 = new MyThread(90000001, 97499999);
        t1.setName("Thread1");
        MyThread t2 = new MyThread(97500001, 104999999);
        t2.setName("Thread2");
        MyThread t3 = new MyThread(105000001, 112499999);
        t3.setName("Thread3");
        MyThread t4 = new MyThread(112500001, 120000001);
        t4.setName("Thread4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Time B: " + (System.currentTimeMillis() - ti2));
        System.out.println("Total B: " + (t1.getTotal() + t2.getTotal() + t3.getTotal() + t4.getTotal()));
    }
}
