package Intervention;

import animal.Animal;
import clinicCustomers.Client;
import dateTime.*;

public class Intervention 
{
	/*
	 * A COMBINATION OF THE DATE AND ID makes up THE INVERVENTION NUMBER
	 */
	
   protected int id;
   protected String interventionNo;
   protected Date date;
   protected Time time;
   protected Client client;
   protected Animal animal;

   
	public Intervention()
	{
		id = 0;
		interventionNo ="";
		date = new Date();
		time = new Time();
		client = new Client();
		animal = new Animal();
	}
	
	
	public Intervention(int id,String interventionNo, Date date, Time time, Client client, Animal animal) 
	{
		this.id =id;
		/*
		 * CONCATENATE THE REMOVATE DATE + INTERVENTION ID TO GET INTENTION NUMBER
		 */
		this.interventionNo = interventionNo;
		this.date = date;
		this.time = time;
		this.client = client;
		this.animal = animal;
	}
	
	
	
	//GETTERS AND SETTERS
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getInterventionNo() 
	{
		return interventionNo;
	}
	public void setInterventionNo(String interventionNo) 
	{
		this.interventionNo = interventionNo;
	}
	public Date getDate() 
	{
		return date;
	}
	public void setDate(Date date) 
	{
		this.date = date;
	}
	public Time getTime() 
	{
		return time;
	}
	public void setTime(Time time) 
	{
		this.time = time;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) 
	{
		this.client = client;
	}
	public Animal getAnimal() 
	{
		return animal;
	}
	public void setAnimal(Animal animal)
	{
		this.animal = animal;
	}
   
   
	
}//END OF INTERVENTION CLASS
