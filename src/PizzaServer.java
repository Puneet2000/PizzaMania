import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.naming.Context;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class PizzaServer {
	public static ServerSocket server = null;
	
	  public static DefaultTableModel dtm;
	 public static Context c;
	
	public static void main (String args[])
	{
		try {
			server = new ServerSocket(5000);
			System.out.println("Server Started");
			new PizzaServer().GUI();
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
	
	private void GUI()
	{
		JFrame frame = new JFrame("Pizza Mania");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                try {
					server.close();
					System.out.println("Server closed");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        JPanel topbar = new JPanel();
        
        JLabel label = new JLabel("Pizza Mania Server");
        label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 20));
        topbar.add(label);
        JPanel jsp = new JPanel();
       jsp.setSize(500,200);
      
       
       dtm = new DefaultTableModel();
       JTable tbl = new JTable(dtm);
       tbl.setModel(dtm);
       dtm.addColumn(new Object [] {"ORDER"});
       dtm.addRow(new Object [] {"Puneet"});
      
       TableColumn column = tbl.getColumnModel().getColumn(0);
    		   column.setPreferredWidth(500);
     
        jsp.add(tbl);
        
        JSplitPane x =new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,topbar,jsp);
        x.setDividerSize(3);
        frame.getContentPane().add(x);
        frame.setVisible(true);
        
        
        
        
	}
	public void addData (Object [] data)
	{
		dtm.addRow(data);
	}

}
