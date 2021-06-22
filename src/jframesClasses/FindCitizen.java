package jframesClasses;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

import Database.AnimalDB;
import Database.CitizenDB;
import animal.Animal;
import clinicCustomers.Citizen;

//REMOVE SERIALIVersionUID WARNING
@SuppressWarnings("serial")
public class FindCitizen extends JFrame {


	

    private JLabel title,lblId,lblFName,lblLName,lblEmail,lblPhone;
    private JTextField txtId,txtFName,txtLName,txtEmail,txtPhone;
    private Font titleFont,labelFont,txtFieldFont;
    private FlowLayout layout;
    private JButton retrieveBtn,resetBtn;
    private Citizen citizen;
    private CitizenDB citizenDb;
    
    
	public FindCitizen() {
		super("Find Citizen ");//CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
        
		//FRAME SETUP
		setVisible(true);
		getContentPane().setLayout(layout);
	    setSize(1400,1200);
		setResizable(false);
		setLocation(250, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(52, 73, 94));

		//FONT SETUP
		titleFont=new Font("TimesNewRoman",Font.BOLD,50);
		labelFont=new Font("TimesNewRoman",Font.PLAIN,40);	
		txtFieldFont =new Font("Tahoma",Font.PLAIN,30);
		

		//FRAME COMPONENTS
		
    	title = new JLabel("Find Citizen by Id No.");
    	title.setForeground(Color.WHITE);
    	title.setFont(titleFont);
    	title.setBounds(200,50,600,70);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
    	getContentPane().add(title);
    	
    	
    	//ID NUMBER COMPONENTS
    	lblId = new JLabel("ID Number: ");
    	lblId.setFont(labelFont);
    	lblId.setForeground(Color.WHITE);
    	lblId.setBounds(50,200,300,50);
    	add(lblId);
    	
    	txtId = new JTextField();
    	txtId.setBounds(280,200,300,50);
    	txtId.setFont(txtFieldFont);
    	txtId.setToolTipText("Citizen identification number");
        add(txtId);
        
        
        //First Name COMPONENTS
    	lblFName = new JLabel("First Name: ");
    	lblFName.setFont(labelFont);
    	lblFName.setForeground(Color.WHITE);
    	lblFName.setBounds(400,400,500,50);
    	add(lblFName);
    	
    	txtFName = new JTextField();
    	txtFName.setBounds(600,400,500,50);
    	txtFName.setFont(txtFieldFont);
    	txtFName.setEditable(false);
    	txtFName.setToolTipText("Citizen First Name.");
        add(txtFName);
        
        //Last COMPONENT
    	lblLName = new JLabel("Last Name: ");
    	lblLName.setFont(labelFont);
    	lblLName.setForeground(Color.WHITE);
    	lblLName.setBounds(400,500,500,50);
    	add(lblLName);
    	
    	txtLName = new JTextField();
    	txtLName.setBounds(600,500,500,50);
    	txtLName.setFont(txtFieldFont);
    	txtLName.setEditable(false);
    	txtLName.setToolTipText("ciitizen last name.");
        add(txtLName);
        
        //Email COMPONENT
        lblEmail= new JLabel("Email: ");
    	lblEmail.setFont(labelFont);
    	lblEmail.setForeground(Color.WHITE);
    	lblEmail.setBounds(400,600,500,50);
    	add(lblEmail);
    	
    	txtEmail = new JTextField();
    	txtEmail.setBounds(600,600,500,50);
    	txtEmail.setFont(txtFieldFont);
    	txtEmail.setToolTipText("Citizen Email.");
        add(txtEmail);
        
        //PHONE COMPONENT
        lblPhone= new JLabel("Phone: ");
    	lblPhone.setFont(labelFont);
    	lblPhone.setForeground(Color.WHITE);
    	lblPhone.setBounds(400,700,500,50);
    	add(lblPhone);
    	
    	txtPhone = new JTextField();
    	txtPhone.setBounds(600,700,500,50);
    	txtPhone.setFont(txtFieldFont);
    	txtPhone.setEditable(false);
        add(txtPhone);
        
        
      	retrieveBtn = new JButton("Search", new ImageIcon("images\\search.png"));
      	retrieveBtn.setBounds(400,850,200,65);
      	retrieveBtn.setBackground(new Color(34,167, 240));
      	retrieveBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
      	retrieveBtn.setForeground(Color.WHITE);
    	add(retrieveBtn);
    	
    	
    	resetBtn = new JButton("Reset", new ImageIcon("images\\reset.png"));
    	resetBtn.setBounds(750,850,200,65);
    	resetBtn.setBackground(new Color(218, 223, 225));
    	resetBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	//resetBtn.setForeground(Color.WHITE);
    	add(resetBtn);       
    	
    	
    	//RESET BUTTON ACITIONLISTENER METHOD
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
    	
    	//RETRIEVE BUTTON ACTIONLSTENER METHOD
    	retrieveBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent action)
    		{
    	   				
    			    
	    			citizen = new Citizen();
	    			citizenDb = new CitizenDB();
					
     	
					citizen = citizenDb.retrieveCitizen(Integer.parseInt(txtId.getText().toString()));
					
					 
		    		 if(citizen.getfName().equals("")|| citizen.getPhone().equals(""))
		    		 {
		    			 JOptionPane.showMessageDialog(null,"Citizen Data not found","Not found",JOptionPane.ERROR_MESSAGE);
		    		 }
		    		 else
		    		 {
							txtLName.setText(citizen.getlName());
							txtEmail.setText(citizen.getEmail());
							txtFName.setText(citizen.getfName());
							txtPhone.setText(citizen.getPhone()); 
		    		 }
		    		 

    	
    			
    		}
    	});
        
	}//END OF DEAFAULT CONSTRUCTOR


}//END OF MAKE APPOINTMENT CLASS
