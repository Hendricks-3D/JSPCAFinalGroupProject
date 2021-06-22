package dateTime;

public class Time 
{
    private int hours;
    private int minutes;
    
    
    //DEFAULT CONSTRUCTOR
    public Time()
    {
       minutes =0;
       hours =0;
       
    }
    
    //PRIMARY CONSTRUCTOR
    public Time(int hours, int minutes)
    {
        this.hours=hours;
        this.minutes=minutes;
    }
    
  //COPY CONSTRUCTOR
    public Time( Time time)
    {
    	minutes=time.minutes;
    	hours=time.hours;
    }

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
    
    
    
    
}//END OF TIME
