package calculadoraIPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        double num1;
        double num2;
        int operacao = 0;
        char opr;
        Socket cliente = new Socket("127.0.0.1", 5555);
        System.out.println("O cliente conectou ao servidor");


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());


        num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro n�mero"));
        num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo n�mero"));
        while (!((operacao >= 1) && (operacao <= 4))) {
            operacao = Integer.parseInt(JOptionPane.showInputDialog("Qual opera��o desejada? 1= +, 2= -,3= X,4= / "));
            if (!((operacao >= 1) && (operacao <= 4))) {
                System.out.println("Voc� digitou uma opera��o inv�lida.");
            }
        }
        dados.writeInt(operacao);
        dados.writeDouble(num1);
        dados.writeDouble(num2);
        dados.flush();

        double total = resultado.readDouble();
        opr = resultado.readChar();
        //System.out.println("Total de " + num1 + opr + num2 + " = " + total);
        JOptionPane.showMessageDialog(null, "Total de " + num1 + opr + num2 + " = " + total);

        resultado.close();
        dados.close();
        cliente.close();
    }
}