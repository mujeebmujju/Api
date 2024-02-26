package Response_Body_Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Static_ResponseBody_Validation 
{
	@Test
	public void staticResponse()
	{
		String expData="TY_PROJ_003";
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//action
		Response resp=when().get("/projects");
		
		//validation
		
		String actData = resp.jsonPath().get("[0].projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("Data Verified");
		
		resp.then().log().all();
		
		
	}

}
