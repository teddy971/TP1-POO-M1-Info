package client_serv;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
public class cote_serv {
	private static ServerSocket ecoute;
	private static int PORT = 49252;
	public static  int i = 0 ;
	// création des liste de tread
	public static ArrayList<multiThread> Ps = new ArrayList<multiThread>() ;
	public static void main(String [] args) 
	{
		try 
		{
			//on écoute sur le port <PORT> de 49152 jusqu'à 65535 .
			ecoute=new ServerSocket(PORT);
			System.out.println("new serveur");
			while(true)
			{
				//On accepte une demande de connexion d'un client
				Socket client=ecoute.accept();
				System.out.println("client connecter");
				
				multiThread  P = new multiThread("Thread"+i,client) ;
				P.start();
				
				i++;
				/*
				OutputStream out = client.getOutputStream();
				ObjectOutputStream objOut = new ObjectOutputStream (out);
				
				InputStream in = client.getInputStream();
				ObjectInputStream objIn = new ObjectInputStream (in);
				
				Integer I= new Integer (3);
				objOut.writeObject(I);
				
				
				Object O = (Object)objIn.readObject();
				System.out.println("J'envoie :"+I);
				System.out.println("J'recu :"+O);
				//stock_object O (stock_object)objIn.readObject(O);
				client.close();*/
			}
		}catch (IOException e) 
		{
			System.err.println(e.getMessage());
			System.exit(1);
		
		}
	}

}
