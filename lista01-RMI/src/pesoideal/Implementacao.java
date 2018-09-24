package pesoideal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementacao extends UnicastRemoteObject implements Interface {

	int idade,anosTrabalhados;
	String aposentadoria;
	
	protected Implementacao() throws RemoteException {
		super();
	}

	public double pesoIdeal(double altura, char sexo)
	{
       
		double pesoIdeal = 0;
		
		if( sexo == 'F' || sexo == 'f' ){
        	
        	pesoIdeal = ((72.7*altura) - 58);
        	
        }else if( sexo == 'M' || sexo == 'm' ){
        	
        	pesoIdeal = ((62.1*altura) - 44);
        	
        }
        return pesoIdeal;
	}
}
