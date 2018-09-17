package aposentadoria;

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
        int anosTrabalhados;
        
        Socket cliente = new Socket("127.0.0.1", 5555);
        System.out.println("O cliente conectou ao servidor");

        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

    	nome = JOptionPane.showInputDialog("Qual nome do(a) funcionário(a)?");
    	idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do(a) funcionário(a): "));
    	anosTrabalhados = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de anos trabalhadas do(a) funcionário(a): "));
       
        dados.writeInt(idade);
        dados.writeInt(anosTrabalhados);

        dados.flush();
        
        String aposentadoria = resultado.readUTF();

        JOptionPane.showMessageDialog(null,"O(a) funcionário(a): " + nome + aposentadoria);

        resultado.close();
        dados.close();
        cliente.close();
    }
}