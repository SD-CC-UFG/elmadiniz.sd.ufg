package calculadoraRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
	
	public static void main(String[] args) {
		try {
		
			Registry registry = LocateRegistry.getRegistry("localhost");
			Interface calc = (Interface) registry.lookup("Hello");
			
			
			System.out.println(calc.add(3, 5));
			System.out.println(calc.sub(3, 5));
			System.out.println(calc.mul(3, 5));
			System.out.println(calc.div(3, 5));
		
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}
