package Intervention;

public class RemovalRequest extends Intervention{
	
	private String Address;
	private String outcome;
	
	public RemovalRequest()
	{
		this.client.setfName("");
		this.client.setfName("");
		this.client.setPhone("");
		this.Address ="";
		this.outcome="";
		this.getDate().setDay(0);
		this.getDate().setMonth(0);
		this.getDate().setYear(0);
		this.getTime().setHours(0);
		this.getTime().setMinutes(0);
	}
	public String getOutcome() {
		return outcome;
	}


	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
	public String getAddress() 
	{
		return Address;
	}


	public void setAddress(String address) 
	{
		Address = address;
	}
	
	

}
