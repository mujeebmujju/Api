package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass_For_Object_Insise_Another_Object.Object_Inside_Another_Object1;
import Pojoclass_For_Object_Insise_Another_Object.Spouse;

public class Serialization_Object_Inside_Another_Object 
{
	@Test
	public void empwithobj() throws JsonGenerationException, JsonMappingException, IOException
	{
		int[]sphone= {99010,96200};
		Spouse spouse = new Spouse("Mujju",29,sphone);
		
		int[] empphoneno= {1234,5678};
		
		Object_Inside_Another_Object1 emp = new Object_Inside_Another_Object1("Mujeeb",29,empphoneno,spouse);
		ObjectMapper omap = new ObjectMapper();
		omap.writerWithDefaultPrettyPrinter().writeValue(new File(".\\src\\test\\resources\\Object_inside_Another_object.json"), emp);
		
	}

}
