package Response_Body_Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Dynamic_Response_Body_Validation_Using_Reqres 
{
	@Test
	public void Dynamic()
	{
		int expID=9;
		baseURI="https://reqres.in/";
		
		
		//action
		Response resp = when().get("/api/users?page=2");
		
		//validation
		boolean flag = false;
		List<Integer> pIDs = resp.jsonPath().get("data.id");
		for(Integer projectID : pIDs)
		{
			if (projectID.equals(expID)) 
			{
			   flag=true;	
			}
		}
		
		Assert.assertTrue(flag);
		System.out.println("Data Verified");
		resp.then().log().all();
		
	}

}
