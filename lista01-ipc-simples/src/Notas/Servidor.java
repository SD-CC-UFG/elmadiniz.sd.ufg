package Notas;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Servidor {

    public static void main(String[] args) throws IOException {

    	 double n1=0, n2=0, n3=0, m = 0;
         String aprovacao = null;
        
        ServerSocket servidor = new ServerSocket(5555);
        System.out.println("Porta 5555 aberta!");


        System.out.print("Aguardando conexão do cliente...");
        Socket cliente = servidor.accept();

        System.out.println("Nova conexao com o cliente " + cliente.getInetAddress().getHostAddress());


        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        n1 = dados.readDouble();
        n2 = dados.readDouble();
        
        m = ((n1 + n2)/2);
        
        if( m >= 7){
        	
        	aprovacao = " foi aprovado";
        	
        }else if( m < 7 && m > 3  ){
        	
            
        	JOptionPane.showMessageDialog(null,"Aluno não aprovado realize a N3");
            n3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a terceira nota(a): "));
        	
            if((m+n3)/2 >=5){

            	aprovacao = " foi aprovado";
            	
            }else if ((m+n3)/2 < 5){
            	
            	aprovacao = " não foi aprovado";
            }
            
        	
        } else {
        	
        	aprovacao = " não foi aprovado";
        	
        }

        resultado.writeUTF(aprovacao);
        resultado.flush();

        resultado.close();
        dados.close();
        servidor.close();
    }
}