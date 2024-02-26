package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass_For_Serialization.Employee;

public class Deserialization1 
{
	@Test
	public void EmpDes() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper omap = new ObjectMapper();
		Employee data = omap.readValue(new File("C:\\Users\\Public\\RestAssured\\src\\test\\resources\\Serialization.json"), Employee.class);
		System.out.println(data.getEname());
		System.out.println(data.getPhoneno());
		System.out.println(data.getAge());
		
	}

}
