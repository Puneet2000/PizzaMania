
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class PizzaCustomer {
 ArrayList<Menu> menu;
 ArrayList<Pizza> pizzas;
	public static void main(String args[])
	{
		new PizzaCustomer().drawGUI();
	}
   
	private void drawGUI()
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
               for (Menu m : menu)
                 pizzas.add(m.getPizza());
               for(Pizza p : pizzas)
                System.out.println("Cost of Pizza is "+ p.getPrice());
                jtp.removeAll();
                if(menu.size()>0)
                {JOptionPane.showMessageDialog(frame,
                	    "Your order has been Placed \n Thankyou");
                  menu.clear();
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
