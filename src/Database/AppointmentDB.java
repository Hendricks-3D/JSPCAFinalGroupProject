package Database;

import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

import clinicCustomers.Client;



public class AppointmentDB 
{

	private String fileName;
	Client client = new Client();
	private static final int BLOCK_SIZE = 4+(20*2)+(20*2)+(20*2)+(20*2)+(20*2)+(20*2)+(20*2);
	
	public AppointmentDB ()
	{
	   fileName = "Appointment Database.dat";
	}
	
	public AppointmentDB (String fileName)
	{
		this.fileName = fileName;
	}
	
    public void storeAppointment(Client client)
    {
    	try 
    	{
    		RandomAccessFile appointmentFile = new RandomAccessFile(fileName,"rw");
    		appointmentFile.seek((client.getId()-1) * BLOCK_SIZE);
            appointmentFile.writeUTF(client.changeToString());
            appointmentFile.close();//CLOSE FILE
            
           
    	}
    	catch(IOException ex)
    	{
    		System.out.println("Error writing to file"+ ex.getMessage());
    		JOptionPane.showMessageDialog(null,"Error making appointment","ERROR",JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    
    
    //-------------------RETRIEVE APPOINTMENT
    public Client retrieveAppointment(int searchId)
    {
    	try
    	{
    		String[] clients = new String[5];
    		client = new Client();
    		RandomAccessFile appointmentFile = new RandomAccessFile(fileName,"r");
    		
    		 appointmentFile.seek((searchId-1)*BLOCK_SIZE);//POSITION FILE POINTER
    		 
    		//SPILT THE STRING WHERE DELIMETER IS PRESENT AND STORE DATA AT ARRAY INDEX
    		 clients= appointmentFile.readUTF().split("\t");
 
    		 //STORE DATA IN client ARTTRIBUTES(VARIABLES)
    		 client.setId(Integer.parseInt(clients[0]));
    		 client.setfName(clients[1]);
    		 client.setlName(clients[2]);
    		 client.setEmail(clients[3]);
    		 client.setPhone(clients[4]);
    		 client.setAddress(clients[5]);
    		 client.setAnimalDetail(clients[6]);
    		 client.setPay(clients[7]);
    		 
    		 
    		 //CLOSE FILE
    		 appointmentFile.close();

    		 
    	}
    	catch(NumberFormatException ex)
    	{
    		JOptionPane.showMessageDialog(null,"Please enter only integer value for ID. ","Error",JOptionPane.ERROR_MESSAGE);
    	}
        catch(IOException ex)
    	{
        	System.out.println("Error retrieving data. ");
        	JOptionPane.showMessageDialog(null,"Error retrieving data from the file.","Error",JOptionPane.ERROR_MESSAGE);
    	}
  
    	 return client;
    	
    }//END OF RETRIEVE client
    
    
   //DELETE CLIENT
    public void deleteAppointment(Client client)
    {
    	try 
    	{
    		int tempId = client.getId();
    		client = new Client();
    		
    		RandomAccessFile appointmentFile = new RandomAccessFile(fileName,"rw");
    		appointmentFile.seek((tempId-1) * BLOCK_SIZE);
            appointmentFile.writeUTF(client.changeToString());
            appointmentFile.close();//CLOSE FILE
            
           
    	}
    	catch(IOException ex)
    	{
    		System.out.println("Error writing to file"+ ex.getMessage());
    		JOptionPane.showMessageDialog(null,"Something went wrong when swriting to the file","ERROR",JOptionPane.ERROR_MESSAGE);
    	}
    }
    

}//END OF client CLASS
