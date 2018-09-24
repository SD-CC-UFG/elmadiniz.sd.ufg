package maiorIdade;

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
			
			String nome = JOptionPane.showInputDialog("Qual seu nome?");
	    	int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a sua idade."));
			char sexo = JOptionPane.showInputDialog("Digite qual seu sexo: F - Feminino ou M - Masculino").charAt(0);
		
	        
			JOptionPane.showMessageDialog(null,"Maior de idade sim ou não:  " + calc.calculaMaiorIdade(idade, sexo));

		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}
