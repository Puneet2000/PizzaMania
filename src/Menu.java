import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class Menu extends JPanel{
	public ArrayList<JRadioButton> btn1 ,btn2,btn3,btn4;
	
	public ButtonGroup bg1,bg2,bg3,bg4;
	  Box p1,p2,p3,p4;
	  JPanel jp,jp1;
	  JTextField jtext;
	  
	public JSplitPane j0,j1 ;
	public JSplitPane j2 ;
	public JSplitPane j3,j4 ;
	
	
	Menu (){
		setLayout(new BorderLayout());
		setSize(800,400);
		btn1= new ArrayList<JRadioButton>();
		btn2= new ArrayList<JRadioButton>();
		btn3= new ArrayList<JRadioButton>();
		btn4= new ArrayList<JRadioButton>();
		Breads allBreads[] = Breads.values(); 
		Sizes allSizes[] = Sizes.values();
		Toppings allTopps[] = Toppings.values();
		Cheese allCheese[] = Cheese.values();
		for(Breads a : allBreads)
			btn1.add(new JRadioButton(a.toString()));
		for(Sizes a : allSizes)
			btn2.add(new JRadioButton(a.toString()));
		for(Toppings a : allTopps)
			btn3.add(new JRadioButton(a.toString()));
		for(Cheese a : allCheese)
			btn4.add(new JRadioButton(a.toString()));
		bg1 = new ButtonGroup();
		bg2 = new ButtonGroup();
		bg3 = new ButtonGroup();
		bg4 = new ButtonGroup();
		for(JRadioButton a : btn1)
			bg1.add(a);
		for(JRadioButton a : btn2)
			bg2.add(a);
		for(JRadioButton a : btn3)
			bg3.add(a);
		for(JRadioButton a : btn4)
			bg4.add(a);
		
		p1 = Box.createVerticalBox();
		p2  = Box.createVerticalBox();
		p3  = Box.createVerticalBox();
		p4  = Box.createVerticalBox();
		for(JRadioButton a : btn1)
			p1.add(a);
		for(JRadioButton a : btn2)
			p3.add(a);
		for(JRadioButton a : btn3)
			p2.add(a);
		for(JRadioButton a : btn4)
			p4.add(a);
		jp = new JPanel();
		JLabel jlbl = new JLabel("Quantity");
		jtext = new JTextField("1");
		jtext.setColumns(10);
		jp.add(jlbl);
		jp.add(jtext);
		jp1 = new JPanel();
		JLabel jlabel = new JLabel(new ImageIcon("pizza.jpg"));
		jp1.add(jlabel);
		j1 =new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,p1,p3);
		j1.setDividerSize(3);
		j0 =new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,p4,jp);
		j0.setDividerSize(3);
		j2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,p2,j0);
		j2.setDividerSize(3);
		j3 =new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,j1,j2);
		j3.setDividerSize(0);
		j4=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,j3,jp1);
		j4.setDividerSize(0);
		add(j4);
		
		
	}
	public Pizza getPizza()
	{
		String bread="REGULAR_BASE";
		String size ="REGULAR";
		String Topping ="ONION";
		String cheese ="NORMAL";
		String quantity ="1";
		for(JRadioButton a : btn1)
		{
		 if(a.isSelected())
			 bread = a.getText();
		}
		for(JRadioButton a : btn2)
		{
		 if(a.isSelected())
			 size = a.getText();
		}
		for(JRadioButton a : btn3)
		{
		 if(a.isSelected())
			 Topping = a.getText();
		}
		for(JRadioButton a : btn4)
		{
		 if(a.isSelected())
			 cheese = a.getText();
		}
		quantity = jtext.getText();
		return new Pizza(Breads.valueOf(bread),Sizes.valueOf(size),Toppings.valueOf(Topping),Cheese.valueOf(cheese),Integer.parseInt(quantity));
	}

}
