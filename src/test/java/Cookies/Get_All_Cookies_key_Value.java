package Cookies;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.Map;

public class Get_All_Cookies_key_Value 
{
	@Test
	public void getall()
	{
		Response resp = given()
				.when().get("https://www.google.com");
		
		//to capture all cookie information
		Map<String, String> allcookie = resp.getCookies();
		
		//to capture only key value
		System.out.println(allcookie.keySet()) ;
	
	  for(String cookiekey:allcookie.keySet())
	  {
		 String cookievalue = resp.getCookie(cookiekey);
		 System.out.println(cookiekey+"   "+cookievalue);
	  }
	}
	

	 
}
