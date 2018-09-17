package Notas;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        double n1=0, n2=0;
        String nome;
        
        Socket cliente = new Socket("127.0.0.1", 5555);
        System.out.println("O cliente conectou ao servidor");


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

    	nome = JOptionPane.showInputDialog("Qual nome do Aluno(a)?");
        n1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a primeira nota(a): "));
        n2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a segunda nota(a): "));


        
        dados.writeDouble(n1);
        dados.writeDouble(n2);
     
        dados.flush();
        
        	
        String aprovacao = resultado.readUTF();
        	
        	JOptionPane.showMessageDialog(null,"O Aluno(a) " + nome +  aprovacao);
        
        	resultado.close();
        	dados.close();
        	cliente.close();
        
        }
    }
