package clinicCustomers;

import clinic.Clinic;

public class Client extends Citizen 
{



	private String address;
	private String animalDetail;
	private String pay;
	private Clinic clinic;
	
	
	//DEFAULT CONSTRUCTOR
	public Client()
	{
		id = 0;
		fName ="";
		lName="";
		email="";
		phone="";
		address="";
		animalDetail="";
		pay = "";
		
	}
	
	//PRIMARY CONATRUCTOR
	public Client(int id, String fName, String lName, String email, String phone, String address, String animalDetail, String pay) 
	{
		this.id=id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.animalDetail = animalDetail;
		this.pay = pay;
	}
	
	//COPY CONSTRUCTOR
	public Client(Client client)
	{
		id = client.id;
		fName = client.fName;
		lName = client.lName;
		email = client.email;
		phone = client.phone;
		address = client.address;
		animalDetail = client.animalDetail;
		pay = client.pay;
	}

	
	//GETTERS AND SETTERS
	
	
	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	
	
	public String getAnimalDetail() 
	{
		return animalDetail;
	}

	public void setAnimalDetail(String animalDetail) 
	{
		this.animalDetail = animalDetail;
	}

	
	
	public String getPay() 
	{
		return pay;
	}

	public void setPay(String pay) 
	{
		this.pay = pay;
	}
	
	@Override
	public String changeToString()
	{
		return id+"\t"+fName+"\t"+lName+"\t"+email+"\t"+phone+"\t"+address+"\t"+animalDetail+"\t"+pay;
	}
	
}//END OF CLIENT CLASS
