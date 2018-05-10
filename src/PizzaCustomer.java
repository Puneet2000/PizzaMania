
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class PizzaCustomer {
 ArrayList<Menu> menu;
	public static void main(String args[])
	{
		new PizzaCustomer().drawGUI();
	}
   
	private void drawGUI()
	{
		int count =1;
		menu = new ArrayList<Menu>();
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
        middlebar.add(select);
        middlebar.add(Box.createHorizontalStrut(20));
        middlebar.add(order);
        middlebar.add(Box.createHorizontalStrut(20));
        middlebar.add(feedback);
        
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
        
        order.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               
                Menu m = menu.get(menu.size()-1);
                Pizza p = m.getPizza();
                System.out.println("Cost of Pizza is "+ p.getPrice());
            }
        }
      );
      
              frame.setVisible(true);
	}
}
