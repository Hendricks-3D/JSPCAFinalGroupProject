package jframesClasses;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import Database.veterinarian_DB;

import clinic.Veterinarian;



	

  


public class UpdateVeterinarian extends JFrame
{
	
	  private JLabel title,lblId,lblFName,lblLName,lblEmail,lblPhone;
	    private JTextField txtId,txtFName,txtLName,txtEmail,txtPhone;
	    private Font titleFont,labelFont,txtFieldFont;
	    private FlowLayout layout;
	    private JButton retrieveBtn,resetBtn,updateBtn;
	    private Veterinarian veterinarian;
	    private veterinarian_DB vet_DB;
	  
	    
	    public UpdateVeterinarian()
	    {
		    super ("Search Veterinarian"); //CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
	    	setVisible(false);
			getContentPane().setLayout(layout);			
		    setSize(400,600);
		    
		    
		    
			setResizable(false);
			setLocation(250,100);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			getContentPane().setBackground(new Color(52, 73, 94));
			
			
			//FONT SETUP
			titleFont=new Font("TimesNewRoman",Font.BOLD,30);
			labelFont=new Font("TimesNewRoman",Font.PLAIN,15);	
			txtFieldFont =new Font("Tahoma",Font.PLAIN,15);

			
			
			title = new JLabel("Update Veterinarian");
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
	    	txtId.setBounds(100,180,100,20);
	    	txtId.setFont(txtFieldFont);
	    	txtId.setToolTipText("Vetinarian identification number");
	        add(txtId); 
	        
	    	retrieveBtn = new JButton("Search", new ImageIcon("images\\search.png"));
	      	retrieveBtn.setBounds(240,170,80,40);
	      	retrieveBtn.setBackground(new Color(34,167, 240));
	      	retrieveBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
	      	retrieveBtn.setForeground(Color.WHITE);
	    	add(retrieveBtn);
	    	
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
	    	
	    	
	    	resetBtn = new JButton("Reset", new ImageIcon("images\\reset.png"));
	    	resetBtn.setBounds(20,400,90,80);
	    	resetBtn.setBackground(new Color(218, 223, 225));
	    	resetBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
	    	add(resetBtn); 
	    	
	    	
	    	
	    	
	       	
	    	 //--------RESET BUTTON ACITIONLISTENER METHOD
	    	
	    	    	resetBtn.addActionListener(new ActionListener() 
	    	    	{
	    	    		
	    	    		public void actionPerformed(ActionEvent action)
	    	    		{
	    	    			txtId.setText("");
	    	    			txtLName.setText("");
	    	    			txtFName.setText("");
	    	    		}
	    	    	});
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	
	    	    	retrieveBtn.addActionListener(new ActionListener()
	    	    	{
	    	    		public void actionPerformed(ActionEvent action)
	    	    		{
	    	    	   				
	    	    			    
	    	    				
	    		    			veterinarian =new Veterinarian();
	    		    			vet_DB= new veterinarian_DB();
	    		    			
	    		    			
	    						
	    	     	
	    						veterinarian = vet_DB.retrieveVeterinarian(Integer.parseInt(txtId.getText().toString()));
	    						
	    						
	    						
	    						
	    						
	    						
	    						 
	    			    		 if(veterinarian.getfName().equals("")|| veterinarian.getID()==0)
	    			    		 {
	    			    			 JOptionPane.showMessageDialog(null,"Animal Data not found","Not found",JOptionPane.ERROR_MESSAGE);
	    			    		 }
	    			    		 else
	    			    		 {
	    								txtId.setText(String.valueOf(veterinarian.getID()));
	    								txtLName.setText(veterinarian.getlName());
	    								txtFName.setText(veterinarian.getfName());
	    							
	    						
	    			    		 }
	    			    		 

	    	    	
	    	    			
	    	    		}
	    	    	});

	    	    	
	        
	        
	        setVisible(true);
	        
			
			
	    }
	    
	    
	    
	    
	   
        
        
    	
    	
    	
    
    
	    
}


