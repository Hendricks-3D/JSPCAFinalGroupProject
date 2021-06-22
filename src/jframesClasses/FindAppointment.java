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

import Database.AppointmentDB;
import Database.ClientDB;

import clinicCustomers.Client;

//REMOVE SERIALIVersionUID WARNING
@SuppressWarnings("serial")
public class FindAppointment extends JFrame {


	

    private JLabel title,lblId,lblFName,lblLName,lblEmail,lblPhone,lblAddress,lblDetail,lblPay;
    private JTextField txtId,txtFName,txtLName,txtEmail,txtPhone,txtAddress;
    private JTextArea txtDetail;
    private Font titleFont,labelFont,txtFieldFont;
    private FlowLayout layout;
    private JButton retrieveBtn,resetBtn;
    private JComboBox cmbPay;
    private String[] pay = {"","Contribute","Full","None"};
    private Client client;
    
    private AppointmentDB appointmentDb;
    
    
	public FindAppointment() {
		super("Find Appointment");//CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
        
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
		
		

		//FRAME COMPONENTS
		
    	title = new JLabel("Find Appointment");
    	title.setForeground(Color.WHITE);
    	title.setFont(titleFont);
    	title.setBounds(250,50,600,70);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
    	getContentPane().add(title);
    	
    	//ID
      	lblId = new JLabel("Appoint. #: ");
    	lblId.setForeground(Color.WHITE);
    	lblId.setFont(labelFont);
    	lblId.setBounds(50,200,400,50);
    	add(lblId);
    	
    	txtId= new JTextField();
    	txtId.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtId.setToolTipText("Client first name");
    	txtId.setBounds(270,200,500,50);
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
    	txtPhone.setToolTipText("Client's phone number");
    	txtPhone.setBounds(270,600,500,50);
    	txtPhone.setBorder(BorderFactory.createLineBorder(new Color(51, 110, 123)));
    	add(txtPhone);
    	
    	//ADDRESS
    	lblAddress = new JLabel("Address: ");
    	lblAddress.setForeground(Color.WHITE);
    	lblAddress.setFont(labelFont);
    	lblAddress.setBounds(50,700,500,30);
    	add(lblAddress );
    	
    	txtAddress   = new JTextField();
    	txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtAddress.setToolTipText("Client's phone number");
    	txtAddress.setBounds(270,700,700,50);
    	txtAddress.setBorder(BorderFactory.createLineBorder(new Color(51, 110, 123)));
    	add(txtAddress);
    	
    	//PAY
    	lblPay = new JLabel("Payment: ");
    	lblPay .setFont(labelFont);
    	lblPay.setForeground(Color.WHITE);
    	lblPay.setBounds(50,800,500,50);
    	add(lblPay);
    	
    	cmbPay = new JComboBox(pay);
    	cmbPay.setFont(labelFont);
    	cmbPay.setBounds(270,800,400,50);
    	add(cmbPay);
    	
    	//DETAIL
      	lblDetail = new JLabel("Animal Detail: ");
    	lblDetail.setForeground(Color.WHITE);
    	lblDetail.setFont(labelFont);
    	lblDetail.setBounds(1050,200,500,30);
    	add(lblDetail);
    	
    	txtDetail   = new JTextArea();
    	txtDetail.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtDetail.setToolTipText("Client's animal detail");
    	txtDetail.setBounds(1000,270,500,450);
    	txtDetail.setBorder(BorderFactory.createLineBorder(new Color(51, 110, 123)));
    	add(txtDetail);
    	
    	
      	retrieveBtn = new JButton("Search", new ImageIcon("images\\search.png"));
      	retrieveBtn.setBounds(400,1050,200,65);
      	retrieveBtn.setBackground(new Color(34,167, 240));
      	retrieveBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
      	retrieveBtn.setForeground(Color.WHITE);
    	add(retrieveBtn);
    	
    	
    	resetBtn = new JButton("Reset", new ImageIcon("images\\reset.png"));
    	resetBtn.setBounds(750,1050,200,65);
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
	    			appointmentDb = new AppointmentDB();
					
					client =appointmentDb.retrieveAppointment(Integer.parseInt(txtId.getText().toString()));
					
					 
		    		 if(client.getfName().equals("")||client.getPhone().equals(""))
		    		 {
		    			 JOptionPane.showMessageDialog(null,"appointment was not found","Not found",JOptionPane.ERROR_MESSAGE);
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
							cmbPay.setSelectedItem(client.getPay().toString());
							
		    			 }catch(NullPointerException ex)
		    		    	{

		    		        	System.out.println("Error retrieving data. ");
		    		        	JOptionPane.showMessageDialog(null,"Error retrieving All the data from the file.","Error",JOptionPane.ERROR_MESSAGE);
		    		    	}
		    		 }
		    		 

    	
    			
    		}
    	});
        
	}//END OF DEAFAULT CONSTRUCTOR


}//END OF MAKE APPOINTMENT CLASS
