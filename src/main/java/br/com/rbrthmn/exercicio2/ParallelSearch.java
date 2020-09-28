package main.java.br.com.rbrthmn.exercicio2;

public class ParallelSearch {
    public static int parallelSearch(int x, int[] A, int numThreads) {
        int parts = A.length / numThreads;
        System.out.println(A.length);
        System.out.println(numThreads);
        System.out.println(parts);

        for (int i = 0; i <= A.length; i++) {
            int[] subArray;
            if (i < parts) {
                subArray.
            }
        }


        for (int i = 1; i <= numThreads; i++) {
            MyThread thread = new MyThread(x, 0, A);
        }
        return -1;
    }

    public static void main(String[] args) {
        final int[] array;
        array = new int[]{1, 2, 87, 6, 15, 3, 1, 2, 0, 5, 5, 78, 65};
        parallelSearch(9, array, 4);
    }
}
