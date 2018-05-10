import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;

public class Menu extends JPanel{
	public ArrayList<JRadioButton> btn1 ,btn2,btn3,btn4;
	
	public ButtonGroup bg1,bg2,bg3,bg4;
	  Box p1,p2,p3,p4;
	  
	public JSplitPane j1 ;
	public JSplitPane j2 ;
	public JSplitPane j3 ;
	
	
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
		
		j1 =new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,p1,p3);
		
		j2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,p2,p4);
		j3 =new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,j1,j2);
		add(j3);
		
		
	}

}
