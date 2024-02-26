package Pojoclass_For_Object_Insise_Another_Object;

public class Spouse 
{
	
	String name;
	int age;
	int[]phone;
	
	
	public Spouse(String name, int age, int[] phone) 
	{
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	
	public Spouse()
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
	
	
	
	

}
