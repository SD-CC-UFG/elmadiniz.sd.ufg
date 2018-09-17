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

    	nome = JOptionPane.showInputDialog("Qual nome do(a) funcionário(a)?");
        salarioBruto = Double.parseDouble(JOptionPane.showInputDialog("Qual o Salário bruto do(a) Funcionário(a): "));
        nivel = Integer.parseInt(JOptionPane.showInputDialog("Digite o nível  do(a) funcionário(a)? 1 = A, 2 = B, 3 = C ou 4 = D "));
        dependentes = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de dependentes"));
        
        dados.writeInt(nivel);
        dados.writeInt(dependentes);
        dados.writeDouble(salarioBruto);
        dados.flush();

        double salarioLiquido = resultado.readDouble();

        JOptionPane.showMessageDialog(null,"O Salário líquido do(a) funcionário(a) " + nome + " é " +  salarioLiquido);

        resultado.close();
        dados.close();
        cliente.close();
    }
}