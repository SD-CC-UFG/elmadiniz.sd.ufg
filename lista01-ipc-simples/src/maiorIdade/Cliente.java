package maiorIdade;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {

    	int idade = 0;
        String nome;
        char sexo = 'd';
        
        Socket cliente = new Socket("127.0.0.1", 5555);
        System.out.println("O cliente conectou ao servidor");


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

        nome = JOptionPane.showInputDialog("Digite o nome da pessoa.");
		sexo = JOptionPane.showInputDialog("Digite o sexo da pessoa: 'M' ou 'F'").charAt(0);
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade da pessoa."));
        
        while (!((sexo != 'm') || (sexo != 'f'))) {
    		sexo = JOptionPane.showInputDialog("Digite o sexo da pessoa: 'M' ou 'F'").charAt(0);
            if (!((sexo != 'm') || (sexo != 'f'))) {
                System.out.println("Você digitou um sexo inexistente.");
            }
        }
        dados.writeInt(idade);
        dados.writeChar(sexo);
        dados.flush();

       char maiorIdade =  resultado.readChar();
       

        JOptionPane.showMessageDialog(null,nome +  " é maoir de idade?  "  + maiorIdade);

        resultado.close();
        dados.close();
        cliente.close();
    }
}