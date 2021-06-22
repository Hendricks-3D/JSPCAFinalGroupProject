package animal;

public class Animal 
{
	protected int id;
	protected int age;
	protected String type;
	protected String breed;
	protected String gender;
	
	
	//DEFAULT CONSTRUCTOR
	public Animal() 
	{
		id=0;
		age=0;
		type=" ";
		breed=" ";
		gender=" ";
	}
	//PRIMARY  CONSTRUCTOR
	public Animal(int id, int age, String type, String breed, String gender) 
	{
		this.id = id;
		this.age = age;
		this.type = type;
		this.breed = breed;
		this.gender = gender;
		
	}


	//COPY CONSTRUCTOR
	public Animal(Animal animal) 
	{
		id = animal.id;
		age = animal.age;
		type = animal.type;
		breed = animal.breed;
		gender = animal.gender;		
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
	
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	
	public String getType() 
	{
		return type;
	}
	public void setType(String type) 
	{
		this.type = type;
	}
	
	
	public String getBreed() 
	{
		return breed;
	}
	public void setBreed(String breed) 
	{
		this.breed = breed;
	}
	
	
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	
	

}//END OF ANIMAL CLASS
