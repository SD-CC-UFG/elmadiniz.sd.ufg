package maiorIdade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
	
	public static void main(String[] args) {
		try {
			
			
			Interface calc = new Implementacao();
			
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
   		 
   		 	Registry registry = LocateRegistry.getRegistry("localhost");			
		
   		 	registry.rebind("Hello", calc);
			System.out.println("calculadora server ready.");
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

			b.read();
		} catch (Exception e) {
			System.out.println("calculadora server main " + e.getMessage());
		}	
	}
}
