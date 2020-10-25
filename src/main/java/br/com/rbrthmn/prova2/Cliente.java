package main.java.br.com.rbrthmn.prova2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket consulta = new Socket("localhost", 12345);

        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite uma mensagem para enviar ao servidor");
        String texto = leitor.nextLine();

        PrintStream enviarMsgParaServidor = new PrintStream(consulta.getOutputStream());
        enviarMsgParaServidor.println(texto);

        Scanner ouvirRespostaServidor = new Scanner(consulta.getInputStream());
        String frase = ouvirRespostaServidor.nextLine();
        System.out.println(frase);
        consulta.close();
    }
}
