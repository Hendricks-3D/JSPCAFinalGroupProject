package jframesClasses;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Database.AnimalDB;
import animal.Animal;

//REMOVE SERIALIVersionUID WARNING
@SuppressWarnings("serial")
public class ViewAllAnimal extends JFrame {


	

    private JLabel title;

    private Font titleFont,labelFont,txtFieldFont;

    private FlowLayout layout;
    private Animal animal;
    private AnimalDB animalDb;
    private DefaultTableModel model = new DefaultTableModel();
    private JTable table;
    private JScrollPane scrlPane; 
    
	public ViewAllAnimal() {
		super("All Animal");//CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
        
		//FRAME SETUP
		setVisible(true);
		getContentPane().setLayout(layout);
	    setSize(1500,1300);
		setResizable(false);
		setLocation(250, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(52, 73, 94));

		//FONT SETUP
		titleFont=new Font("TimesNewRoman",Font.BOLD,50);
		labelFont=new Font("TimesNewRoman",Font.PLAIN,40);	
		txtFieldFont =new Font("Tahoma",Font.PLAIN,30);
		

		//FRAME COMPONENTS
		
    	title = new JLabel("All Animal");
    	title.setForeground(Color.WHITE);
    	title.setFont(titleFont);
    	title.setBounds(600,50,600,70);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
    	getContentPane().add(title);
    	
    	
    	
        
        

  
    	
    	
    	
    	//=====================CREATING THE TABLE AND COLUMN========================
    	
    	
        //TABLE HEADINGS
        model.addColumn("ID");
        model.addColumn("AGE");
        model.addColumn("TYPE");
        model.addColumn("BREED");
        model.addColumn("GENDER");
    	
        table = new JTable(model);
        table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);    
        table.setFillsViewportHeight(true);
        table.setForeground(Color.BLUE);
        table.setFont(new Font ("Times New Roman",0,25));
        
        scrlPane = new JScrollPane(table);
        scrlPane.setBounds(50,150,1400,800);    
        scrlPane.setVisible(true);
        add(scrlPane);
        
       

        try 
        {
        	int row =0;
        	
        	Animal animal = new Animal();
        	AnimalDB db = new AnimalDB();
        	RandomAccessFile animalFile = new RandomAccessFile(db.fileName,"r");
        	
        	
        	for(int temp =1; temp<999; temp++)
        	{
        		animalFile.seek((temp-1)*db.BLOCK_SIZE);
        		
	        	 animal.setId(animalFile.readInt());
	       		 animal.setAge(animalFile.readInt());
	       		 animal.setBreed(animalFile.readUTF());
	       		 animal.setGender(animalFile.readUTF());
	       		 animal.setType(animalFile.readUTF());
        		
        	     if(animal.getId()!=0)
        	     {
        	    	 model.insertRow(row++,new Object[]{animal.getId(),animal.getAge(),animal.getType(),animal.getBreed(),animal.getGender()});
        	     }
        		
        	}
        	
        }catch(IOException ex)
        {
        	
        }
        
	}//END OF DEAFAULT CONSTRUCTOR


}//END OF MAKE APPOINTMENT CLASS
