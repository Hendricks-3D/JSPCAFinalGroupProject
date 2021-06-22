package jframesClasses;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class AddAnimal extends JFrame {


	

    private JLabel title,lblId,lblAge,lblType,lblBreed,lblGender;
    private JTextField txtId,txtAge,txtType,txtBreed;
    private Font titleFont,labelFont,txtFieldFont;
    private JComboBox<Object> cmbGender;
    private FlowLayout layout;
    private JButton saveBtn,resetBtn;
    private String[] gender = {"","Male","Female"};
    private Animal animal;
    private AnimalDB animalDb;
    
    
	public AddAnimal() {
		super("Add Animal");//CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
        
		//FRAME SETUP
		setVisible(true);
		
	    setSize(1000,1200);
		setResizable(false);
		setLocation(250, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(52, 73, 94));
		setLayout(layout);
		
		//FONT SETUP
		titleFont=new Font("TimesNewRoman",Font.BOLD,50);
		labelFont=new Font("TimesNewRoman",Font.PLAIN,40);	
		txtFieldFont =new Font("Tahoma",Font.PLAIN,30);
		
		

		//FRAME COMPONENTS
		
    	title = new JLabel("Add Animal");
    	title.setForeground(Color.WHITE);
    	title.setFont(titleFont);
    	title.setBounds(400,50,600,70);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
    	add(title);
    	
    	
    	//ID NUMBER COMPONENTS
    	lblId = new JLabel("ID Number: ");
    	lblId.setFont(labelFont);
    	lblId.setForeground(Color.WHITE);
    	lblId.setBounds(50,200,500,50);
    	add(lblId);
    	
    	txtId = new JTextField();
    	txtId.setBounds(280,200,500,50);
    	txtId.setFont(txtFieldFont);
    	txtId.setToolTipText("Animal identification number");
        add(txtId);
        
        
        //AGE COMPONENTS
    	lblAge = new JLabel("Age: ");
    	lblAge.setFont(labelFont);
    	lblAge.setForeground(Color.WHITE);
    	lblAge.setBounds(50,300,500,50);
    	add(lblAge);
    	
    	txtAge = new JTextField();
    	txtAge.setBounds(280,300,500,50);
    	txtAge.setFont(txtFieldFont);
    	txtAge.setToolTipText("Animal age.");
        add(txtAge);
        
        //TYPE COMPONENT
    	lblType = new JLabel("Type: ");
    	lblType.setFont(labelFont);
    	lblType.setForeground(Color.WHITE);
    	lblType.setBounds(50,400,500,50);
    	add(lblType);
    	
    	txtType = new JTextField();
    	txtType.setBounds(280,400,500,50);
    	txtType.setFont(txtFieldFont);
    	txtType.setToolTipText("Animal type.");
        add(txtType);
        
        //BREED COMPONENT
        lblBreed= new JLabel("Breed: ");
    	lblBreed.setFont(labelFont);
    	lblBreed.setForeground(Color.WHITE);
    	lblBreed.setBounds(50,500,500,50);
    	add(lblBreed);
    	
    	txtBreed = new JTextField();
    	txtBreed.setBounds(280,500,500,50);
    	txtBreed.setFont(txtFieldFont);
    	txtBreed.setToolTipText("Animal breed.");
        add(txtBreed);
        
        //GENDER COMPONENT
        lblGender= new JLabel("Gender: ");
    	lblGender.setFont(labelFont);
    	lblGender.setForeground(Color.WHITE);
    	lblGender.setBounds(50,600,500,50);
    	add(lblGender);
    	
    	cmbGender = new JComboBox<Object>(gender);
    	cmbGender.setBounds(280,600,200,50);
    	cmbGender.setFont(txtFieldFont);
    	cmbGender.setToolTipText("Animal Gender.");
        add(cmbGender);
        
        
      	saveBtn = new JButton("Add", new ImageIcon("images\\save.png"));
    	saveBtn.setBounds(300,750,200,65);
    	saveBtn.setBackground(new Color(34,167, 240));
    	saveBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	saveBtn.setForeground(Color.WHITE);
    	add(saveBtn);
    	
    	
    	resetBtn = new JButton("Reset", new ImageIcon("images\\reset.png"));
    	resetBtn.setBounds(650,750,200,65);
    	resetBtn.setBackground(new Color(218, 223, 225));
    	resetBtn.setFont(new Font("Tahoma",Font.PLAIN,30));
    	resetBtn.setForeground(Color.WHITE);
    	add(resetBtn);       
    	
    	
    	//RESET BUTTON ACITIONLISTENER METHOD
    	resetBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent action)
    		{
    			//RESET ALL FIELDS 
    			txtAge.setText("");
    			txtType.setText("");
    			cmbGender.setSelectedItem("");
    			txtBreed.setText("");
    			
    			
    		}
    	});
    	
    	//SAVE BUTTON ACTIONLSTENER METHOD
    	saveBtn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent action)
    		{
    	   				
    			
	    			try
	    			{
	    				
	    				
	    				/*THE DEFAULT CONSTRUCT MUCT BE CALLED 
	    				 * OTHERWISE NULL POINTER EXCEPTION WILL BE CALLED 
	    				 * BECAUSE THE OBJECTS ARE NOT POINTING TO ANYTHING*/
	    				animal =new Animal();
		    			animalDb=new AnimalDB();
		    			
		    			//animalDb.initializeAnimal();
		    			
		    			animal.setId(Integer.parseInt(txtId.getText().toString()));
		    			animal.setAge(Integer.parseInt(txtAge.getText().toString()));
		    			animal.setBreed(txtBreed.getText());
		    			animal.setGender(cmbGender.getSelectedItem().toString());
		    			animal.setType(txtType.getText());
		    			
		    			
		    			//CALL ANIMAL DATABASE AND STORE ANIMAL TO FILE
		    			animalDb.storeAnimal(animal);
		    			JOptionPane.showMessageDialog(null,"The animal data was added successfully! ","",JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			catch(NumberFormatException ex){
	    				System.out.println("Error  getting data from text field "+ ex.getMessage());
	    			    JOptionPane.showMessageDialog(null,"Please populate each text field with valid inputs","Field",JOptionPane.ERROR_MESSAGE);
	    			}
    	
    			
    		}
    	});
        
	}//END OF DEAFAULT CONSTRUCTOR


}//END OF MAKE APPOINTMENT CLASS
