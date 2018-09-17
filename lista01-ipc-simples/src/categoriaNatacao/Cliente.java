package categoriaNatacao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        
        int idade = 0;
        String categoria;
        
        Socket cliente = new Socket("127.0.0.1", 5555);
        System.out.println("O cliente conectou ao servidor");


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a sua idade: "));
       
        dados.writeInt(idade);
        dados.flush();
        
        categoria = resultado.readUTF();

        JOptionPane.showMessageDialog(null,"Sua categoria em natação é: " + categoria);

        resultado.close();
        dados.close();
        cliente.close();
    }
}