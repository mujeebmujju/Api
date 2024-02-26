package Crud_WithOutBDD_Using_RMG;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CreateProject_POST 
{
	@Test
	public void Post()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Mujeeb 1mRehaman123");
		jObj.put("projectName", "MRMZ11");
		jObj.put("status", "Ongoing");
		jObj.put("teamSize", 115);
		
		
		RequestSpecification reqst = RestAssured.given();
		reqst.body(jObj);
		reqst.contentType(ContentType.JSON);
		
		Response resp = reqst.post("http://rmgtestingserver:8084/addProject");
		String completeBody = resp.prettyPrint();
		System.out.println(completeBody);
	    
		int actSC = resp.getStatusCode();
	    resp.then().log().all();
		Assert.assertEquals(201, actSC);
		System.out.println(actSC);
		
		
	}

}
