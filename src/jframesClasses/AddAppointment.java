package jframesClasses;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clinicCustomers.Client;
import Database.AppointmentDB;
import Database.ClientDB;
public class AddAppointment extends JFrame {

	private static final long serialVersionUID = 1L;
	

    private JLabel title,lblFName,lblLName,lblEmail,lblPhone,lblAddress,lblPay,lblId,lblDetail;
    private JTextField txtFName,txtLName,txtEmail,txtPhone,txtAddress,txtId;
    private Font titleFont,labelFont;
    private JTextArea txtDetail;
    private JComboBox cmbPay;
    private FlowLayout layout;
    private JButton saveBtn,resetBtn;
    private String[] pay = {"","Contribute","Full","None"};
    Client client;
    AppointmentDB appointmentDb;

	public AddAppointment() {
		super("Make Appointment");//CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
        
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
		
    	title = new JLabel("Make Appointment");
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
    	
    	
    	saveBtn = new JButton("Add", new ImageIcon("images\\addclient.png"));
    	saveBtn.setBounds(400,1000,200,65);
    	saveBtn.setBackground(new Color(34,167, 240));
    	saveBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	saveBtn.setForeground(Color.WHITE);
    	add(saveBtn);
    	
    	
    	
    	
    	resetBtn = new JButton("Reset", new ImageIcon("images\\reset.png"));
    	resetBtn.setBounds(800,1000,200,65);
    	resetBtn.setBackground(new Color(218, 223, 225));
    	resetBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	add(resetBtn);
    	
    	
    	//SAVE BUTTON LISTENER ACTION LISTENER
    	saveBtn.addActionListener(new ActionListener() 
    	{
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			//TODO: ADD APPROPRIATE TRY CATCH (EXCEPTION)
    			 
    			 try
    			 {
    				 client = new Client();
    				 appointmentDb = new AppointmentDB();
    				 
    				//GET VALUES FROM TEXT FIELDS
    				client.setId(Integer.parseInt(txtId.getText().toString()));
    				client.setfName(txtFName.getText().toString());
    				client.setlName(txtLName.getText().toString());
    				client.setEmail(txtEmail.getText().toString());
    				client.setPhone(txtPhone.getText().toString());
    				client.setAddress(txtAddress.getText().toString());
    				client.setPay(cmbPay.getSelectedItem().toString());
    				client.setAnimalDetail(txtDetail.getText());
    				
    				
    				appointmentDb.storeAppointment(client);
    				 JOptionPane.showMessageDialog(null,"Appointment was added successfully! ","",JOptionPane.INFORMATION_MESSAGE);
    				
    			 }
    			 catch(NullPointerException ex)
    			 {
    				 JOptionPane.showMessageDialog(null,"Please populate each text field","Empty",JOptionPane.ERROR_MESSAGE);
    			 }
    	
    			
    		 }
    	});
    
    	
    	//------------RESET BUTTON ACION LISTENER
    	resetBtn.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent action)
    		{
    			//RESET ALL FIELDS 
    			txtFName.setText("");
    			txtLName.setText("");
    			txtPhone.setText("");
    			txtEmail.setText("");
    			cmbPay.setSelectedItem("");
    			txtAddress.setText("");
    			txtPhone.setText("");
    			txtAddress.setText("");
    			txtDetail.setText("");
    		}
    	});
    	
	}//END OF DEAFAULT CONSTRUCTOR


}//END OF MAKE APPOINTMENT CLASS
