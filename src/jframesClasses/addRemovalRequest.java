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
import javax.swing.JTextField;

import Database.RemovalRequestDB;
import Intervention.RemovalRequest;
import clinicCustomers.Client;
import dateTime.*;

public class addRemovalRequest extends JFrame {

	private static final long serialVersionUID = 1L;
	

    private JLabel title,lblFName,lblLName,lblPhone,lblAddress,lblPay,lblId,lblOutcome;
    private JTextField txtFName,txtLName,txtPhone,txtAddress,txtId;
    private JTextField txtMonth,txtDay,txtYear,txtHours,txtMinutes;
    private JLabel lblMonth,lblDay,lblYear,lblHours,lblMinutes;
    
    
    private Font titleFont,labelFont;
    private JComboBox cmbPay,cmbOutcome;
    private FlowLayout layout;
    private JButton saveBtn,resetBtn;
    private String[] pay = {"--select--","Contribute","Full","None"};
    private String[] outcome = {"--select--","Adoption","Euthanize"};
    Client client;
    Time time;
    Date date;
    
    
	public addRemovalRequest() {
		super("Removal Request");//CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
        
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
		
		date = new Date();

		//FRAME COMPONENTS		
    	title = new JLabel("Add Removal Request");
    	title.setForeground(Color.WHITE);
    	title.setFont(titleFont);
    	title.setBounds(500,50,800,70);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
    	getContentPane().add(title);
    	
    	//Intervention number
      	lblId = new JLabel("Intervention ID#: ");
    	lblId.setForeground(Color.WHITE);
    	lblId.setFont(labelFont);
    	lblId.setBounds(50,200,400,30);
    	add(lblId);
    	
    	txtId= new JTextField();
    	txtId.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtId.setToolTipText("Client first name");
    	txtId.setBounds(330,200,400,50);
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
    	
    	
    	 
    	
    	//PHONE
    	lblPhone = new JLabel("Contact No.");
    	lblPhone.setForeground(Color.WHITE);
    	lblPhone.setFont(labelFont);
    	lblPhone.setBounds(50,500,500,30);
    	add(lblPhone );
    	
    	txtPhone  = new JTextField();
    	txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtPhone.setToolTipText("Client's phone number");
    	txtPhone.setBounds(270,500,500,50);
    	txtPhone.setBorder(BorderFactory.createLineBorder(new Color(51, 110, 123)));
    	add(txtPhone);
    	
    	//ADDRESS
    	lblAddress = new JLabel("Removal Address: ");
    	lblAddress.setForeground(Color.WHITE);
    	lblAddress.setFont(labelFont);
    	lblAddress.setBounds(50,600,500,30);
    	add(lblAddress );
    	
    	txtAddress   = new JTextField();
    	txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtAddress.setToolTipText("Client's phone number");
    	txtAddress.setBounds(270,650,700,50);
    	txtAddress.setBorder(BorderFactory.createLineBorder(new Color(51, 110, 123)));
    	add(txtAddress);
    	
    	//PAY
    	lblPay = new JLabel("Payment: ");
    	lblPay .setFont(labelFont);
    	lblPay.setForeground(Color.WHITE);
    	lblPay.setBounds(50,750,500,50);
    	add(lblPay);
    	
    	cmbPay = new JComboBox(pay);
    	cmbPay.setFont(labelFont);
    	cmbPay.setBounds(270,750,400,50);
    	add(cmbPay);
    	
    	
    	lblOutcome = new JLabel("Outcome: ");
    	lblOutcome .setFont(labelFont);
    	lblOutcome.setForeground(Color.WHITE);
    	lblOutcome.setBounds(50,850,500,50);
    	add(lblOutcome);
    	
    	cmbOutcome = new JComboBox(outcome);
    	cmbOutcome.setFont(labelFont);
    	cmbOutcome.setBounds(270,850,400,50);
    	add(cmbOutcome);
    	

    	//MONTH TXT
    	
    	lblMonth = new JLabel("MM : ");
    	lblMonth.setForeground(Color.WHITE);
    	lblMonth.setFont(labelFont);
    	lblMonth.setBounds(900,200,100,30);
    	add(lblMonth);
    	
    	txtMonth= new JTextField();
    	txtMonth.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtMonth.setToolTipText("Removal date");
    	txtMonth.setBounds(1020,200,40,50);
    	add(txtMonth);
    	
    	
    	//DATE AND TIME
    	//DAY TXT
    	lblDay = new JLabel("DD : ");
    	lblDay.setForeground(Color.WHITE);
    	lblDay.setFont(labelFont);
    	lblDay.setBounds(1130,200,150,40);
    	add(lblDay);
    	
    	txtDay= new JTextField();
    	txtDay.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtDay.setToolTipText("Removal date");
    	txtDay.setBounds(1230,200,40,50);
    	add(txtDay); 
    	
    	//YEAR TXT
    	lblYear = new JLabel("YYYY : ");
    	lblYear.setForeground(Color.WHITE);
    	lblYear.setFont(labelFont);
    	lblYear.setBounds(1300,200,150,40);
    	add(lblYear);
    	
    	txtYear= new JTextField();
    	txtYear.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtYear.setToolTipText("Removal date");
    	txtYear.setBounds(1460,200,90,50);
    	add(txtYear); 
    	
    	
    	//TIME
    	
    	lblHours = new JLabel("HH : ");
    	lblHours.setForeground(Color.WHITE);
    	lblHours.setFont(labelFont);
    	lblHours.setBounds(900,300,100,30);
    	add(lblHours);
    	
    	txtHours= new JTextField();
    	txtHours.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtHours.setToolTipText("Removal date");
    	txtHours.setBounds(1020,300,80,50);
    	add(txtHours); 
    	

    	lblMinutes = new JLabel("MM : ");
    	lblMinutes.setForeground(Color.WHITE);
    	lblMinutes.setFont(labelFont);
    	lblMinutes.setBounds(1130,300,150,40);
    	add(lblMinutes);
    	
    	txtMinutes = new JTextField();
    	txtMinutes.setFont(new Font("Tahoma", Font.PLAIN, 30));
    	txtMinutes.setToolTipText("Removal date");
    	txtMinutes.setBounds(1230,300,80,50);
    	add(txtMinutes); 
    	
    	saveBtn = new JButton("Add", new ImageIcon("images\\add-icon.png"));
    	saveBtn.setBounds(500,1000,200,65);
    	saveBtn.setBackground(new Color(34,167, 240));
    	saveBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	saveBtn.setForeground(Color.WHITE);
    	add(saveBtn);
    	
    	
    	
    	
    	resetBtn = new JButton("Reset", new ImageIcon("images\\reset.png"));
    	resetBtn.setBounds(900,1000,200,65);
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
            	   RemovalRequest removal = new RemovalRequest();
            	   RemovalRequestDB removalDB = new RemovalRequestDB();
       		       
            	   int month = Integer.parseInt(txtMonth.getText());
            	   int day = Integer.parseInt(txtDay.getText());
            	   int year = Integer.parseInt(txtYear.getText());
            	   int hrs =Integer.parseInt(txtHours.getText());
            	   int min = Integer.parseInt(txtMinutes.getText());
            	   
            	   
            	   //VALIDATE DATE AND TIME 
            	   
            	   if(month< 0 || month >12)
            	   {
            		   JOptionPane.showMessageDialog(null,"Enter a valid month [1]-[12]","ERROR",JOptionPane.ERROR_MESSAGE);  
            	   }else if(day <0 || day>31)
            	   {
            		   JOptionPane.showMessageDialog(null,"Enter a valid day [1]-[31]","ERROR",JOptionPane.ERROR_MESSAGE);    
            	   }else if(hrs<0 || hrs>24)
            	   {
            		   JOptionPane.showMessageDialog(null,"Enter a valid hour [1]-[24]","ERROR",JOptionPane.ERROR_MESSAGE);  
            	   }else if(min <0|| min>59)
            	   {
            		   JOptionPane.showMessageDialog(null,"Enter a valid minute [0]-[60]","ERROR",JOptionPane.ERROR_MESSAGE);  
            	   }else if(year <2017 || year >2099)
            	   {
            		   JOptionPane.showMessageDialog(null,"Enter a valid year [2017]-[2099]","ERROR",JOptionPane.ERROR_MESSAGE);  
            	   }
            	   else
            	   {
            		   
            	   
	            	   //RETRIEVE USER INPUTS FROM TEXTFIELD
	            	   removal.setId(Integer.parseInt(txtId.getText()));
	            	   removal.getClient().setfName(txtFName.getText());
	            	   removal.getClient().setlName(txtLName.getText());
	            	   removal.getClient().setPhone(txtPhone.getText());
	            	   removal.getClient().setPay(cmbPay.getSelectedItem().toString());
	    			   removal.setAddress(txtAddress.getText());
	    			   removal.getDate().setMonth(month);
	    			   removal.getDate().setDay(day);
	    			   removal.getDate().setYear(year);
	    			   removal.getTime().setMinutes(min);
	    			   removal.getTime().setHours(hrs);
	    			   removal.setOutcome(cmbOutcome.getSelectedItem().toString());
	    			   
	    			   
	    			   removalDB.storeRemovalRequest(removal);  //WRITE DATA TO FILE
	    			   JOptionPane.showMessageDialog(null,"Removal request save successfully","Saved",JOptionPane.INFORMATION_MESSAGE);
	               }//END OF ELSE 
               }	
               catch(NumberFormatException ex)
               {
   				System.out.println("Error  getting data from text field "+ ex.getMessage());
			    JOptionPane.showMessageDialog(null,"Please populate each text field with valid inputs","Field",JOptionPane.ERROR_MESSAGE);
			  }//END OF CATCH
    	
    			
    		 }
    	});
    
    	
    	//------------RESET BUTTON ACION LISTENER
    	resetBtn.addActionListener(new ActionListener() 
    	{
    		public void actionPerformed(ActionEvent action)
    		{
       			//RESET ALL FIELDS 
    			txtId.setText("");
    			txtFName.setText("");
    			txtLName.setText("");
    			txtPhone.setText("");
    			cmbPay.setSelectedItem("");
    			txtPhone.setText("");
    			txtAddress.setText("");
    			txtMonth.setText("");
    			txtHours.setText("");
    			txtDay.setText("");
    			txtYear.setText("");
    			txtMinutes.setText("");
    		}
    	});
    	
	}//END OF DEAFAULT CONSTRUCTOR


}//END OF MAKE APPOINTMENT CLASS
