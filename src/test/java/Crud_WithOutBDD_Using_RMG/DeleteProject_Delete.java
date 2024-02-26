package Crud_WithOutBDD_Using_RMG;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject_Delete 
{
	@Test
	public void Delete()
	{
		Response reqst = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_1160");
		System.out.println(reqst.prettyPrint());
		
		int actSC = reqst.getStatusCode();
		System.out.println(actSC);
	}

}
