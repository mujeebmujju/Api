package Crud_WithOutBDD_Using_Reqres;

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
	public void Create()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("name","Rehaman1");
		jObj.put("job","ATE");
		
		
		
		RequestSpecification reqst = RestAssured.given();
		reqst.body(jObj);
		reqst.contentType(ContentType.JSON);
		
		Response resp = reqst.post("https://reqres.in/api/users");
		
		String completeBody = resp.prettyPrint();
		System.out.println(completeBody);
		
		int actSC = resp.getStatusCode();
	    resp.then().log().all();
		Assert.assertEquals(201, actSC);
		System.out.println(actSC);
		
		
	}

}
