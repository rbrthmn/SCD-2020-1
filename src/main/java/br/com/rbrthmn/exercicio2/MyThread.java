package main.java.br.com.rbrthmn.exercicio2;

public class MyThread extends Thread{
    private final int x;
    private final int[] array;
    private final int startIndex;
    private final int finalIndex;
    private static int returnedIndex = -1;

    public MyThread(int x, int[] array, int startIndex, int finalIndex) {
        this.x = x;
        this.array = array;
        this.startIndex = startIndex;
        this.finalIndex = finalIndex;
    }

    public static int getReturnedIndex() {
        return returnedIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= finalIndex; i++) {
            if (array[i] == x) {
                returnedIndex = i;
            }
        }
    }
}
