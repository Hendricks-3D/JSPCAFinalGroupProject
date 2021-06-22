package dateTime;


public class Date 
{
   private int month;
   private int year;
   private int day;
   
   
   //DEFAULT CONSTRUCTOR
   
   public Date()
   {
	   month=0;
	   day=0;
	   year=0;
	   
   }
   
   //PRIMARY CONSTRUCTOR
   public Date(int month,int year,int day)
   {
	   this.month=month;
	   this.year=year;
	   this.day=day;
   }
   
   //COPY CONSTRUCTOR
   public Date(Date date)
   {
	   month=date.month;
	   day=date.day;
	   year=date.year; 
   }

   //GETTERS AND SETTERS
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
   
   
   
}//END OF DATE CLASS
