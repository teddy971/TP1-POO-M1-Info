package client_serv;
import java.io.*;
import java.lang.reflect.Field;
import java.net.*;
import java.util.*;
import java.util.concurrent.locks.*;


public class multiThread extends Thread implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Socket client;
	Scanner sc = new Scanner(System.in);
	private int index = 0;
	char NCLI[];
	Object str;
    private final Lock lock = new ReentrantLock();
   /* private final Condition cond1 = lock.newCondition();
    private final Condition cond2 = lock.newCondition();*/
	public multiThread(String name,Socket client){
		super(name) ;
		this.client = client ;
		//private Lock verrou;
		
	}
	
public void run() /*throws InterruptedException*/{
	System.out.println( "le client connecté ("+this.getName()+"): "+client.getInetAddress().toString());
	
	lock.lock();
	try {
	OutputStream out;
	try {
		out = client.getOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream (out);
		//Integer I= new Integer (3);
		objOut.writeObject(cote_serv.LO.get(0));
		//System.out.println("J'envoie :"+cote_serv.LO.get(0));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//cond1.await();
    //cond2.signal();
	} finally {lock.unlock();}
        
	
	
	lock.lock();
	try {
	InputStream in;
	try {
		in = client.getInputStream();
		ObjectInputStream objIn = new ObjectInputStream (in);		
		Object O = (Object)objIn.readObject();
		cote_serv.L1.add(O);
		//System.out.println("J'recu :"+O);
		for( Field f : O.getClass().getDeclaredFields() ) {
			f.setAccessible(true);
			System.out.println("Liste : "+f.get(O));}
			//String str = sc.nextLine();
			//f.set(O, str);
		//System.out.println("Liste : "+ cote_serv.L1);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
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
	} finally {lock.unlock();}
	 
	 
}

}
