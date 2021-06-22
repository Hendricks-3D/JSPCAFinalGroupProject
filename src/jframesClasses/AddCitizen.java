package jframesClasses;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Database.CitizenDB;
import clinicCustomers.Citizen;

public class AddCitizen extends JFrame {

	private static final long serialVersionUID = 1L;
	

    private JLabel title,lblFName,lblLName,lblEmail,lblPhone,lblId;
    private JTextField txtFName,txtLName,txtEmail,txtPhone,txtId;
    private Font titleFont,labelFont;
    private FlowLayout layout;
    private JButton saveBtn,resetBtn;
    CitizenDB citizenDb;
    
    
	public AddCitizen() {
		super("Add Citizen");//CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
        
		//FRAME SETUP
		setVisible(true);
		getContentPane().setLayout(layout);
	    setSize(1000,1200);
		setResizable(false);
		setLocation(250, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(52, 73, 94));

		//FONT SETUP
		titleFont=new Font("TimesNewRoman",Font.BOLD,50);
		labelFont=new Font("TimesNewRoman",Font.PLAIN,40);	
		
		

		//FRAME COMPONENTS
		
    	title = new JLabel("Add Citizen");
    	title.setForeground(Color.WHITE);
    	title.setFont(titleFont);
    	title.setBounds(250,50,600,70);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
    	getContentPane().add(title);
    	
    	
    	
     	lblId = new JLabel("Citizen #: ");
    	lblId.setForeground(Color.WHITE);
    	lblId.setFont(labelFont);
    	lblId.setBounds(50,200,500,30);
    	add(lblId);
    	
    	txtId  = new JTextField();
    	txtId.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtId.setToolTipText("Citizen number");
    	txtId.setBounds(270,200,500,50);
    	txtId.setBorder(BorderFactory.createLineBorder(new Color(51, 110, 123)));
    	add(txtId);    	
    	
    	//FIRST NAME
    	lblFName = new JLabel("First Name: ");
    	lblFName.setForeground(Color.WHITE);
    	lblFName.setFont(labelFont);
    	lblFName.setBounds(50,300,500,30);
    	add(lblFName);
    	
    	txtFName = new JTextField();
    	txtFName.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtFName.setToolTipText("Client first name");
    	txtFName.setBounds(270,300,500,50);
    	add(txtFName);
    	
    	
    	//LAST NAME
    	lblLName=new JLabel("Last Name");
    	lblLName.setForeground(Color.WHITE);
    	lblLName.setFont(labelFont);
    	lblLName.setBounds(50,400,500,30);
    	add(lblLName);
    	
    	txtLName = new JTextField();
    	txtLName.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtLName.setToolTipText("Client's last name");
    	txtLName.setBounds(270,400,500,50);
    	txtLName.setBorder(BorderFactory.createLineBorder(new Color(51, 110, 123)));
    	add(txtLName);
    	
    	
    	//EMAIL COMPONENTS
      	lblEmail = new JLabel("Email: ");
    	lblEmail.setForeground(Color.WHITE);
    	lblEmail.setFont(labelFont);
    	lblEmail.setBounds(50,500,500,30);
    	add(lblEmail);
    	
    	txtEmail = new JTextField();
    	txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtEmail.setToolTipText("Client's email address");
    	txtEmail.setBounds(270,500,500,50);
    	add(txtEmail);
    	 
    	
    	//PHONE
    	lblPhone = new JLabel("Contact No.");
    	lblPhone.setForeground(Color.WHITE);
    	lblPhone.setFont(labelFont);
    	lblPhone.setBounds(50,600,500,30);
    	add(lblPhone );
    	
    	txtPhone  = new JTextField();
    	txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtPhone.setToolTipText("Ctizen's phone number");
    	txtPhone.setBounds(270,600,500,50);
    	txtPhone.setBorder(BorderFactory.createLineBorder(new Color(51, 110, 123)));
    	add(txtPhone);
    	
   
    	
    	
    	
    	saveBtn = new JButton("Add", new ImageIcon("images\\addclient.png"));
    	saveBtn.setBounds(200,800,200,65);
    	saveBtn.setBackground(new Color(34,167, 240));
    	saveBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	saveBtn.setForeground(Color.WHITE);
    	add(saveBtn);
    	
    	
    	resetBtn = new JButton("Reset", new ImageIcon("images\\reset.png"));
    	resetBtn.setBounds(600,800,200,65);
    	resetBtn.setBackground(new Color(218, 223, 225));
    	resetBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	add(resetBtn);
    	
    	
  //----------------------------SAVE BUTTON LISTENER ACTION LISTENER
    	saveBtn.addActionListener(new ActionListener() 
    	{
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			//TODO: ADD APPROPRIATE TRY CATCH (EXCEPTION)
    			 
    			 try {
    				 
	    			 
    				   Citizen citizen = new Citizen();
	                   citizenDb = new CitizenDB();
	                   
	                   
	    				//GET VALUES FROM TEXT FIELDS
	                    citizen.setId(Integer.parseInt(txtId.getText().toString()));
	    				citizen.setfName(txtFName.getText().toString());
	    				citizen.setlName(txtLName.getText().toString());
	    				citizen.setEmail(txtEmail.getText().toString());
	    				citizen.setPhone(txtPhone.getText().toString());
	 
	    				
	    			    citizenDb.storecitizen(citizen);//STORE CITIZEN TO FILE
	    			    JOptionPane.showMessageDialog(null,"The citizen data was added successfully! ","",JOptionPane.INFORMATION_MESSAGE);
    		   }catch (NullPointerException ex)
    		   {
    			   JOptionPane.showMessageDialog(null,"Please populate each text field","Empty Field",JOptionPane.ERROR_MESSAGE);
    			   
    		   } 
			  	catch(NumberFormatException ex)
		    	{
		    		System.out.println("cannot convert from int to string: "+ ex.getMessage());
		    		JOptionPane.showMessageDialog(null,"Please enter valid integer for ID field","Empty",JOptionPane.ERROR_MESSAGE);
		    	}
    			 
    		 }
    	});
    	
    	
    	
    	//RESET BUTTON LISTENER ACTION LISTENER
    	
   //---------------------RESET BUTTON ACITIONLISTENER METHOD
    	resetBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent action)
    		{
    			//RESET ALL FIELDS 
    			txtFName.setText("");
    			txtLName.setText("");
    			txtPhone.setText("");
    			txtEmail.setText("");
    			
    			
    		}
    	});
	}//END OF DEAFAULT CONSTRUCTOR


}//END OF MAKE APPOINTMENT CLASS
