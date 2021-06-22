/*THIS  FORM WILL RECORD ALL THE DETAILS ABOUT A CITIZEN AND THE
 * ANIMAL HE'S REPORTING.*/

package jframesClasses;


import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ReportAnimal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblFName, lblLName,lblEmail,lblPhone;
	private JTextField txtFName,txtLName,txtEmail,txtPhone;
	private JLabel title;
	private Font titleFont,labelFont,txtFieldFont;
	private FlowLayout layout;
	private JButton resetBtn, saveBtn;
	
	/**
	 * Create the frame.
	 */
	public ReportAnimal() {
		super("Report Animal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(230,100,1500,1000);
		setResizable(false);
		setVisible(true);
		getContentPane().setBackground(new Color(52, 73, 94));
		getContentPane().setLayout(layout);
		
		
		//FONT SETUP
		titleFont=new Font("TimesNewRoman",Font.BOLD,50);
		labelFont=new Font("TimesNewRoman",Font.PLAIN,40);
	    txtFieldFont = new Font("Tahoma", Font.PLAIN, 30 );
		
	   	title = new JLabel("Report Animals");
    	title.setForeground(Color.WHITE);
    	title.setFont(titleFont);
    	title.setBounds(450,50,600,70);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
    	getContentPane().add(title);
		
    	
    	//FIRST NAME JLABEL
		lblFName = new JLabel("First Name");
		lblFName.setBounds(50,200,300,45);
		lblFName.setFont(labelFont);
		lblFName.setForeground(Color.WHITE);
		getContentPane().add(lblFName);
		
		
		txtFName = new JTextField();
		txtFName.setBounds(250,200, 300, 50);
		txtFName.setFont(txtFieldFont);
		getContentPane().add(txtFName);
		
    	//LAST NAME COMPONENTS
		lblLName = new JLabel("Last Name");
		lblLName.setBounds(700,200,300,45);
		lblLName.setFont(labelFont);
		lblLName.setForeground(Color.WHITE);
		getContentPane().add(lblLName);
		
		
		txtLName = new JTextField();
		txtLName.setBounds(950,200, 300, 50);
		txtLName.setFont(txtFieldFont);
		getContentPane().add(txtLName);
		
		//EMAIL COMPONENTS
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(50,300,300,45);
		lblEmail.setFont(labelFont);
		lblEmail.setForeground(Color.WHITE);
		getContentPane().add(lblEmail);
		
		
		txtEmail = new JTextField();
		txtEmail.setBounds(250,300, 400, 50);
		txtEmail.setFont(txtFieldFont);
		getContentPane().add(txtEmail);
		
		//CONTACT NUMBER COMPONENT
		lblPhone = new JLabel("Mobile No. ");
		lblPhone.setBounds(50,400,300,45);
		lblPhone.setFont(labelFont);
		lblPhone.setForeground(Color.WHITE);
		getContentPane().add(lblPhone);
		
		
		txtLName = new JTextField();
		txtLName.setBounds(250,400, 300, 50);
		txtLName.setFont(txtFieldFont);
		getContentPane().add(txtLName);
		
		//BUTTONS
		saveBtn = new JButton("Save");
		saveBtn.setBounds(400,550,200,65);
		saveBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
		saveBtn.setBackground(new Color(25, 181, 254));//RGB
		saveBtn.setForeground(Color.WHITE);
		getContentPane().add(saveBtn);//CAN HAVE  getContentPane().add(saveBtn) OR JUST .add(saveBtn)
		
		
	 	resetBtn = new JButton("Reset");
    	resetBtn.setBounds(750,550,200,65);
    	resetBtn.setBackground(new Color(217, 30, 24));
    	resetBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	resetBtn.setForeground(Color.WHITE);
    	add(resetBtn);
		
		
	}//END OF DEFAULT CONSTRUCTOR

}//END OF REPORTANIMAL CLASS
