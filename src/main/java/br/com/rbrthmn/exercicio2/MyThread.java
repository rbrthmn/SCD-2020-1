package main.java.br.com.rbrthmn.exercicio2;

public class MyThread extends Thread{
    private final int x;
    private final int index;
    private final int[] array;

    public MyThread(int x, int index, int[] array) {
        this.x = x;
        this.index = index;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = index; i < array.length; i++) {
            if (array[i] == x) {
                notify();
            }
        }
    }
}
