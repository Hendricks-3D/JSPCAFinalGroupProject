package jframesClasses;



import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MakeIntervention extends JFrame {

   
	 private JLabel title;


	public MakeIntervention() {
		super("New Intervention");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 900);
		setVisible(true);
		getContentPane().setBackground(new Color(52, 73, 94));
		
		//TODO: ADD ALL THE ELEMENTS TO THIS FORM
		
		 title  = new JLabel("New Intervention");
         title.setForeground(Color.WHITE);
         
         
	}//END OF DEFAULT CONSTRUCTOR
	
	
	

}//END OF 
