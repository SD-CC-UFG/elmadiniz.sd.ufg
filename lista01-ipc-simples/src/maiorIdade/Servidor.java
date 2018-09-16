package maiorIdade;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

    	int idade = 0;
        char sexo = 'd';
        char maiorIdade = 'a';
      

        ServerSocket servidor = new ServerSocket(5555);
        System.out.println("Porta 5555 aberta!");


        System.out.print("Aguardando conexão do cliente...");
        Socket cliente = servidor.accept();

        System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());


        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        idade = dados.readInt();
        sexo = dados.readChar();
        

        if (sexo == 'm' || sexo == 'M') {
        	
        	if (idade < 18){
        		
        		maiorIdade = 'N';
        				
        	}else 
        	
        	{
        		maiorIdade = 'S';
        	}

        } else if (sexo == 'f' || sexo == 'F') {
        	
        	if (idade < 21){
        		
        		maiorIdade = 'N';
        		
        	}else 
        	
        	{
        		maiorIdade = 'S';
        	}
        
        }

        resultado.writeChar(maiorIdade);
        resultado.flush();

        resultado.close();
        dados.close();
        servidor.close();
    }
}