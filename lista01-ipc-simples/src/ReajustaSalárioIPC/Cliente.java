package ReajustaSalárioIPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        double salarioAtual = 0;
        int cargo = 0;
        String nome;
        
        Socket cliente = new Socket("127.0.0.1", 5555);
        System.out.println("O cliente conectou ao servidor");


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

    	nome = JOptionPane.showInputDialog("Qual nome do funcionário(a)?");
        salarioAtual = Double.parseDouble(JOptionPane.showInputDialog("Qual o Salário Atual do Funcionário(a): "));
        cargo = Integer.parseInt(JOptionPane.showInputDialog("Digite cargo do funcionário(a)? 1 = Operador, 2 = Programador"));
        
            if (!((cargo >= 1) && (cargo <= 2))) {
                System.out.println("Você digitou um cargo inválid0.");
            }
        
        dados.writeInt(cargo);
        dados.writeDouble(salarioAtual);
        dados.flush();

        double salarioReajuste = resultado.readDouble();

        JOptionPane.showMessageDialog(null,"O Salário do(a) funcionário(a) " + nome + " foi reajustado para o valor de " +  salarioReajuste);

        resultado.close();
        dados.close();
        cliente.close();
    }
}