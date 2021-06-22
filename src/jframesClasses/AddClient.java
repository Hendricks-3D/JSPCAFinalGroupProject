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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Database.ClientDB;
import clinicCustomers.Client;

//REMOVE SERIALIZATION ID WARNING
@SuppressWarnings("serial")
public class AddClient extends JFrame {

	

    private JLabel title,lblFName,lblLName,lblEmail,lblPhone,lblAddress,lblDetail,lbPay,lblId;
    private JTextField txtFName,txtLName,txtEmail,txtPhone,txtAddress,txtPay,txtId;
    private Font titleFont,labelFont;
    private FlowLayout layout;
    private JTextArea txtA_detail;
    private JButton saveBtn,resetBtn;
    private Client client;
    private ClientDB clientDb;
    
	public AddClient() {
		super("Add Client");//CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
        
		//FRAME SETUP
		setVisible(true);
		getContentPane().setLayout(layout);
	    setSize(1000,1600);
		setResizable(false);
		setLocation(250, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(52, 73, 94));

		//FONT SETUP
		titleFont=new Font("TimesNewRoman",Font.BOLD,50);
		labelFont=new Font("TimesNewRoman",Font.PLAIN,40);	
		
		

		//FRAME COMPONENTS
		
    	title = new JLabel("Add Client");
    	title.setForeground(Color.WHITE);
    	title.setFont(titleFont);
    	title.setBounds(250,50,600,70);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
    	getContentPane().add(title);
    	
    	//ID
      	lblId = new JLabel("Client #: ");
    	lblId.setForeground(Color.WHITE);
    	lblId.setFont(labelFont);
    	lblId.setBounds(50,200,400,30);
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
    	
    	//ANIMAL DETAILS
    	lblDetail = new JLabel("Animal Detail: ");
    	lblDetail.setForeground(Color.WHITE);
    	lblDetail.setFont(labelFont);
    	lblDetail.setBounds(50,800,500,30);
    	add(lblDetail);
    	
    	txtA_detail   = new JTextArea(5,20);
    	txtA_detail.setToolTipText("Animal Details");
    	txtA_detail.setBounds(108,870,700,400);
    	txtA_detail.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtA_detail.setBorder(BorderFactory.createLineBorder(new Color(51, 110, 123)));
    	add(txtA_detail);
    	
    	
    	saveBtn = new JButton("Add", new ImageIcon("images\\save.png"));
    	saveBtn.setBounds(200,1300,200,65);
    	saveBtn.setBackground(new Color(34,167, 240));
    	saveBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	saveBtn.setForeground(Color.WHITE);
    	add(saveBtn);
    	
    	
    	resetBtn = new JButton("Reset", new ImageIcon("images\\save.png"));
    	resetBtn.setBounds(600,1300,200,65);
    	resetBtn.setBackground(new Color(217, 30, 24));
    	resetBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	resetBtn.setForeground(Color.WHITE);
    	add(resetBtn);
    	
    	
    	//SAVE BUTTON LISTENER ACTION LISTENER
    	saveBtn.addActionListener(new ActionListener() 
    	{
    		 public void actionPerformed(ActionEvent ae)
    		 {
    			//TODO: ADD APPROPRIATE TRY CATCH (EXCEPTION)
    			 
    			clientDb = new ClientDB();
    			client = new Client();
    			 	
    			if(txtFName.getText().isEmpty()||txtLName.getText().isEmpty()||txtEmail.getText().isEmpty()
    			||txtPhone.getText().isEmpty()||txtA_detail.getText().isEmpty())
    			{
    				JOptionPane.showMessageDialog(null,"Ensure that all the fields are filled.","Error",JOptionPane.ERROR_MESSAGE);
    			}
    			else
    			{
    				//GET VALUES FROM TEXT FIELDS
    				client.setId(Integer.parseInt(txtId.getText()));
    				client.setfName(txtFName.getText().toString());
    				client.setlName(txtLName.getText().toString());
    				client.setEmail(txtEmail.getText().toString());
    				client.setPhone(txtPhone.getText().toString());
    				client.setAddress(txtAddress.getText().toString());
    				client.setAnimalDetail(txtA_detail.getText().toString());
    				
    				clientDb.storeClient(client);
    				JOptionPane.showMessageDialog(null,client.getfName()+" was added successfully","Done",JOptionPane.ERROR_MESSAGE);
    			    
    			}//END OF ELSE
    			
    		 }
    	});
    	
    	
    	
    	//RESET BUTTON 
    	resetBtn.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent action)
    		{
    			txtFName.setText("");
    			txtLName.setText("");
    			txtEmail.setText("");
    			txtPhone.setText("");
    			txtAddress.setText("");
    			txtA_detail.setText("");
    		}
    		
    	});
	}//END OF DEAFAULT CONSTRUCTOR


}//END OF MAKE APPOINTMENT CLASS
