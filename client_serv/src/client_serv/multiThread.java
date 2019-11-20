package client_serv;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.locks.Lock;

public class multiThread extends Thread {
	private Socket client;
	Scanner sc = new Scanner(System.in);
	char NCLI[];
	Object str;
	public multiThread(String name,Socket client){
		super(name) ;
		this.client = client ;
		//private Lock verrou;
		
	}
	
public void run() {
	System.out.println( "le client connecté ("+this.getName()+"): "+client.getInetAddress().toString());
	
	
	OutputStream out;
	try {
		out = client.getOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream (out);
		Integer I= new Integer (3);
		objOut.writeObject(I);
		System.out.println("J'envoie :"+I);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	InputStream in;
	try {
		in = client.getInputStream();
		ObjectInputStream objIn = new ObjectInputStream (in);		
		Object O = (Object)objIn.readObject();
		System.out.println("J'recu :"+O);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//stock_object O (stock_object)objIn.readObject(O);
	try {
		client.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 
}

}
