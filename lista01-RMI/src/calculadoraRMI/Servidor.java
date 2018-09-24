package calculadoraRMI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
	
	public static void main(String[] args) {
		try {
			
			
			Interface calc = new Implementacao();
			
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
   		 
   		 	Registry registry = LocateRegistry.getRegistry("localhost");
			
			/**
			System.out.println("Obtendo registro");
			Registry registry = LocateRegistry.getRegistry(5555);
			System.out.println("Servidor Criado");
			registry.rebind("Hello", calc); **/
			
		
   		 	registry.rebind("Hello", calc);
			System.out.println("calculadora server ready.");
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

			b.read();
		} catch (Exception e) {
			System.out.println("calculadora server main " + e.getMessage());
		}	
	}
}
