package calculadoraIPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        double num1, num2, total = 0.0;
        int operacao;
        char opr = '\n';

        ServerSocket servidor = new ServerSocket(5555);
        System.out.println("Porta 5555 aberta!");


        System.out.print("Aguardando conexão do cliente...");
        Socket cliente = servidor.accept();

        System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());


        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        operacao = dados.readInt();
        num1 = dados.readDouble();
        num2 = dados.readDouble();

        if (operacao == 1) {

            opr = '+';
            total = (num1 + num2);

        } else if (operacao == 2) {

            opr = '-';
            total = (num1 - num2);

        } else if (operacao == 3) {

            opr = 'x';
            total = (num1 * num2);

        } else {

            opr = '/';
            total = (num1 / num2);

        }

        resultado.writeDouble(total);
        resultado.writeChar(opr);
        resultado.flush();

        resultado.close();
        dados.close();
        servidor.close();
    }
}