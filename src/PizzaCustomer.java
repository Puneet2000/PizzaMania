
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.Box;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import org.apache.commons.io.IOUtils;

import com.google.gson.GsonBuilder;
public class PizzaCustomer{
 ArrayList<Menu> menu;
 ArrayList<Pizza> pizzas;
public static  Socket socket = null;
public static DataInputStream dis ;
public static DataOutputStream dos ;

 
	public static void main(String args[])
	{
		try {
			socket = new Socket("localhost",5000);
			new PizzaCustomer().drawGUI();
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
   
	public void drawGUI()
	{
		
		
		
		
		menu = new ArrayList<Menu>();
		pizzas = new ArrayList<Pizza>();
		JFrame frame = new JFrame("Pizza Mania");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        JPanel topbar = new JPanel();
        
        JLabel label = new JLabel("Welcome to Pizza Mania");
        label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 20));
        topbar.add(label);
         
        JPanel middlebar  = new JPanel();
    
        JButton select = new JButton("New Pizza");
        JButton feedback = new JButton("Feedback");
        JButton order = new JButton("Order");
        JButton help = new JButton("Help");
        middlebar.add(select);
        middlebar.add(Box.createHorizontalStrut(20));
        middlebar.add(order);
        middlebar.add(Box.createHorizontalStrut(20));
        middlebar.add(feedback);
        middlebar.add(Box.createHorizontalStrut(20));
        middlebar.add(help);
        
        JTabbedPane jtp = new JTabbedPane();
        
        JSplitPane x =new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,middlebar,jtp);
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
                true, topbar, x);
        x.setDividerSize(0);
        splitPane.setDividerSize(0);
    
        frame.getContentPane().add(splitPane);
        select.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	Menu m = new Menu();
            	menu.add(m);
                jtp.addTab("New Pizza", m);
                
            }
        }
      );
        help.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(frame,
                	    "Contact- 99999XXXX \nAddress - Shop No-2 ,Second Floor, Main road , Faridabad");
                
            }
        }
      );
        
        order.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	pizzas.clear();
               
                if(menu.size()>0)
                {
                	for (Menu m : menu)
                        pizzas.add(m.getPizza());
                     try {
                    	
                    	 String Json = new GsonBuilder().setPrettyPrinting().create().toJson(pizzas);
						dos.writeUTF(Json);
						
					

						while (true)
					{       
							String r = dis.readUTF();
							System.out.println(r);
							
							break;
						}
						jtp.removeAll();
	                	JOptionPane.showMessageDialog(frame,
	                	    "Your order has been Placed \n Thankyou");
	                  menu.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                       
                }
                else
                {
                	JOptionPane.showMessageDialog(frame,
                		    "No pizzas selected",
                		    "Inane error",
                		    JOptionPane.ERROR_MESSAGE);
                }
            }
        }
      );
      
              frame.setVisible(true);
	}
}
