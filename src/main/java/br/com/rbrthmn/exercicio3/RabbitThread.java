package main.java.br.com.rbrthmn.exercicio3;

public class RabbitThread extends Thread {
    public int index;
    public int runned = 0;
    public int count = 0;

    public RabbitThread(int index) {
        this.index = index;
    }

    public int salto() {
        return (int) ((Math.random() * 3) + 1);
    }

    @Override
    public void run() {
        while(runned <= 20) {
            int pulo = salto();
            System.out.println("Coelho " + index + " saltou " + pulo + " metros.");
            count++;
            runned+= pulo;
        }
        System.out.println("Coelho " + index + " chegou com " + count + " pulos!");
    }
}
