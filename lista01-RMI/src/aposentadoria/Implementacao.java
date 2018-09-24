package aposentadoria;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementacao extends UnicastRemoteObject implements Interface {

	int idade,anosTrabalhados;
	String aposentadoria;
	
	protected Implementacao() throws RemoteException {
		super();
	}

	public String calculaAposentadoria(int idade, int anosTrabalhados)
	{
		if (idade >= 60 && anosTrabalhados >= 25 ) {

			aposentadoria = " poderá se aposentar";
        	
        } else if (idade >= 65 ) {

        	aposentadoria = " poderá se aposentar";
            
        	
        }else if ( anosTrabalhados >= 30 ) {

            
        	aposentadoria = " poderá se aposentar";

        }
        else {
            
        	aposentadoria = " não poderá se aposentar";
        
        }
		return aposentadoria;     
	}
}
