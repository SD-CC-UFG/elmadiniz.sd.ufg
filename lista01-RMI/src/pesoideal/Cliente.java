package pesoideal;

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
			
			  double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite o sua altura: "));
			  char sexo = JOptionPane.showInputDialog("Digite qual seu sexo: F - Feminino ou M - Masculino").charAt(0);
				
		       JOptionPane.showMessageDialog(null,"Seu peso ideal é " + calc.pesoIdeal(altura, sexo));
		       
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
