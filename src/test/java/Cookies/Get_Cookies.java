package Cookies;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Get_Cookies 
{
	@Test
	public void get()
	{
		  Response resp = given()
				  
		 .when().get("https://www.google.com");
		 
		 //to get single cookie information
		  
		  String value = resp.getCookie("1P_JAR");
		  System.out.println(value);
	}

}
