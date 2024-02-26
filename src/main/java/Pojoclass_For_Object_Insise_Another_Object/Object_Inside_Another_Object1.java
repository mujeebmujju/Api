package Pojoclass_For_Object_Insise_Another_Object;


public class Object_Inside_Another_Object1
{
	
	String name;
	int age;
	int[]phone;
	Spouse spouse;
	
	
	public Object_Inside_Another_Object1(String name, int age, int[] phone,Spouse spouse) 
	{
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.spouse=spouse;
		
	}
	
	public Object_Inside_Another_Object1()
	{
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int[] getPhone() {
		return phone;
	}


	public void setPhone(int[] phone) {
		this.phone = phone;
	}


	public Spouse getSpouse() {
		return spouse;
	}


	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}
	
	

	
	

}
