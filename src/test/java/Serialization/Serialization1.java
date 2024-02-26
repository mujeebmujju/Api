package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass_For_Serialization.Employee;

public class Serialization1 
{
	@Test
	public void EmpSer() throws Throwable, JsonMappingException, IOException
	{
		ObjectMapper omap = new ObjectMapper();
		Employee emp = new Employee("Mujeeb",9901040,29);
		
		omap.writerWithDefaultPrettyPrinter()
		.writeValue(new File("C:\\Users\\Public\\RestAssured\\src\\test\\resources\\Serialization.json"), emp);
	}

}

// FOR SERIALIZATION AND DESRIALIZATION WE HAVE TO CREATE POJO CLASS