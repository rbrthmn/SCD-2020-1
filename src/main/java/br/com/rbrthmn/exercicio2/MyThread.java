package main.java.br.com.rbrthmn.exercicio2;

public class MyThread extends Thread{
    private final int x;
    private final int[] array;
    private final int startIndex;
    private final int finalIndex;

    public MyThread(int x, int[] array, int startIndex, int finalIndex) {
        this.x = x;
        this.array = array;
        this.startIndex = startIndex;
        this.finalIndex = finalIndex;
    }

    @Override
    public void run() {
        System.out.println("index inicial " + startIndex);
        System.out.println("index final " + finalIndex);
        for (int i = startIndex; i < finalIndex; i++) {
            if (array[i] == x) {
                System.out.println("Valor encontrado no índice " + i);
            }
        }
//        System.out.println("Valor não encontrado");
    }
}
