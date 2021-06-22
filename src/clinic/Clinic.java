package clinic;

public class Clinic 
{
   private String name;
   private String[] openingHrs;
   private String location;
   
   
   
   //DEFAULT CONSTRUCTOR
   public Clinic()
   {
	   //openingHrs="";
	   location="";
	   name="";
   }
   //PRIMARY CONSTRUCTOR
   public Clinic(String name,String[] openingHrs, String location)
   {
	   this.openingHrs = openingHrs;
	   this.location=location;
	   this.name=name;
   }
   
   //COPY CONSTRUCTOR
   public Clinic(Clinic clinic)
   {
	   openingHrs=clinic.openingHrs;
	   location=clinic.location;
	   name=clinic.name;
   }
   
   //GETTERS AND SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getOpeningHrs() {
		return openingHrs;
	}
	public void setOpeningHrs(String[] openingHrs) {
		this.openingHrs = openingHrs;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
   
   
   
}//END OF CLINIC CLASS
