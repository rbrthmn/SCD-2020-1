package main.java.br.com.rbrthmn.exercicio1;

public class MyThread extends Thread{
    private final long initialValue;
    private final long finalValue;
    private long total = 0;

    public MyThread(int valorInicial, int valorFinal) {
        this.initialValue = valorInicial;
        this.finalValue = valorFinal;
    }

    public long getTotal() {
        return total;
    }

    @Override
    public void run() {
        for(long i = initialValue; i <= finalValue; i+=2) {
            if (isPrime(i)) {
                System.out.println(i);
                this.total++;
            }
        }
    }

    static boolean isPrime(long n) {
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

