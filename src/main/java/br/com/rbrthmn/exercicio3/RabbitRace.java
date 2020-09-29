package main.java.br.com.rbrthmn.exercicio3;

import main.java.br.com.rbrthmn.exercicio2.MyThread;

import java.util.ArrayList;
import java.util.List;

public class RabbitRace {

    public static void startRace() {
        List<RabbitThread> threads = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            threads.add(i, new RabbitThread(i + 1));
            threads.get(i).start();
        }

    }

    public static void main(String[] args) {
        startRace();
    }
}
