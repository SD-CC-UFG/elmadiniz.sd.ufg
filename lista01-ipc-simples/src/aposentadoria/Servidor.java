package aposentadoria;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

    	int idade = 0, anosTrabalhados = 0;
    	String aposentadoria;
        
        ServerSocket servidor = new ServerSocket(5555);
        System.out.println("Porta 5555 aberta!");


        System.out.print("Aguardando conexão do cliente...");
        Socket cliente = servidor.accept();

        System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());


        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        idade = dados.readInt();
        anosTrabalhados = dados.readInt();


        if (idade >= 60 && anosTrabalhados >= 25 ) {

        	aposentadoria = " poderá se aposentar";
        	
        } else if (idade >= 65 ) {

        	aposentadoria = " poderá se aposentar";
            
        	
        }else if ( anosTrabalhados >= 30 ) {

            
        	aposentadoria = " poderá se aposentar";

        }
        else {
            
        	aposentadoria = " não poderá se aposentar";
        
        }     
        resultado.writeUTF(aposentadoria);
        resultado.flush();

        resultado.close();
        dados.close();
        servidor.close();
    }
}