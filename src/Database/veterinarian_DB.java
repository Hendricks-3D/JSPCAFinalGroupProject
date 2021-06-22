package Database;


import clinic.Veterinarian;

import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;






public class veterinarian_DB 
{
	private static String fileName;
	Veterinarian vet = new Veterinarian();
	
	private static final int BLOCK= 4+(20*2)+(20*2);
	
	public veterinarian_DB()
	{
		fileName="Veterinarian.dat";
		
	}
	
	public veterinarian_DB(String fileName)
	{
		this.fileName=fileName;
	}
	
	
	
	 public static void storeVeterinarian(Veterinarian veterinarian)
	 {
		 try
		 {
			 RandomAccessFile veterinarianFile = new RandomAccessFile(fileName,"rw");
			 veterinarianFile.seek((veterinarian.getID()-1)*BLOCK);
			 
			 // WRITE TO FILE
			 
			 veterinarianFile.writeInt(veterinarian.getID());
			 veterinarianFile.writeUTF(veterinarian.getfName());
			 veterinarianFile.writeUTF(veterinarian.getlName());
			 veterinarianFile.close();
			 
			 
			 
		
			 
		 }
		 catch(IOException ex)
		 {
			 System.out.println("Error writing to file"+ ex.getMessage());
	    	JOptionPane.showMessageDialog(null,"Something went wrong when swriting to the file","ERROR",JOptionPane.ERROR_MESSAGE);

			 
		 }
		 
	 }
	 
	 
	 
	 
	 
	 public Veterinarian retrieveVeterinarian(int searchId)
	    {
	    	try
	    	{

	    		vet = new Veterinarian();
	    		
	    		RandomAccessFile veterinarianFile = new RandomAccessFile(fileName,"r");
	    		
	    		veterinarianFile.seek((searchId-1)*BLOCK);

	    		 vet.setID(veterinarianFile.readInt());
	    		 vet.setfName(veterinarianFile.readUTF());
	    		 vet.setlName(veterinarianFile.readUTF());
	    		 
	    		
	    		 
	    		 veterinarianFile.close();

	    		 
	    	}
	        catch(IOException ex)
	    	{
	        	System.out.println("Error retrieving data. ");
	        	JOptionPane.showMessageDialog(null,"Error retrieving data from the file.","Error",JOptionPane.ERROR_MESSAGE);
	    	}
	    	catch(NumberFormatException ex)
	    	{
	    		System.out.println("Error empty string: "+ ex.getMessage());
	    	}catch(ArrayIndexOutOfBoundsException ex)
	    	{

	    	}
	    	 return vet;
	    	
	    }//END OF RETRIEVE VETERINARIAN
	 
	 
	 public void deleteVEterianarian(Veterinarian vet)
	    {
	    	try 
	    	{
	    		int tempId = vet.getID();
	    		vet = new Veterinarian();
	    		
	    		
	    		RandomAccessFile veterinarianFile = new RandomAccessFile(fileName,"rw");
	    		
	    		//WRITE TO FILE
	    		veterinarianFile.seek((tempId-1) * BLOCK);
	    		veterinarianFile.writeInt(vet.getID());
	    		veterinarianFile.writeUTF(vet.getfName());
	    		veterinarianFile.writeUTF(vet.getlName());
	           
	            
	            
	    		veterinarianFile.close();//CLOSE FILE
	            
	            
	    	}
	    	catch(IOException ex)
	    	{
	    		System.out.println("Error writing to file"+ ex.getMessage());
	    		JOptionPane.showMessageDialog(null,"Something went wrong when swriting to the file","ERROR",JOptionPane.ERROR_MESSAGE);
	    	}
	    }
	 
	 
	 
	 
	 
	    
	 
	
	
	
	
	

}
