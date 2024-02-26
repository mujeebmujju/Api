package Crud_WithOutBDD_Using_Reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadProject_Get_ListUsers 
{
	@Test
	public void Get()
	{
		Response reqst = RestAssured.get("https://reqres.in/api/users?page=2");
		String completeBody = reqst.prettyPrint();
		System.out.println(completeBody);
		
	}

}
