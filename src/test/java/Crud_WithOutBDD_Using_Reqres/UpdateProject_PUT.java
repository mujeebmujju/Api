package Crud_WithOutBDD_Using_Reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject_PUT 
{
	@Test
	public void Put()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("name","Mujeeb");
		jObj.put("job","ATE1");
		
		
		
		RequestSpecification reqst = RestAssured.given();
		reqst.body(jObj);
		reqst.contentType(ContentType.JSON);
		
		Response resp = reqst.put("https://reqres.in/api/users/2");
		System.out.println(resp.prettyPrint());
	}

}
