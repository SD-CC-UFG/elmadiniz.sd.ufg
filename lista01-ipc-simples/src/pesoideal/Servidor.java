package pesoideal;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

    	double altura =0;
        double pesoIdeal = 0;
        char sexo;
        
         ServerSocket servidor = new ServerSocket(5555);
         System.out.println("Porta 5555 aberta!");


         System.out.print("Aguardando conexão do cliente...");
         Socket cliente = servidor.accept();

         System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());
         
         ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
         ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        sexo = dados.readChar();
        altura = dados.readDouble();
                
        if( sexo == 'F' || sexo == 'f' ){
        	
        	pesoIdeal = ((72.7*altura) - 58);
        	
        }else if( sexo == 'M' || sexo == 'm' ){
        	
        	pesoIdeal = ((62.1*altura) - 44);
        	
        }
        	

        resultado.writeDouble(pesoIdeal);
        resultado.flush();

        resultado.close();
        dados.close();
        servidor.close();
    }
}