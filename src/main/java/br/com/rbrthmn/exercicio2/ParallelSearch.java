package main.java.br.com.rbrthmn.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class ParallelSearch {

    public static int parallelSearch(int x, int[] array, int numThreads) throws InterruptedException {
        int parts = array.length / numThreads;
        int startIndex = 0;
        int finalIndex = parts - 1;
        List<MyThread> threads = new ArrayList<>();

        for (int i = 1; i <= numThreads; i++) {

            if (i == numThreads) {
                threads.add(i - 1, new MyThread(x, array, startIndex, array.length - 1));
            } else {
                threads.add(i - 1, new MyThread(x, array, startIndex, finalIndex));
            }

            threads.get(i - 1).start();
            startIndex += parts;
            finalIndex += parts;
        }

        for (int i = 0; i < numThreads; i++) {
            threads.get(i).join();
            if (MyThread.getReturnedIndex() != -1) {
                return MyThread.getReturnedIndex();
            }
        }
        return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 2, 4, 87, 6, 15, 8, 9};
        System.out.println(parallelSearch(9, array, 3));
    }
}
