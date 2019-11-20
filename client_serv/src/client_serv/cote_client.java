package client_serv;
import java.io.*;
import java.net.*;
import java.util.*;
public class cote_client {
private static String serverhost = "localhost";
private static int PORT = 49252;
static Scanner sc = new Scanner(System.in);
public static String name = "k" ;
public static int i;

public static void main(String[] args)
 {
	
	Socket s=null;
	try 
	{
		s=new Socket (serverhost,PORT);//création du socket
		System.out.println("client n°"+cote_client.PORT+"conneter");
		
		// Récuperation des flux entrer/sortie
		OutputStream out = s.getOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		
		InputStream in = s.getInputStream();
		ObjectInputStream objIn = new ObjectInputStream(in);
		
		Integer I;
		try
		{
			I = (Integer)objIn.readObject();
			System.out.println("J'ais reçu "+I+I.getClass().getName()+I.getClass().getFields()[0].getName());
			
		}catch(ClassNotFoundException e) {e.printStackTrace();}
		//stock_object O= new stock_object() ;
		
		//récuperation saisie console
		System.out.println("Saisissez un mot");
		String str = sc.nextLine();
		
		//envoyer saisie au serveur
		objOut.writeObject(str);
		System.out.println("envoyé au serveur:"+str);
		
		// fermer le client
		s.close();
	}catch (IOException e) {System.err.println(e);}
 }
}
