import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PizzaServer {
	public static ServerSocket server = null;
	
	public static void main (String args[])
	{
		try {
			server = new ServerSocket(5000);
			while (true)
			{
				try {
					Socket s = server.accept();
					DataInputStream dis = new DataInputStream(s.getInputStream());
		            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
					System.out.println("New customer joined");
					new CustomerHandler(s,dis,dos);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
