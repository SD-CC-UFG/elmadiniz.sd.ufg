package aposentadoria;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
	
	
	public String calculaAposentadoria(int idade, int anosTrabalhados) throws RemoteException;
	

}
