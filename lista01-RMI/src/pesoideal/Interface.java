package pesoideal;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
	
	
	public double pesoIdeal(double altura, char sexo) throws RemoteException;
	

}
