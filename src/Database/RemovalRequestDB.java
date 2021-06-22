package Database;


import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

import java.io.IOException;
import Intervention.RemovalRequest;
import clinicCustomers.Client;

public class RemovalRequestDB 
{
	
	public String fileName;
	public static final int BLOCK_SIZE =4+ (20*2)+ (20*2)+ (20*2)+ (20*2)+ (20*2)+4+4+4+4+4;
	RemovalRequest removal =new RemovalRequest();
	
	
	public RemovalRequestDB()
	{
		fileName ="Removal Request.dat";
	}//END OF DEFAULT CONSTRUCTOR
	
	
	public RemovalRequestDB(String fileName)
	{
		this.fileName = fileName;	
	}
	
    
	public void storeRemovalRequest(RemovalRequest removal)
	{
		try 
		{
            
			RandomAccessFile inputFile = new RandomAccessFile(fileName,"rw");
			inputFile.seek((removal.getId()-1)*BLOCK_SIZE);
			
			removal.setInterventionNo( removal.getDate().getYear()+""+removal.getDate().getMonth()+""+removal.getDate().getDay()+"-"+removal.getId());

			
			inputFile.writeInt(removal.getId());
			inputFile.writeUTF(removal.getClient().getfName());
			inputFile.writeUTF(removal.getClient().getlName());
			inputFile.writeUTF(removal.getClient().getPhone());
			inputFile.writeUTF(removal.getClient().getPay());
			inputFile.writeUTF(removal.getAddress());		
			inputFile.writeInt(removal.getDate().getMonth());
			inputFile.writeInt(removal.getDate().getDay());
			inputFile.writeInt(removal.getDate().getYear());
			inputFile.writeInt(removal.getTime().getHours());
			inputFile.writeInt(removal.getTime().getMinutes());
			inputFile.writeUTF(removal.getOutcome());
			inputFile.writeUTF(removal.getInterventionNo());
			
			
			inputFile.close();
			
			
		}catch(IOException ex)
		{
			JOptionPane.showMessageDialog(null,"Error storing the removal request","Error",JOptionPane.ERROR_MESSAGE);
		}
	}//END OF STORE REMOVAL REQUEST METHOD

	//-----------------RETRIEVED REMOVAL REQUEST
	public RemovalRequest retrieveRemovalRequest(int searchId)
	{
		
		
		try 
		{

			RandomAccessFile outputFile = new RandomAccessFile(fileName,"rw");
			outputFile.seek((searchId-1)*BLOCK_SIZE);//POSITION FILE POINTER
			
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
			
			

			
			//removal.setInterventionNo(outputFile.readUTF());
			
			
			outputFile.close();//CLOSE FILE
			
			/*Once the animal is removed it is either kept for adoption or it is
			euthanized, the removal request records the outcome of the removal.*/
			
		}catch(IOException ex)
		{
			JOptionPane.showMessageDialog(null,"Error retrieving the removal request","Error",JOptionPane.ERROR_MESSAGE);
		}
    	catch(NumberFormatException ex)
    	{
    		System.out.println("Error empty string: "+ ex.getMessage());
    	}catch(ArrayIndexOutOfBoundsException ex)
    	{

    	}
		
	return removal;	
	}//END OF STORE REMOVAL REQUEST METHOD
	
	
	
	   //DELETE REQUEST
    public void deleteRemovalRequest( RemovalRequest request)
    {
    	try 
    	{
    		int tempId = request.getId();
    		request = new RemovalRequest();
    		
    		RandomAccessFile inputFile = new RandomAccessFile(fileName,"rw");
    		inputFile.seek((tempId-1) * BLOCK_SIZE);
    		
			inputFile.writeInt(removal.getId());
			inputFile.writeUTF(removal.getClient().getfName());
			inputFile.writeUTF(removal.getClient().getlName());
			inputFile.writeUTF(removal.getClient().getPhone());
			inputFile.writeUTF(removal.getClient().getPay());
			inputFile.writeUTF(removal.getAddress());
			
			inputFile.writeInt(removal.getDate().getMonth());
			inputFile.writeInt(removal.getDate().getDay());
			inputFile.writeInt(removal.getDate().getYear());
			inputFile.writeInt(removal.getTime().getHours());
			inputFile.writeInt(removal.getTime().getMinutes());
    		inputFile.close();//CLOSE FILE
            
           
    	}
    	catch(IOException ex)
    	{
    		System.out.println("Error writing to file"+ ex.getMessage());
    		JOptionPane.showMessageDialog(null,"Something went wrong when swriting to the file","ERROR",JOptionPane.ERROR_MESSAGE);
    	}
    }
    	
    
    
	
}//END OF REMOVAL REQUEST CLASS
