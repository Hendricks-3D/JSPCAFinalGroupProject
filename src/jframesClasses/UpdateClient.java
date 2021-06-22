package jframesClasses;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;


import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import Database.ClientDB;

import clinicCustomers.Client;

//REMOVE SERIALIVersionUID WARNING
@SuppressWarnings("serial")
public class UpdateClient extends JFrame {


	

    private JLabel title,lblId,lblFName,lblLName,lblEmail,lblPhone,lblAddress,lblDetail;
    private JTextField txtId,txtFName,txtLName,txtEmail,txtPhone,txtAddress;
    private JTextArea txtDetail;
    private Font titleFont,labelFont,txtFieldFont;
    private String[] pay = {"","Contribute","Full","None"};
    private FlowLayout layout;
    private JButton retrieveBtn,resetBtn,updateBtn;
    private Client client;
    
    private ClientDB clientDb;
    
    
	public UpdateClient() {
		super("Update Citizen");//CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
        
		//FRAME SETUP
		setVisible(true);
		getContentPane().setLayout(layout);
	    setSize(1700,1200);
		setResizable(false);
		setLocation(250, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(52, 73, 94));

		//FONT SETUP
		titleFont=new Font("TimesNewRoman",Font.BOLD,50);
		labelFont=new Font("TimesNewRoman",Font.PLAIN,40);	
		txtFieldFont =new Font("Tahoma",Font.PLAIN,30);
		

		//FRAME COMPONENTS
		
    	title = new JLabel("Update Client");
    	title.setForeground(Color.WHITE);
    	title.setFont(titleFont);
    	title.setBounds(500,50,600,70);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
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
    	txtId.setToolTipText("Client identification number");
        add(txtId);
        
        
        //First Name COMPONENTS
    	lblFName = new JLabel("First Name: ");
    	lblFName.setFont(labelFont);
    	lblFName.setForeground(Color.WHITE);
    	lblFName.setBounds(200,400,500,50);
    	add(lblFName);
    	
    	txtFName = new JTextField();
    	txtFName.setBounds(400,400,500,50);
    	txtFName.setFont(txtFieldFont);
    	txtFName.setToolTipText("Client First Name.");
        add(txtFName);
        
        //Last COMPONENT
    	lblLName = new JLabel("Last Name: ");
    	lblLName.setFont(labelFont);
    	lblLName.setForeground(Color.WHITE);
    	lblLName.setBounds(200,500,500,50);
    	add(lblLName);
    	
    	txtLName = new JTextField();
    	txtLName.setBounds(400,500,500,50);
    	txtLName.setFont(txtFieldFont);
    	txtLName.setToolTipText("ciitizen last name.");
        add(txtLName);
        
        //Email COMPONENT
        lblEmail= new JLabel("Email: ");
    	lblEmail.setFont(labelFont);
    	lblEmail.setForeground(Color.WHITE);
    	lblEmail.setBounds(200,600,500,50);
    	add(lblEmail);
    	
    	txtEmail = new JTextField();
    	txtEmail.setBounds(400,600,500,50);
    	txtEmail.setFont(txtFieldFont);
    	txtEmail.setToolTipText("Client Email.");
        add(txtEmail);
        
        //PHONE COMPONENT
        lblPhone= new JLabel("Phone: ");
    	lblPhone.setFont(labelFont);
    	lblPhone.setForeground(Color.WHITE);
    	lblPhone.setBounds(200,700,500,50);
    	add(lblPhone);
    	
    	txtPhone = new JTextField();
    	txtPhone.setBounds(400,700,500,50);
    	txtPhone.setFont(txtFieldFont);
        add(txtPhone);
        
        //Address
        lblAddress = new JLabel("Address: ");
    	lblAddress.setFont(labelFont);
    	lblAddress.setForeground(Color.WHITE);
    	lblAddress.setBounds(200,800,500,50);
    	add(lblAddress);
    	
    	txtAddress = new JTextField();
    	txtAddress.setBounds(400,800,700,50);
    	txtAddress.setFont(txtFieldFont);
        add(txtAddress);
        

        
    	//DETAIL
      	lblDetail = new JLabel("Animal Detail: ");
    	lblDetail.setForeground(Color.WHITE);
    	lblDetail.setFont(labelFont);
    	lblDetail.setBounds(1050,200,500,30);
    	add(lblDetail);
    	
    	txtDetail   = new JTextArea();
    	txtDetail.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtDetail.setToolTipText("Client's animal detail");
    	txtDetail.setBounds(1000,270,500,500);
    	txtDetail.setBorder(BorderFactory.createLineBorder(new Color(51, 110, 123)));
    	add(txtDetail);
    	
    	//-------BUTTONS--------
     	retrieveBtn = new JButton("Search", new ImageIcon("images\\search.png"));
      	retrieveBtn.setBounds(400,1050,200,65);
      	retrieveBtn.setBackground(new Color(34,167, 240));
      	retrieveBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
      	retrieveBtn.setForeground(Color.WHITE);
    	add(retrieveBtn);
    	
    	updateBtn = new JButton("Update", new ImageIcon("images\\update.png"));
    	updateBtn.setBounds(750,1050,200,65);
    	updateBtn.setBackground(new Color(38, 166, 91));
    	updateBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	updateBtn.setForeground(Color.WHITE);
    	add(updateBtn);
    	
    	resetBtn = new JButton("Reset", new ImageIcon("images\\reset.png"));
    	resetBtn.setBounds(1050,1050,200,65);
    	resetBtn.setBackground(new Color(218, 223, 225));
    	resetBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
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
    			txtAddress.setText("");
    			txtDetail.setText("");
    			
    		}
    	});
    	
    	//RETRIEVE BUTTON ACTIONLSTENER METHOD
    	retrieveBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent action)
    		{		    
	    			client = new Client();
	    			clientDb = new ClientDB();
					
					client =clientDb.retrieveClient(Integer.parseInt(txtId.getText().toString()));
					
					 
		    		 if(client.getfName().equals("")||client.getPhone().equals(""))
		    		 {
		    			 JOptionPane.showMessageDialog(null,"Client Data not found","Not found",JOptionPane.ERROR_MESSAGE);
		    		 }
		    		 else
		    		 {
		    			 try
		    			 {
		    				 
		    			 
							txtLName.setText(client.getlName());
							txtEmail.setText(client.getEmail());
							txtFName.setText(client.getfName());
							txtPhone.setText(client.getPhone()); 
							txtAddress.setText(client.getAddress());
							txtDetail.setText(client.getAnimalDetail());
		    			 }catch(NullPointerException ex)
		    		    	{

		    		        	System.out.println("Error retrieving data. ");
		    		        	JOptionPane.showMessageDialog(null,"Error retrieving All the data from the file.","Error",JOptionPane.ERROR_MESSAGE);
		    		    	}
		    		 }
		    		 

    	
    			
    		}
    	});
        
    	
    	
    	
    	
    //------------------UPDATE BUTTON ACTION LISTENER
    	updateBtn.addActionListener(new ActionListener() 
    	{
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			//TODO: ADD APPROPRIATE TRY CATCH (EXCEPTION)
    			 
    			 try
    			 {
    				 client = new Client();
    				 clientDb = new ClientDB();
    				 
    				//GET VALUES FROM TEXT FIELDS
    				client.setId(Integer.parseInt(txtId.getText().toString()));
    				client.setfName(txtFName.getText().toString());
    				client.setlName(txtLName.getText().toString());
    				client.setEmail(txtEmail.getText().toString());
    				client.setPhone(txtPhone.getText().toString());
    				client.setAddress(txtAddress.getText().toString());
    				client.setAnimalDetail(txtDetail.getText());
    				clientDb.storeClient(client);
    				
    				 JOptionPane.showMessageDialog(null,"The client data was updated successfully! ","",JOptionPane.INFORMATION_MESSAGE);
    				
    			 }
    			 catch(NullPointerException ex)
    			 {
    				 JOptionPane.showMessageDialog(null,"Please populate each text field","Empty",JOptionPane.ERROR_MESSAGE);
    			 }
    	
    			
    		 }
    	});
    	
    	
    	
	}//END OF DEAFAULT CONSTRUCTOR


}//END OF MAKE APPOINTMENT CLASS
