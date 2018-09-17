package pesoideal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        
    	double altura = 0, pesoIdeal = 0;
        char sexo = 'a';
        
        
        Socket cliente = new Socket("127.0.0.1", 5555);
        System.out.println("O cliente conectou ao servidor");


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

        altura = Double.parseDouble(JOptionPane.showInputDialog("Digite o sua altura: "));
		sexo = JOptionPane.showInputDialog("Digite qual seu sexo: F - Feminino ou M - Masculino").charAt(0);
		
        dados.writeDouble(altura);
        dados.writeChar(sexo);
        dados.flush();
        
        //double 
        pesoIdeal = resultado.readDouble();
        	
        JOptionPane.showMessageDialog(null,"Seu peso ideal é " + pesoIdeal);
        	
        resultado.close();
        dados.close();
        cliente.close();
        
        }
    }
