package ReajustaSalárioIPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        double salarioAtual, salarioReajuste =0; 
        int cargo;
        //char opr = '\n';

        ServerSocket servidor = new ServerSocket(5555);
        System.out.println("Porta 5555 aberta!");


        System.out.print("Aguardando conexão do cliente...");
        Socket cliente = servidor.accept();

        System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());


        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        cargo = dados.readInt();
        salarioAtual = dados.readDouble();

        if (cargo == 1) {

            //operador;
            salarioReajuste = (salarioAtual*1.2);

        } else if (cargo == 2) {

            //programador;
        	salarioReajuste = (salarioAtual*1.18);

        
        }

        resultado.writeDouble(salarioReajuste);
        //resultado.writeChar(opr);
        resultado.flush();

        resultado.close();
        dados.close();
        servidor.close();
    }
}