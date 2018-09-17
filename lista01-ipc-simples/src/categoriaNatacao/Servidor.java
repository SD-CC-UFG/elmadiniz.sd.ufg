package categoriaNatacao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

    	int idade;
    	String categoria = null ;
        
        ServerSocket servidor = new ServerSocket(5555);
        System.out.println("Porta 5555 aberta!");


        System.out.print("Aguardando conexão do cliente...");
        Socket cliente = servidor.accept();

        System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());


        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        idade = dados.readInt();

        if (idade >= 5 && idade <=7 ) {

        	categoria = " infantil A ";
        	
        } else if (idade >= 8 && idade <=10 ) {

            
        	categoria = " infantil B ";
        	
        }else if (idade >= 11 && idade <= 13 ) {

            
        	categoria = " juvenil A ";
        }
        else if (idade >= 14 && idade <= 17 ) {

            
        	categoria = " juvenil B ";
        }        else if (idade >= 18 ) {

            
        	categoria = " adulto";
        }else {
        	
        	categoria = "Não há categoria para a idade informada";
        	
        }

        resultado.writeUTF(categoria);
        resultado.flush();

        resultado.close();
        dados.close();
        servidor.close();
    }
}