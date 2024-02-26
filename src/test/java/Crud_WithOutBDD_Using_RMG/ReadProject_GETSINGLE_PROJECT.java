package Crud_WithOutBDD_Using_RMG;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadProject_GETSINGLE_PROJECT 
{
	@Test
	public void Get()
	{
		Response reqst = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_1172");
		
		String completeBody = reqst.prettyPrint();
		System.out.println(completeBody);
		
		int actSC = reqst.getStatusCode();
		System.out.println(actSC);
		
		String actCT = reqst.getContentType();
		System.out.println(actCT);
		
	}

}
