package main.java.br.com.rbrthmn.exercicio3;

public class RabbitRace {

    public static void startRace() {
        RabbitThread r1 =  new RabbitThread(1);
        r1.setName("Coelho 1");
        RabbitThread r2 =  new RabbitThread(2);
        r1.setName("Coelho 2");
        RabbitThread r3 =  new RabbitThread(3);
        r1.setName("Coelho 3");
        RabbitThread r4 =  new RabbitThread(4);
        r1.setName("Coelho 4");
        RabbitThread r5 =  new RabbitThread(5);
        r1.setName("Coelho 5");

        r1.start();
        r1.yield();
        r2.start();
        r2.yield();
        r3.start();
        r3.yield();
        r4.start();
        r4.yield();
        r5.start();
        r5.yield();

    }

    public static void main(String[] args) {
        startRace();
    }
}
