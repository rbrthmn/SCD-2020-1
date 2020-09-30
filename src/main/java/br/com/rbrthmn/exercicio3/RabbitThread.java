package main.java.br.com.rbrthmn.exercicio3;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class RabbitThread extends Thread {
    static List<RabbitThread> podium = new ArrayList<RabbitThread>();
    public int index;
    public int runned = 0;
    public int count = 0;

    public RabbitThread(int index) {
        this.index = index;
    }

    public int salto() {
        int distancia = (int) ((Math.random() * 3) + 1);
        count++;
        runned+= distancia;
        System.out.println("Coelho " + index + " saltou " + distancia + " metros.");
        return distancia;
    }

    public static void showPodium() {
        podium.sort(new SortByDistance());
        int i = 1;
        for (RabbitThread rabbit: podium) {
            System.out.println(i + "o Lugar: Coelho " + rabbit.index + " com " + rabbit.count + " pulos e  " + rabbit.runned + " metros percorridos");
            i++;
        }
    }

    @Override
    public void run() {
        while(runned < 20) {
            this.salto();
            Thread.yield();
        }

        podium.add(this);


        if (RabbitThread.podium.size() == 5) {
            RabbitThread.showPodium();
        }
    }
}

class SortByDistance implements Comparator<RabbitThread> {
    public int compare(RabbitThread a, RabbitThread b) {
        return b.runned - a.runned;
    }
}