package animal;

import clinicCustomers.Client;

public class Pet extends Animal
{
     private String name;
     private Animal animal;
     Client owner;
     


	//DEFAULT CONSTRUCTOR 
     public Pet() 
     {
    	 
    	 name ="";
    	 
    	 animal = new Animal();
    	 owner = new Client();
     }
     
     //PRIMARY CONSTRUCTOR
     public Pet(String name, Animal animal, Client owner) 
     {
    	 this.name=name;
    	 this.animal=animal;
    	 this.owner = owner;
     }
    
     //COPY CONSTRUCTOR
     public Pet(Pet pet) 
     {
    	 name=pet.name;
    	 animal=pet.animal;
    	 owner=pet.owner;
     }

     
     //GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
    public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}
     
}//END OF PET CLASS
