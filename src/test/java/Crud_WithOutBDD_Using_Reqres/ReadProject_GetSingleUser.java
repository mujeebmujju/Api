package Crud_WithOutBDD_Using_Reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadProject_GetSingleUser 
{
	@Test
	public void Get()
	{
		Response reqst = RestAssured.get("https://reqres.in/api/users/2");
		String completeBody = reqst.prettyPrint();
		System.out.println(completeBody);
		
		int actSC = reqst.getStatusCode();
		System.out.println(actSC);
		
		String actCT = reqst.getContentType();
		System.out.println(actCT);
	}

}
