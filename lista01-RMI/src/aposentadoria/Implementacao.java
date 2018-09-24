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

			aposentadoria = " poder� se aposentar";
        	
        } else if (idade >= 65 ) {

        	aposentadoria = " poder� se aposentar";
            
        	
        }else if ( anosTrabalhados >= 30 ) {

            
        	aposentadoria = " poder� se aposentar";

        }
        else {
            
        	aposentadoria = " n�o poder� se aposentar";
        
        }
		return aposentadoria;     
	}
}
