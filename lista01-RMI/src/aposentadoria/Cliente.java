package aposentadoria;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class Cliente {
	
	public static void main(String[] args) {
		
		try {
		
			Registry registry = LocateRegistry.getRegistry("localhost");
			Interface calc = (Interface) registry.lookup("Hello");
			
			String nome = JOptionPane.showInputDialog("Qual nome do(a) funcion�rio(a)?");
	    	int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do(a) funcion�rio(a): "));
	    	int anosTrabalhados = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de anos trabalhadas do(a) funcion�rio(a): "));
		
	        
			JOptionPane.showMessageDialog(null,"O(a) funcion�rio(a): " + nome + calc.calculaAposentadoria(idade, anosTrabalhados));

		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}
