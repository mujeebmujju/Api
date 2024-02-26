package Crud_WithOutBDD_Using_Reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject_Delete 
{
	@Test
	public void Delete()
	{
		Response reqst = RestAssured.delete("https://reqres.in/api/users/2");
		
		int actSC = reqst.getStatusCode();
		System.out.println(actSC);
	}

}
