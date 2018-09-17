package salarioLiquido;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        double salarioBruto = 0, salarioLiquido = 0;
        int nivel = 0, dependentes=0;

        ServerSocket servidor = new ServerSocket(5555);
        System.out.println("Porta 5555 aberta!");


        System.out.print("Aguardando conexão do cliente...");
        Socket cliente = servidor.accept();

        System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());


        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        nivel = dados.readInt();
        dependentes = dados.readInt();
        salarioBruto = dados.readDouble();

        if (nivel == 1) {
        	
        	if(dependentes < 0){
        	
        		salarioLiquido = (salarioBruto*0.97);
        	
        	}else {
        	
        		salarioLiquido = (salarioBruto*0.92);
          	
        	}
        		
        } else if (nivel == 2) {

        	if(dependentes < 0){
            	
        		salarioLiquido = (salarioBruto*0.95);
        	
        	}else {
        	
        		salarioLiquido = (salarioBruto*0.90);
          	
        	}
        
        }else if (nivel == 3) {

        	if(dependentes < 0){
            	
        		salarioLiquido = (salarioBruto*0.92);
        	
        	}else {
        	
        		salarioLiquido = (salarioBruto*0.85);
          	
        	}
        
        }else if (nivel == 4) {

            	if(dependentes < 0){
                	
            		salarioLiquido = (salarioBruto*0.90);
            	
            	}else {
            	
            		salarioLiquido = (salarioBruto*0.83);
              	
            	}
        }
        	

        resultado.writeDouble(salarioLiquido);
        resultado.flush();

        resultado.close();
        dados.close();
        servidor.close();
    
}

}