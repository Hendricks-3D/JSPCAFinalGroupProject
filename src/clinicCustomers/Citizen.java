package clinicCustomers;

public class Citizen 
{

   protected int id;
   protected String fName;
   protected String lName;
   protected String email;
   protected String phone;
   
   
   //DEFAULT CONSTRUCTOR
    public Citizen()
    {
    	id =0;
    	fName="";
    	lName="";
    	email="";
    	phone="";
    }

	  //PRIMARY CONSTRUCTOR
	public Citizen(int id, String fName, String lName, String email, String phone)
	{
		this.id =id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phone = phone;
	}
	

	
	public Citizen(Citizen citizen)
	{
		this.id=citizen.id;
		this.fName = citizen.fName;
		this.lName = citizen.lName;
		this.email = citizen.email;
		this.phone = citizen.phone;		
	}

	
	//GETTERS AND SETTERS
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
       

	public String changeToString()
	{
		return id+"\t"+fName+"\t"+lName+"\t"+email+"\t"+phone;
	}
	
}//END OF MEMBER CLASS
