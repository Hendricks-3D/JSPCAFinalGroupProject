import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jframesClasses.*;


public class MainMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menu_1, menu_2,menu_3,menu_4,menu_5,menu_6,menu_7,menu_8,menu_9;
	private JMenuItem mItem1_1, mItem1_2,mItem1_3, mItem1_4, mItem1_5, mItem7;//ADD MENU ITEMS
	private JMenuItem mItem4_1,mItem4_2,mItem4_3,mItem3_2;//SEARCH MENU ITEM
	private JMenuItem mItem2_1,mItem2_2,mItem2_3;//UPDATE MENU ITEMS
	private JMenuItem mItem6_1,mItem6_2,mItem6_3;//DELETE MENU ITEMS
	private JMenuItem mItem8_1,mItem8_2,mItem8_3,mItem8_4,mItem8_5;
	private JMenuItem mItem5_1;//VIEW ALL MENU ITEMS
	private Font menuFont;
	private ImageIcon image;
	private JLabel logo;

	//DEFAULT CONSTRUCTOR
	public MainMenu() {
		super("JSPCA Management System");// JFRAME TITLE
		this.setVisible(false);
		
		//FRAME SETUP
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(2500,1700);	
		setLocation(600,200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getContentPane().setBackground(Color.white);
		setLayout(null);
	    
	     //ADD IMAGE TO THE WINDOW	       
		    image  = new ImageIcon("images\\logo.png");
		  //new ImageIcon(getClass().getResource("images\\paw.png"));
		    logo= new JLabel();	    
		    logo.setBounds(500,300,1500,1020);
		    logo.setIcon(image);
		    getContentPane().add(logo);

		    this.repaint();
		    
		 
		menuFont =new Font("TimesNewRoman",Font.BOLD,25);
		
		//ADD COMPONENTS TO JFRAME
		menuBar = new JMenuBar();
		
		setJMenuBar(menuBar);
		menuBar.setBackground(new Color(30, 139, 195));

		//JMenus
		menu_1 = new JMenu("Add");
		menu_1.setForeground(Color.white);
		menu_1.setFont(menuFont);
		menuBar.add(menu_1);
	
		
		menu_2 = new JMenu("Update");
		menu_2.setForeground(Color.white);
		menu_2.setFont(menuFont);
		menuBar.add(menu_2);
		

		
		menu_4 = new JMenu("Search");
		menu_4.setForeground(Color.white);
		menu_4.setFont(menuFont);
		menuBar.add(menu_4);
		
		menu_5 = new JMenu("View All");
		menu_5.setForeground(Color.white);
		menu_5.setFont(menuFont);
		menuBar.add(menu_5);
		
		menu_6 = new JMenu("Delete");
		menu_6.setForeground(Color.white);
		menu_6.setFont(menuFont);
		menuBar.add(menu_6);
		
		menu_8 = new JMenu("Removal Request");
		menu_8.setForeground(Color.white);
		menu_8.setFont(menuFont);
		menuBar.add(menu_8);
		
		menu_3 = new JMenu("Appointment");
		menu_3.setForeground(Color.white);
		menu_3.setFont(menuFont);
		menuBar.add(menu_3);
		
		menu_9 = new JMenu("Report");
		menu_9.setForeground(Color.white);
		menu_9.setFont(menuFont);
		menuBar.add(menu_9);
		
		menu_7 = new JMenu("Exit");
		menu_7.setForeground(Color.white);
		menu_7.setFont(menuFont);
		menuBar.add(menu_7);
		
		//JMENU ITEMS
		mItem1_1 = new JMenuItem("Make Appointment",new ImageIcon("images\\appointment.png"));
		menu_3.add(mItem1_1);
		mItem1_1.setFont(menuFont);
		mItem1_1.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		mItem3_2 = new JMenuItem("Find Appointment",new ImageIcon("images\\search.png"));
		menu_3.add(mItem3_2);
		mItem3_2.setFont(menuFont);
		mItem3_2.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		//JMENU ITEMS Add
		mItem1_2 = new JMenuItem("Report", new ImageIcon("images\\report.png"));
		menu_9.add(mItem1_2);
		mItem1_2.setFont(menuFont);
		mItem1_2.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		mItem1_3 = new JMenuItem("Client", new ImageIcon("images\\addclient.png"));
		menu_1.add(mItem1_3);
		mItem1_3.setFont(menuFont);
		mItem1_3.addActionListener(this);
		
		mItem1_4 = new JMenuItem("Animal", new ImageIcon("images\\dog.png"));
		menu_1.add(mItem1_4);
		mItem1_4.setFont(menuFont);
		mItem1_4.addActionListener(this);
		
		
		mItem1_5 = new JMenuItem("Citizen", new ImageIcon("images\\addclient.png"));
		menu_1.add(mItem1_5);
		mItem1_5.setFont(menuFont);
		mItem1_5.addActionListener(this);
		
		
		//SEARCH J MENU ITEMS
		mItem4_1 = new JMenuItem("Find Animal", new ImageIcon("images\\searchanimal.png"));
		menu_4.add(mItem4_1);
		mItem4_1.setFont(menuFont);
		mItem4_1.addActionListener(this);
		
		mItem4_2 = new JMenuItem("Find Citizen", new ImageIcon("images\\searchfemale.png"));
		menu_4.add(mItem4_2);
		mItem4_2.setFont(menuFont);
		mItem4_2.addActionListener(this);
		
		mItem4_3 = new JMenuItem("Find Client", new ImageIcon("images\\search.png"));
		menu_4.add(mItem4_3);
		mItem4_3.setFont(menuFont);
		mItem4_3.addActionListener(this);
		
		mItem7 = new JMenuItem("Exit",new ImageIcon("images\\close.png"));
		menu_7.add(mItem7);
		mItem7.setFont(menuFont);
		mItem7.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		
		//UPDATE JMENU ITEMS
		mItem2_1 = new JMenuItem("Animal",new ImageIcon("images\\update.png"));
		menu_2.add(mItem2_1);
		mItem2_1.setFont(menuFont);
		mItem2_1.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		mItem2_2 = new JMenuItem("Citizen",new ImageIcon("images\\update1.png"));
		menu_2.add(mItem2_2);
		mItem2_2.setFont(menuFont);
		mItem2_2.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		mItem2_3 = new JMenuItem("Client",new ImageIcon("images\\update.png"));
		menu_2.add(mItem2_3);
		mItem2_3.setFont(menuFont);
		mItem2_3.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		
		//DELETE
		mItem6_1 = new JMenuItem("Animal",new ImageIcon("images\\delete.png"));
		menu_6.add(mItem6_1);
		mItem6_1.setFont(menuFont);
		mItem6_1.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		mItem6_2 = new JMenuItem("Client",new ImageIcon("images\\deletePerson.png"));
		menu_6.add(mItem6_2);
		mItem6_2.setFont(menuFont);
		mItem6_2.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		mItem6_3 = new JMenuItem("Citizen",new ImageIcon("images\\deletePerson.png"));
		menu_6.add(mItem6_3);
		mItem6_3.setFont(menuFont);
		mItem6_3.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		mItem8_1 = new JMenuItem("Add",new ImageIcon("images\\addRemoval.png"));
		menu_8.add(mItem8_1);
		mItem8_1.setFont(menuFont);
		mItem8_1.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		mItem8_2 = new JMenuItem("Update",new ImageIcon("images\\update.png"));
		menu_8.add(mItem8_2);
		mItem8_2.setFont(menuFont);
		mItem8_2.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		
		mItem8_3 = new JMenuItem("Find",new ImageIcon("images\\search.png"));
		menu_8.add(mItem8_3);
		mItem8_3.setFont(menuFont);
		mItem8_3.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		
		mItem8_4 = new JMenuItem("View All",new ImageIcon("images\\search.png"));
		menu_8.add(mItem8_4);
		mItem8_4.setFont(menuFont);
		mItem8_4.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		
		
		mItem5_1 = new JMenuItem("Animal",new ImageIcon("images\\.png"));
		menu_5.add(mItem5_1);
		mItem5_1.setFont(menuFont);
		mItem5_1.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		
		mItem8_5 = new JMenuItem("Delete",new ImageIcon("images\\delete.png"));
		menu_8.add(mItem8_5);
		mItem8_5.setFont(menuFont);
		mItem8_5.addActionListener(this);//WOULD HAVE TO  CAST WITHOUT IMPLEMENT EG: mItem1_1.addActionListener((ActionListener) this);
		
		
	    /*SETVISIBLE IS HERE TO RELOAD JFRAME TO ENSURE THAT IT LOADS JmMenuBar AND
	     * THE IMAGE WITH THE HELP OF this.repaint()*/
		this.setVisible(true);
		
		
	}//END OF DEFAULT CONSTRUCTORS
	

	
	public void actionPerformed(ActionEvent action)
	{
		if(action.getSource()==mItem1_3)
		{
			new AddClient();
		}
		else if(action.getSource()==mItem1_2)
		{
			new ReportAnimal();
		}else if(action.getSource()==mItem1_1)
		{
			new AddAppointment();
		}else if(action.getSource()==mItem1_4)
		{
			new AddAnimal();
		}
		else if(action.getSource()==mItem1_5)
		{
			new AddCitizen();
		}
		else if(action.getSource()==mItem4_1)
		{
			new FindAnimal();
		}
		else if(action.getSource()==mItem4_2)
		{
			new FindCitizen();
		}
		else if(action.getSource()==mItem4_3)
		{
			new FindClient();
		}
		else if(action.getSource()==mItem2_1)
		{
			new UpdateAnimal();
		}
		else if(action.getSource()==mItem2_2)
		{
			new UpdateCitizen();
		}
		else if(action.getSource()==mItem2_3)
		{
			new UpdateClient();
		}else if(action.getSource()==mItem6_1)
		{
			new DeleteAnimal();
		}else if(action.getSource()==mItem6_2)
		{
			new DeleteClient();
		}else if(action.getSource()==mItem6_3)
		{
		   new DeleteCitizen();
		}
		else if(action.getSource()==mItem8_1)
		{
		   new addRemovalRequest();	
		}
		else if(action.getSource()==mItem8_2)
		{
			 new UpdateRemovalRequest();
		}
		else if(action.getSource()==mItem8_3)
		{
		      new FindRemovalRequest();	
		}
		else if(action.getSource()==mItem8_4)
		{
			//new viewAllRemovalRequest();
		}else if(action.getSource()==mItem5_1)
		{
			new ViewAllAnimal();
		}
		else if(action.getSource()==mItem8_5)
		{
			new DeleteRemovalRequest();
		}
		else if(action.getSource()==mItem3_2)
		{
			new FindAppointment();
		}
		else if(action.getSource()==mItem7)
		{
			int dialogResult = JOptionPane.showConfirmDialog(null,"ARE  YOU SURE YOU WANT TO LOGOUT?","CONFIRMATION",JOptionPane.YES_NO_OPTION);
			
			if(dialogResult== JOptionPane.YES_OPTION)
			{
				System.exit(0);//EXIT THE PROGRAM
			}
		
		}
		
		
		
	}//END OF ACTION PERFORMED
	
	
	
}//END OF MAIN MENU CLASS
