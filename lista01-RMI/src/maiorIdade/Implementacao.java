package maiorIdade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementacao extends UnicastRemoteObject implements Interface {

	int idade,anosTrabalhados;
	String aposentadoria;
	
	protected Implementacao() throws RemoteException {
		super();
	}
	char maiorIdade;

	public char calculaMaiorIdade(int idade, char sexo)
	{
if (sexo == 'm' || sexo == 'M') {
        	
        	if (idade < 18){
        		
        		maiorIdade = 'N';
        				
        	}else 
        	
        	{
        		maiorIdade = 'S';
        	}

        } else if (sexo == 'f' || sexo == 'F') {
        	
        	if (idade < 21){
        		
        		maiorIdade = 'N';
        		
        	}else 
        	
        	{
        		maiorIdade = 'S';
        	}
        
        }
		
	return maiorIdade;
  
	}
}
