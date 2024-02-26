package Response_Body_Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Dynamic_Response_Body_Validation 
{
	@Test
	public void Dynamic()
	{
		String expData="TY_PROJ_1401";
		baseURI="http://rmgtestingserver";
		port=8084;

		//action
		Response resp = when().get("/projects");

		//validation
		boolean flag = false;
		List<String> pIDs = resp.jsonPath().get("projectId");
		for(String projectID : pIDs)
		{
			if (projectID.equalsIgnoreCase(expData)) 
			{
				flag=true;	
			}
		}

		Assert.assertTrue(flag);
		System.out.println("Data Verified");
		resp.then().log().all();

	}

}
