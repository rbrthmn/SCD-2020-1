package main.java.br.com.rbrthmn.exercicio3;

public class RabbitRace {

    public static void startRace() {
        RabbitThread r1 = new RabbitThread(1);
        RabbitThread r2 = new RabbitThread(2);
        RabbitThread r3 = new RabbitThread(3);
        RabbitThread r4 = new RabbitThread(4);
        RabbitThread r5 = new RabbitThread(5);

       r1.start();
       r2.start();
       r3.start();
       r4.start();
       r5.start();
    }

    public static void main(String[] args) {
        startRace();
    }
}
