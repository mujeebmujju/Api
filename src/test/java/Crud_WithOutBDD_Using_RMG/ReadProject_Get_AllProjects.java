package Crud_WithOutBDD_Using_RMG;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class ReadProject_Get_AllProjects 
{
	@Test
	public void Get()
	{
		Response reqst = RestAssured.get("http://rmgtestingserver:8084/projects");
		String completeBody = reqst.prettyPrint();
		System.out.println(completeBody);
		
		int actSC = reqst.getStatusCode();
		reqst.then().log().all();
		Assert.assertEquals(200, actSC);
		System.out.println(actSC);
		
		
	}

}
