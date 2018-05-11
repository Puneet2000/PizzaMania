import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



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
				if(s.equals("Closed"))
					break;
				
				
				Order order = new Gson().fromJson(s,Order.class);
				System.out.println("New order Received :" + order.OrderId);
				double total =0;
				ArrayList<Pizza> p = order.pizza;
				for (Pizza pi : p)
					total = total + pi.getPrice();
				order.price = total*(order.type.getFactor());
		String message = order.generateBill();
		
		dos.writeUTF(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
   
   
		}
		
		try {
			dis.close();
			dos.close();
			customer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 
  }

