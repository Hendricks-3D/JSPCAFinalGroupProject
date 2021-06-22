package report;

import clinicCustomers.Citizen;
import dateTime.Date;
import dateTime.Time;

public class Report 
{
    private String location;
    private int recordNumber;
    private Citizen citizen;
    private Time time;
    private Date date;
    
    
    
    //DEFAULT CONSTRUCTOR
    public Report()
    {
    	location="";
    	recordNumber=0;
    	citizen=new Citizen();
    	time = new Time();
    	date = new Date();
    }
    
    //PRIMARY CONSTRUCTOR
    public Report(String location, int recordNumber, Citizen citizen, Date date, Time time)
    {
    	this.location =location;
    	this.recordNumber=recordNumber;
    	this.citizen =citizen;
    	this.date=date;
    	this.time=time;
    	
    }
    
    //COPY CONSTRUCTOR
    public Report(Report report)
    {
    	location=report.location;
    	recordNumber=report.recordNumber;
    	citizen=report.citizen;
    	time = report.time;
    	date = report.date;
    }

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    
    void display()
    {
    	//DISPLAY REPORT HERE
    }
}//END OF REPORT CLASS
