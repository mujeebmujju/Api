package Pojoclass_For_Serialization;

public class Employee
{
	
	// Step 1--create variable globalyy
	
	private String ename;
	private long phoneno;
	private int age;
	
	//Step 2--create constructor to initialize the variables
	
	public Employee(String ename,long phoneno,int age)
	{
		super();
		this.ename=ename;
		this.phoneno=phoneno;
		this.age=age;
	}
	
	//Step 3--Create empty constructor to trigger the execution of serialization and deserialization
	public Employee() 
	{
	 	
	}
	

	//Step 4-- provide getters and setters
	public String getEname() 
	{
		return ename;
	}

	public void setEname(String ename) 
	{
		this.ename = ename;
	}

	public long getPhoneno() 
	{
		return phoneno;
	}

	public void setPhoneno(long phoneno) 
	{
		this.phoneno = phoneno;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}
	
	
	
}