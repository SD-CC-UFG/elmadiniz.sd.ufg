package Servidor;


import java.io.*;
import java.net.*;

public class Servidor {

	private ServerSocket servidorSocket;
	
	private void criarServidorSocket(int porta) throws IOException 
	{
		servidorSocket = new ServerSocket(porta);
		
	}
	
	private Socket esperaConexao() throws IOException
	{ 
		Socket socket = servidorSocket.accept();
		
		return socket;
		
	}
	
	private void fecharSocket(Socket s) throws IOException 
	{
		s.close();
		
	}
	private void tratarConex�o(Socket socket) throws IOException 
	
	{

		try {
			ObjectOutputStream output = new  ObjectOutputStream ( socket.getOutputStream() );
			ObjectInputStream input = new ObjectInputStream( socket.getInputStream());
			

			String msg = input.readUTF();

			System.out.println("Mensagem recebida do cliente: " + msg);
			
			output.writeUTF("Cliente, estou te enviando sua mensagem antes de finalizarmos a conex�o");
			output.flush();

			
			input.close();
			output.close();

		} catch (IOException e) {
			
		}finally{
			
				fecharSocket(socket);
					
		}
	
	}
	
	public static void main(String[] args) {
		
		try {
			
			
			Servidor servidor = new Servidor();
			System.out.println("Servidor aguardando conex�o...");
			
			servidor.criarServidorSocket(55555);
			System.out.println("Cliente pode conectar! ");
			
			Socket socket = servidor.esperaConexao();
			servidor.tratarConex�o(socket);
			System.out.println("Conex�o com cliente finalizada");
			
				
		
		}catch (IOException e) {
		
		}

	}

}
