package client_serveur;

import java.io.*;
import java.net.*;

public class cote_client {
	private static String serverhost = "localhost";
	private static int PORT = 49252;
	public static void main(String[] args)
	{
	
	
	Socket s=null;
	 try { s=new Socket(serverhost,PORT); // Création du socket
	 System.out.println("client n° conneter");
	 // Récupération des flux d’entrée/sortie
	 /*InputStream in = s.getInputStream();
	 OutputStream out = s.getOutputStream();
	 ObjectInputStream objIn = new ObjectInputStream(in);
	 ObjectOutputStream objOut = new ObjectOutputStream(out);
	 Integer I= (Integer)objIn.readObject();
	 UnObjet O= new UnObjet() ;
	 objOut.writeObject(O);*/
	 s.close();
	} catch (IOException e) {System.err.println(e);}
	
	}
}
