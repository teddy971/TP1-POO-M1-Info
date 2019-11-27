package client_serv;
import java.io.*;
import java.lang.reflect.Field;
import java.net.*;
import java.util.*;
public class cote_client implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static String serverhost = "localhost";
private static int PORT = 49252;
static Scanner sc = new Scanner(System.in);
public static String name = "k" ;
public  int i;

public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException
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
		
		Object I;
		try
		{
			I = (Object)objIn.readObject();
			System.out.println("ja'ais obtenu");
			for( Field f : I.getClass().getDeclaredFields() ) {
				f.setAccessible(true);
				System.out.println("Entrez le : "+f.getName());
				String str = sc.nextLine();
				f.set(I, str);

			}
			//System.out.println("J'ais reçu "+I+I.getClass().getName()+I.getClass().getFields()[0].getName());
			//stock_object O= new stock_object() ;
			
			//récuperation saisie console
			//System.out.println("Saisissez un mot");
			//String str = sc.nextLine();
			
			//envoyer saisie au serveur
			objOut.writeObject(I);
			System.out.println("envoyé au serveur:"+I);
		}catch(ClassNotFoundException e) {e.printStackTrace();}

		
		// fermer le client
		s.close();
	}catch (IOException e) {System.err.println(e);}
 }
}
