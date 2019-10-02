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
		while (true) 
		{
		// On accepte une demande de connexion d'un client
		Socket client=ecoute.accept();
		System.out.println("vous etes en connexion");
		/*InputStream in = s.getInputStream();
		 OutputStream out = s.getOutputStream();
		 ObjectInputStream objIn = new ObjectInputStream(in);
		 ObjectOutputStream objOut = new ObjectOutputStream(out);
		Integer I= new Ineger(3);
		objOut.writeObject(I);
		UnObjet O= (UnObjet)objIn.readObject(O);*/
		client.close();
		}
		}
		catch (IOException e) {
		 System.err.println(e.getMessage());
		 System.exit(1);

								}
		}
}
