package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass_For_Object_Array.EmployeeWithArray;

public class Serialization_With_Object_Array 
{
	@Test
	public void empwithArray() throws JsonGenerationException, JsonMappingException, IOException
	{
		int[]phoneno= {99010,96200};
		EmployeeWithArray emp = new EmployeeWithArray("Mujeeb","ty",phoneno);
		ObjectMapper omap = new ObjectMapper();
		omap.writerWithDefaultPrettyPrinter().writeValue(new File(".\\src\\test\\resources\\SerializationObjectArray.json"), emp);
	}

}
