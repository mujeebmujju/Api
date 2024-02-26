package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojoclass_For_Object_Array.EmployeeWithArray;

public class Deseriliaztion_With_Object_Array 
{
	@Test
	public void empwithArray() throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper omap = new ObjectMapper();
		 EmployeeWithArray data = omap.readValue(new File(".\\src\\test\\resources\\SerializationObjectArray.json"), EmployeeWithArray.class);
         System.out.println(data.getName());
         System.out.println(data.getId());
         System.out.println(data.getPhoneno()[0]);
         
         for (int num : data.getPhoneno()) 
         {
        	 System.out.println(num);
			  
		}
	}
}

