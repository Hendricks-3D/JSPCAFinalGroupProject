package jframesClasses;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clinic.Veterinarian;
import Database.veterinarian_DB;


public class AddVeterinarian extends JFrame 
{
	 private JLabel title,lblId,lblFName,lblLName;
	    private JTextField txtId,txtFName,txtLName;
	    private Font titleFont,labelFont,txtFieldFont;
	    private JComboBox<Object> cmbGender;
	    private FlowLayout layout;
	    private JButton saveBtn,resetBtn;
	    private String[] gender = {"","Male","Female"};
	    private Veterinarian veterinarian;
	    private veterinarian_DB vet_DB;
	    
	    
	    
	    
	    public AddVeterinarian()
	    {
	    	super ("Add Veterinarian"); //CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
	    	setVisible(false);
			getContentPane().setLayout(layout);
		    setSize(300,580);
			setResizable(false);
			setLocation(250, 100);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			getContentPane().setBackground(new Color(52, 73, 94));
			
			//FONT SETUP
			titleFont=new Font("TimesNewRoman",Font.BOLD,30);
			labelFont=new Font("TimesNewRoman",Font.PLAIN,15);	
			txtFieldFont =new Font("Tahoma",Font.PLAIN,15);
			
			title = new JLabel("Add Veterinarian");
	    	title.setForeground(Color.WHITE);
	    	title.setFont(titleFont);
	    	title.setBounds(25,50,400,40);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
	    	add(title);
	    	
	    	lblId = new JLabel("ID Number: ");
	    	lblId.setFont(labelFont);
	    	lblId.setForeground(Color.WHITE);
	    	lblId.setBounds(15,180,90,20);
	    	add(lblId);
	    	
	    	txtId = new JTextField();
	    	txtId.setBounds(100,180,150,20);
	    	txtId.setFont(txtFieldFont);
	    	txtId.setToolTipText("Vetinarian identification number");
	        add(txtId);
	        
	     	lblFName = new JLabel("First Name: ");
	     	lblFName.setFont(labelFont);
	     	lblFName.setForeground(Color.WHITE);
	     	lblFName.setBounds(15,250,80,20);
	    	add(lblFName);
	    	
	    	txtFName = new JTextField();
	    	txtFName.setBounds(100,250,150,20);
	    	txtFName.setFont(txtFieldFont);
	    	txtFName.setToolTipText("Veterinarian First Name: ");
	        add(txtFName);
	        
	        
	        
	        lblLName = new JLabel("Last Name: ");
	     	lblLName.setFont(labelFont);
	     	lblLName.setForeground(Color.WHITE);
	     	lblLName.setBounds(15,320,80,20);
	    	add(lblLName);
	    	
	    	txtLName = new JTextField();
	    	txtLName.setBounds(100,320,150,20);
	    	txtLName.setFont(txtFieldFont);
	    	txtLName.setToolTipText("Vetinarian Last Name");
	        add(txtLName);
	        
	        
	        
	        
	        
	    	saveBtn = new JButton("Add", new ImageIcon("images\\save.png")); //(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
	    	saveBtn.setBounds(20,450,100,65);
	    	saveBtn.setBackground(new Color(34,167, 240));
	    	saveBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
	    	saveBtn.setForeground(Color.WHITE);
	    	add(saveBtn);
	    	
	    	
	    	resetBtn = new JButton("Reset", new ImageIcon("images\\reset.png"));
	    	resetBtn.setBounds(170,450,100,65);
	    	resetBtn.setBackground(new Color(218, 223, 225));
	    	resetBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
	    	resetBtn.setForeground(Color.WHITE);
	    	add(resetBtn);       
	    	
	    	
	    	//RESET BUTTON ACITIONLISTENER METHOD
	    	resetBtn.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent action)
	    		{
	    			//lblId,lblFName,lblLName;
	    		   // private JTextField txtId,txtFName,txtLName;
	    			//RESET ALL FIELDS 
	    			
	    			txtId.setText("");
	    			txtLName.setText("");
	    			txtFName.setText("");
	    			
	    			
	    		}
	    	});
	    	
	    	
	    	
	    	
	    	saveBtn.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent action)
	    		{
	    	   				
	    			
		    			try
		    			{
		    				/*THE DEFAULT CONSTRUCT MUCT BE CALLED 
		    				 * OTHERWISE NULL POINTER EXCEPTION WILL BE CALLED 
		    				 * BECAUSE THE OBJECTS ARE NOT POINTING TO ANYTHING*/
		    				veterinarian =new Veterinarian();
			    			vet_DB =new veterinarian_DB();
			    			
			    			
			    			veterinarian.setID(Integer.parseInt(txtId.getText().toString()));
			    			veterinarian.setlName(txtLName.getText());
			    			veterinarian.setfName(txtFName.getText());
			    			
			    			
			    			
			    			//CALL VETERINARIAN DATABASE AND STORE ANIMAL TO FILE
			    			veterinarian_DB.storeVeterinarian(veterinarian);
			    			JOptionPane.showMessageDialog(null,"The Veterinan's data was added successfully! ","",JOptionPane.INFORMATION_MESSAGE);
		    			}
		    			catch(NumberFormatException ex){
		    				System.out.println("Error  getting data from text field "+ ex.getMessage());
		    			    JOptionPane.showMessageDialog(null,"Please populate each text field with valid inputs","Field",JOptionPane.ERROR_MESSAGE);
		    			}
	    	
	    			
	    		}
	    	});
	    	
	        
	        
	        
	        
	        
	        
	        
	        setVisible(true);
	        
	        
	    	
	    	
	    	
	    }
	    
	
	
	
	

}
