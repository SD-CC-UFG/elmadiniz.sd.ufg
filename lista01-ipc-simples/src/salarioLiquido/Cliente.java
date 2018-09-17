package salarioLiquido;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        double salarioBruto = 0;
        int nivel = 0, dependentes=0;
        String nome;
        
        Socket cliente = new Socket("127.0.0.1", 5555);
        System.out.println("O cliente conectou ao servidor");


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

    	nome = JOptionPane.showInputDialog("Qual nome do(a) funcion�rio(a)?");
        salarioBruto = Double.parseDouble(JOptionPane.showInputDialog("Qual o Sal�rio bruto do(a) Funcion�rio(a): "));
        nivel = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�vel  do(a) funcion�rio(a)? 1 = A, 2 = B, 3 = C ou 4 = D "));
        dependentes = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero de dependentes"));
        
        dados.writeInt(nivel);
        dados.writeInt(dependentes);
        dados.writeDouble(salarioBruto);
        dados.flush();

        double salarioLiquido = resultado.readDouble();

        JOptionPane.showMessageDialog(null,"O Sal�rio l�quido do(a) funcion�rio(a) " + nome + " � " +  salarioLiquido);

        resultado.close();
        dados.close();
        cliente.close();
    }
}