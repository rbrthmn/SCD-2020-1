package main.java.br.com.rbrthmn.exercicio3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

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
        BeeperControl beeperControl = new BeeperControl();
        beeperControl.beepForAnHour();
    }
}

class BeeperControl {
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
            public void run() { System.out.println("beep"); }
        };
        final ScheduledFuture<?> beeperHandle =
                scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
        scheduler.schedule(new Runnable() {
            public void run() { beeperHandle.cancel(true); }
        }, 60 * 60, SECONDS);
    }
}
