package client_serveur;

import java.io.*;
import java.net.*;

public class cote_client {
	private static String serverhost = "localhost";
	private static int PORT = 49252;
	public String name = "k" ; 
	public static void main(String[] args)
	{
	
	
	Socket s=null;
	 try { s=new Socket(serverhost,PORT); // Cr�ation du socket
	 System.out.println("client n� "+cote_client.PORT+ " conneter");
	 // R�cup�ration des flux d�entr�e/sortie
	 OutputStream out = s.getOutputStream();
	 InputStream in = s.getInputStream();
	 
	 ObjectOutputStream objOut = new ObjectOutputStream(out);
	 ObjectInputStream objIn = new ObjectInputStream(in);
	
	 Integer I;
	try {
		I = (Integer)objIn.readObject();
		System.out.println("J'ai re�u "+I);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //stock_object O= new stock_object() ;
	 //objOut.writeObject(O);
	 s.close();
	} catch (IOException e) {System.err.println(e);}
	
	}
}
