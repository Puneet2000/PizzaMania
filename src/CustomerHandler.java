import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;



public class CustomerHandler extends Thread {
Socket customer=null;
final DataInputStream dis;
final DataOutputStream dos;
  public CustomerHandler(Socket s, DataInputStream dis, DataOutputStream dos)
  {
	  this.customer = s;
	  this.dis = dis;
	  this.dos =dos;
	  
	  start();
  }
  public void run()
  {
	 
		
		while (true)
		{
			String s;
			try {
				s = dis.readUTF();
				System.out.println("New order Received : "+ s);
				double total =0;
				
	    String message = "Your Total cost  = " + total;
	    
	    dos.writeUTF(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
   
    
		}
		
	} 
  }

