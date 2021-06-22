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
import animal.Animal;

//REMOVE SERIALIVersionUID WARNING
@SuppressWarnings("serial")
public class FindAnimal extends JFrame {


	

    private JLabel title,lblId,lblAge,lblType,lblBreed,lblGender;
    private JTextField txtId,txtAge,txtType,txtBreed,txtGender;
    private Font titleFont,labelFont,txtFieldFont;
    private FlowLayout layout;
    private JButton retrieveBtn,resetBtn;
    private Animal animal;
    private AnimalDB animalDb;
    
    
	public FindAnimal() {
		super("Find Animal ");//CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
        
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
		
    	title = new JLabel("Find Animal by Id No.");
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
    	txtId.setToolTipText("Animal identification number");
        add(txtId);
        
        
        //AGE COMPONENTS
    	lblAge = new JLabel("Age: ");
    	lblAge.setFont(labelFont);
    	lblAge.setForeground(Color.WHITE);
    	lblAge.setBounds(400,400,500,50);
    	add(lblAge);
    	
    	txtAge = new JTextField();
    	txtAge.setBounds(580,400,500,50);
    	txtAge.setFont(txtFieldFont);
    	txtAge.setEditable(false);
    	txtAge.setToolTipText("Animal age.");
        add(txtAge);
        
        //TYPE COMPONENT
    	lblType = new JLabel("Type: ");
    	lblType.setFont(labelFont);
    	lblType.setForeground(Color.WHITE);
    	lblType.setBounds(400,500,500,50);
    	add(lblType);
    	
    	txtType = new JTextField();
    	txtType.setBounds(580,500,500,50);
    	txtType.setFont(txtFieldFont);
    	txtType.setEditable(false);
    	txtType.setToolTipText("Animal type.");
        add(txtType);
        
        //BREED COMPONENT
        lblBreed= new JLabel("Breed: ");
    	lblBreed.setFont(labelFont);
    	lblBreed.setForeground(Color.WHITE);
    	lblBreed.setBounds(400,600,500,50);
    	add(lblBreed);
    	
    	txtBreed = new JTextField();
    	txtBreed.setBounds(580,600,500,50);
    	txtBreed.setFont(txtFieldFont);
    	txtBreed.setToolTipText("Animal breed.");
        add(txtBreed);
        
        //GENDER COMPONENT
        lblGender= new JLabel("Gender: ");
    	lblGender.setFont(labelFont);
    	lblGender.setForeground(Color.WHITE);
    	lblGender.setBounds(400,700,500,50);
    	add(lblGender);
    	
    	txtGender = new JTextField();
    	txtGender.setBounds(580,700,200,50);
    	txtGender.setFont(txtFieldFont);
    	txtGender.setEditable(false);
        add(txtGender);
        
        
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
    			txtAge.setText("");
    			txtType.setText("");
    			txtGender.setText("");
    			txtBreed.setText("");
    			
    			
    		}
    	});
    	
    	//RETRIEVE BUTTON ACTIONLSTENER METHOD
    	retrieveBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent action)
    		{
    	   				
    			    
	    			animal =new Animal();
					animalDb=new AnimalDB();
					
     	
					animal = animalDb.retrieveAnimal(Integer.parseInt(txtId.getText().toString()));
					
					 
		    		 if(animal.getBreed().equals("")|| animal.getAge()==0)
		    		 {
		    			 JOptionPane.showMessageDialog(null,"Animal Data not found","Not found",JOptionPane.ERROR_MESSAGE);
		    		 }
		    		 else
		    		 {
							txtType.setText(animal.getType());
							txtBreed.setText(animal.getBreed());
							txtAge.setText(String.valueOf(animal.getAge()));
							txtGender.setText(animal.getGender()); 
		    		 }
		    		 

    	
    			
    		}
    	});
        
	}//END OF DEAFAULT CONSTRUCTOR


}//END OF MAKE APPOINTMENT CLASS
