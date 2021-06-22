package clinic;




public class Veterinarian {
	
	private String filename;
	
	
	
	static int ID;
	String fName;
	String lName;
	
	public Veterinarian()
	{
		ID=0;
		fName="";
		lName="";
		
	}
	
	Veterinarian(Veterinarian VETERINARIAN)
	{
		this.ID=VETERINARIAN.ID;
		this.fName=VETERINARIAN.fName;
		this.lName=VETERINARIAN.lName;
		
	}
	
	
	
	
	public Veterinarian(int iD, String fName, String lName) {
		super();
		ID = iD;
		this.fName = fName;
		this.lName = lName;
	}
	public static int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	
	
	

}
