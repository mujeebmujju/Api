package Pojoclass_For_Object_Array;

public class EmployeeWithArray 
{
	String name;
	String id;
	int[] phoneno;
	

	public EmployeeWithArray(String name, String id, int[] phoneno) 
	{
		super();
		this.name = name;
		this.id = id;
		this.phoneno = phoneno;
	}

	public EmployeeWithArray()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int[] getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int[] phoneno) {
		this.phoneno = phoneno;
	}
	
	
}
