package Database;

import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

import clinicCustomers.Citizen;



public class CitizenDB 
{

	private String fileName;
	Citizen citizen = new Citizen();
	private static final int BLOCK_SIZE = 4+(20*2)+(20*2)+(20*2)+(20*2);
	
	public CitizenDB()
	{
	   fileName = "Citizen Database.dat";
	}
	
	public CitizenDB(String fileName)
	{
		this.fileName = fileName;
	}
	
    public void storecitizen(Citizen citizen)
    {
    	try 
    	{
    		RandomAccessFile citizenFile = new RandomAccessFile(fileName,"rw");
    	    citizenFile.seek((citizen.getId()-1) * BLOCK_SIZE);
            citizenFile.writeUTF(citizen.changeToString());
            citizenFile.close();//CLOSE FILE
            
           
    	}
    	catch(IOException ex)
    	{
    		System.out.println("Error writing to file"+ ex.getMessage());
    		JOptionPane.showMessageDialog(null,"Something went wrong when writing to the file","ERROR",JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    
    public Citizen retrieveCitizen(int searchId)
    {
    	try
    	{
    		String[] citizens = new String[5];
    		citizen = new Citizen();
    		RandomAccessFile citizenFile = new RandomAccessFile(fileName,"r");
    		
    		 citizenFile.seek((searchId-1)*BLOCK_SIZE);//POSITION FILE POINTER
    		 
    		//SPILT THE STRING WHERE DELIMETER IS PRESENT AND STORE DATA AT ARRAY INDEX
    		 citizens= citizenFile.readUTF().split("\t");
 
    		 //STORE DATA IN CITIZEN ARTTRIBUTES(VARIABLES)
    		 citizen.setId(Integer.parseInt(citizens[0]));
    		 citizen.setfName(citizens[1]);
    		 citizen.setlName(citizens[2]);
    		 citizen.setEmail(citizens[3]);
    		 citizen.setPhone(citizens[4]);
    		 
    		 //CLOSE FILE
    		 citizenFile.close();

    		 
    	}
    	catch(NumberFormatException ex)
    	{
    		JOptionPane.showMessageDialog(null,"Please enter only integer value for ID. ","Error",JOptionPane.ERROR_MESSAGE);
    	}
        catch(IOException ex)
    	{
        	System.out.println("Error retrieving data. ");
        	JOptionPane.showMessageDialog(null,"Error retrieving data from the file.","Error",JOptionPane.ERROR_MESSAGE);
    	}catch(ArrayIndexOutOfBoundsException ex)
    	{

    	}
  
    	 return citizen;
    	
    }//END OF RETRIEVE citizen
    
    
    public void retrieveAllCitizen()
    {
    	
    }
    
    
  //------------------DELETE CITIZEN

    public void deleteCitizen(Citizen citizen)
    {
    	try 
    	{
    		int tempId = citizen.getId();
    		citizen = new Citizen();
    		
    		
    		RandomAccessFile citizenFile = new RandomAccessFile(fileName,"rw");
    	    citizenFile.seek((tempId-1) * BLOCK_SIZE);
            citizenFile.writeUTF(citizen.changeToString());
            citizenFile.close();//CLOSE FILE
            
           
    	}
    	catch(IOException ex)
    	{
    		System.out.println("Error writing to file"+ ex.getMessage());
    		JOptionPane.showMessageDialog(null,"Something went wrong when swriting to the file","ERROR",JOptionPane.ERROR_MESSAGE);
    	}
    }
}//END OF citizen CLASS
