	package Cliente;
	
import java.io.*;
import java.net.*;
import java.util.logging.Logger;


public class Cliente {
	

	public static void main(String[] args) 
	
	{
								
			try {	
				Socket socket = new Socket("localhost",55555);
				
				ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

					
			String msg = "Estou conectado ao servidor...";
			output.writeUTF(msg);
			output.flush();
			
			msg = input.readUTF();
			System.out.println("Resposta:  " + msg);
			
			input.close();
			output.close();
			socket.close();
			
			
			} catch (IOException ex) {
			
				Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);	
			
			}
	}

}
