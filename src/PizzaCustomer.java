
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class PizzaCustomer {
 
	public static void main(String args[])
	{
		new PizzaCustomer().drawGUI();
	}
   
	private void drawGUI()
	{
		int count =1;
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
        
        jtp.addTab("New Pizza",new Menu());
        
        JSplitPane x =new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,middlebar,jtp);
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
                true, topbar, x);
        x.setDividerSize(0);
        splitPane.setDividerSize(0);
    
        frame.getContentPane().add(splitPane);
        select.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jtp.addTab("New Pizza", new Menu());
                
            }
        }
      );
        
        
              frame.setVisible(true);
	}
}
