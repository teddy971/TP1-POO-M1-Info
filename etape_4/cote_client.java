package etape_4;

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
		s=new Socket (serverhost,PORT);//cr�ation du socket 
 		System.out.println("client n�"+cote_client.PORT+"conneter"); 
 		 
 		// R�cuperation des flux entrer/sortie 
 		OutputStream out = s.getOutputStream(); 
 		ObjectOutputStream objOut = new ObjectOutputStream(out); 
 		 
 		InputStream in = s.getInputStream(); 
 		ObjectInputStream objIn = new ObjectInputStream(in); 
 		 
		Object I; 
 		try 
 		{ 
 			I = (Object)objIn.readObject();
 			System.out.println("j'ai obtenu"); 
 			for( Field f : I.getClass().getDeclaredFields() ) { 
 				f.setAccessible(true);
 				String finc = f.getType().getName();
 				if(f.getType()==String.class)
 				{
 				System.out.println("Entrez le : "+f.getName()+" de type "+finc.substring(finc.lastIndexOf('.')+1, finc.length())); 
 				String str = sc.nextLine();
 				//objOut.writeObject(str);
 				f.set(I, str); 
 				}
 				else if(f.getType()==int.class)
 				{
 				System.out.println("Entrez le : "+f.getName()+"de type "+finc.substring(finc.lastIndexOf('.')+1, finc.length())); 
 				int sti = sc.nextInt();				
 				f.set(I, sti); 
 				}
 

 			} 
 			//System.out.println("J'ais re�u "+I+I.getClass().getName()+I.getClass().getFields()[0].getName()); 
 			//stock_object O= new stock_object() ; 
 			 
 			//r�cuperation saisie console 
 			//System.out.println("Saisissez un mot"); 
 			//String str = sc.nextLine(); 
 			 
 			//envoyer saisie au serveur 
 			objOut.writeObject(I); 
			//System.out.println("envoy� au serveur:"+I); 
		}catch(ClassNotFoundException e) {e.printStackTrace();} 
 
 
 		 
 		// fermer le client 
 		s.close(); 
 	}catch (IOException e) {System.err.println(e);} 
  } 
 } 
