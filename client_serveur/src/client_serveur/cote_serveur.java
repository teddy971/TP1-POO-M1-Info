package client_serveur;

import java.io.*;
import java.net.*;
public class cote_serveur 
{
	private static ServerSocket ecoute ;
	public static void main(String[] args)
	{
	try {
		// On écoute sur le port <PORT> de 49152 jusqu'a 65535.
		 ecoute=new ServerSocket(49252);
		 System.out.println("new serveur");
		while (true) 
		{
		// On accepte une demande de connexion d'un client
		
		Socket client=ecoute.accept();
		System.out.println("client connecter");
		
		OutputStream out = client.getOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		
		InputStream in = client.getInputStream();
		ObjectInputStream objIn = new ObjectInputStream(in);
		 
		Integer I= new Integer(3);
		objOut.writeObject(I);
		System.out.println("J'envoie : "+I);
		//stock_object O= (stock_object)objIn.readObject(O);
		client.close();
		}
		}
		catch (IOException e) {
		 System.err.println(e.getMessage());
		 System.exit(1);

								}
		}
}
