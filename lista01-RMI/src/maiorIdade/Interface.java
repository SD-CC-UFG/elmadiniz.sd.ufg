package maiorIdade;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
	
	
	public char calculaMaiorIdade(int idade, char sexo) throws RemoteException;
	

}
