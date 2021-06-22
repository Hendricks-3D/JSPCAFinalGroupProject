package jframesClasses;



import java.io.IOException;
import java.io.RandomAccessFile;

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Database.RemovalRequestDB;
import Intervention.RemovalRequest;



@SuppressWarnings("serial")
public class OutcomeReport extends JFrame {


	/*

    private JLabel title,lblId;

    private Font titleFont,labelFont,txtFieldFont;
    private JTextField txtId;
    private FlowLayout layout;

    private DefaultTableModel model = new DefaultTableModel();
    private JTable table;
    private JScrollPane scrlPane; 
    
	public OutcomeReport() {
		super("Outcome report ");//CALL THE PARENT CLASS DEFAULT CONSTRUCTOR AND PASS TITLE
        
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
		
    	title = new JLabel(" Outcome Report");
    	title.setForeground(Color.WHITE);
    	title.setFont(titleFont);
    	title.setBounds(600,50,600,70);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
    	getContentPane().add(title);
    	
    	
    	//ID NUMBER COMPONENTS
    	lblId = new JLabel("Outcome: ");
    	lblId.setFont(labelFont);
    	lblId.setForeground(Color.WHITE);
    	lblId.setBounds(50,200,500,50);
    	add(lblId);
    	
    	txtId = new JTextField();
    	txtId.setBounds(280,200,500,50);
    	txtId.setFont(txtFieldFont);
        add(txtId);
    	
    	
        
        

  
    	
    	
    	
    	//=====================CREATING THE TABLE AND COLUMN========================
    	
    	
        //TABLE HEADINGS
    	model.addColumn("OUTCOME");
        model.addColumn("Intervention #");
        model.addColumn("FIRST NAME");
        model.addColumn("LAST NAME");
        model.addColumn("PHONE");
        model.addColumn("PAYMENT");
        model.addColumn("DATE");
        model.addColumn("TIME");

    	
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
        	
        	RemovalRequest removal = new RemovalRequest();
        	RemovalRequestDB db = new RemovalRequestDB();
        	
        	RandomAccessFile outputFile = new RandomAccessFile(db.fileName,"r");
        	
        	
        	for(int temp =1; temp<999; temp++)
        	{
        		outputFile.seek((temp-1)*db.BLOCK_SIZE);
        		
        		removal.setId(outputFile.readInt());
    			removal.getClient().setfName(outputFile.readUTF());
    			removal.getClient().setlName(outputFile.readUTF());
    			removal.getClient().setPhone(outputFile.readUTF());
    			removal.getClient().setPay(outputFile.readUTF());
    			removal.setAddress(outputFile.readUTF());		
    		    removal.getDate().setMonth(	outputFile.readInt());
    			removal.getDate().setDay(outputFile.readInt());
    			removal.getDate().setYear(outputFile.readInt());
    			removal.getTime().setHours(outputFile.readInt());
    			removal.getTime().setMinutes(outputFile.readInt());
    			removal.setOutcome(outputFile.readUTF());
    			removal.setInterventionNo(outputFile.readUTF());
    			
        	     if(removal.getOutcome().equals(""))
        	     {
        	    	// model.insertRow(row++,new Object[]{});
        	     }
        		
        	}
        	
        	outputFile.close();
        	
        }catch(IOException ex)
        {
        	
        }
        
	}//END OF DEAFAULT CONSTRUCTOR*/


}//END OF MAKE APPOINTMENT CLASS
