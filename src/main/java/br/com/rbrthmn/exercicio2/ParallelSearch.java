package main.java.br.com.rbrthmn.exercicio2;

public class ParallelSearch {
    public static int parallelSearch(int x, int[] array, int numThreads) {
        int parts = array.length / numThreads;
        int startIndex = 0;
        int finalIndex = parts;

        for (int i = 1; i <= numThreads; i++) {
             if (i == numThreads) {
                 MyThread thread = new MyThread(x, array, startIndex, array.length - 1);
                 thread.start();
             } else {
                 MyThread thread = new MyThread(x, array, startIndex, finalIndex);
                 thread.start();
             }
            startIndex += parts;
            finalIndex += parts;
        }

        return -1;
    }

    public static void main(String[] args) {
         int[] array = {1, 2, 87, 6, 15};
         parallelSearch(6, array, 3);
    }
}
