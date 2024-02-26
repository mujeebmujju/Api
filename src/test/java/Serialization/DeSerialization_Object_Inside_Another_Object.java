package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass_For_Object_Insise_Another_Object.Object_Inside_Another_Object1;

public class DeSerialization_Object_Inside_Another_Object 
{
	@Test
	public void empwithdes() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper omap = new ObjectMapper();
		Object_Inside_Another_Object1 data = omap.readValue(new File(".\\src\\test\\resources\\Object_inside_Another_object.json"), Object_Inside_Another_Object1.class);
	    System.out.println(data.getName());
	    System.out.println(data.getAge());
	    System.out.println(data.getPhone()[0]);
	    System.out.println(data.getSpouse().getPhone()[1]);
	    System.out.println(data.getSpouse().getAge());
	    System.out.println(data.getSpouse().getPhone()[1]);
	    System.out.println(data.getSpouse().getName());


	
	
	
	
	}

}
