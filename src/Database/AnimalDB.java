package Database;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import javax.swing.JOptionPane;

import animal.Animal;

public class AnimalDB 
{

	public static String fileName;
	
	
	public static final int BLOCK_SIZE = 4+4+(20*2)+(20*2)+(20*2);
	
	
	public AnimalDB()
	{
	   fileName = "Animal Database.dat";
	}
	
	public AnimalDB(String fileName)
	{
		this.fileName = fileName;
	}
	
    public void storeAnimal(Animal animal)
    {
    	try 
    	{
    		   RandomAccessFile animalFile = new RandomAccessFile(fileName,"rw");
    		   animalFile.seek((animal.getId()-1) * BLOCK_SIZE);//POSITION FILEE POINTER
    		   
    		   //WRITE TO FILE
    	       animalFile.writeInt(animal.getId());
               animalFile.writeInt(animal.getAge());
               animalFile.writeUTF(animal.getBreed());
               animalFile.writeUTF(animal.getGender());
               animalFile.writeUTF(animal.getType());
               animalFile.close();//CLOSE FILE
            
            
    	}
    	catch(IOException ex)
    	{
    		System.out.println("Error writing to file"+ ex.getMessage());
    		JOptionPane.showMessageDialog(null,"Something went wrong when swriting to the file","ERROR",JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    
    public void initializeAnimal()
    {
    	try 
    	{
    		   Animal animal = new Animal();
    		   
    		   RandomAccessFile animalFile = new RandomAccessFile(fileName,"rw");
    		   
    		   
    		   for(int temp =1; temp<999; temp++)
    		   {
    			   animalFile.seek((temp-1) * BLOCK_SIZE);//POSITION FILEE POINTER
    			   //WRITE TO FILE
        	       animalFile.writeInt(animal.getId());
                   animalFile.writeInt(animal.getAge());
                   animalFile.writeUTF(animal.getBreed());
                   animalFile.writeUTF(animal.getGender());
                   animalFile.writeUTF(animal.getType());
                   
    		   }
    		  
    		   animalFile.close();//CLOSE FILE       
    	}
    	catch(IOException ex)
    	{
    		System.out.println("Error writing to file"+ ex.getMessage());
    		JOptionPane.showMessageDialog(null,"Eror initializing","ERROR",JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    
    public Animal retrieveAnimal(int searchId)
    {
    	Animal animal = new Animal();
    	
    	try
    	{

    		
    		RandomAccessFile animalFile = new RandomAccessFile(fileName,"r");
    		
    		 animalFile.seek((searchId-1)*BLOCK_SIZE);

    		 animal.setId(animalFile.readInt());
    		 animal.setAge(animalFile.readInt());
    		 animal.setBreed(animalFile.readUTF());
    		 animal.setGender(animalFile.readUTF());
    		 animal.setType(animalFile.readUTF());
    		 
    		 animalFile.close();

    		 
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
    	 return animal;
    	
    }//END OF RETRIEVE ANIMAL
    
    
    public void retrieveAllAnimal()
    {
  
    }
    
    public void deleteAnimal(Animal animal)
    {
    	try 
    	{
    		int tempId = animal.getId();
    		animal = new Animal();
    		
    		RandomAccessFile animalFile = new RandomAccessFile(fileName,"rw");
    		
    		//WRITE TO FILE
    		animalFile.seek((tempId-1) * BLOCK_SIZE);
            animalFile.writeInt(animal.getId());
            animalFile.writeInt(animal.getAge());
            animalFile.writeUTF(animal.getBreed());
            animalFile.writeUTF(animal.getGender());
            animalFile.writeUTF(animal.getType());
            
            
            animalFile.close();//CLOSE FILE
            
            
    	}
    	catch(IOException ex)
    	{
    		System.out.println("Error writing to file"+ ex.getMessage());
    		JOptionPane.showMessageDialog(null,"Something went wrong when swriting to the file","ERROR",JOptionPane.ERROR_MESSAGE);
    	}
    }
    
}//END OF ANIMAL CLASS
