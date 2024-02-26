package Crud_WithOutBDD_Using_RMG;

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
		jObj.put("createdBy", "Rehaman");
		jObj.put("projectName", "SCM1");
		jObj.put("status", "Ongoing");
		jObj.put("teamSize", 12);	
		
		
		RequestSpecification reqst = RestAssured.given();
		reqst.body(jObj);
		reqst.contentType(ContentType.JSON);
		
		Response resp = reqst.put("http://rmgtestingserver:8084/projects/TY_PROJ_1160");
		System.out.println(resp.prettyPrint());
		
		int actSC = resp.getStatusCode();
		System.out.println(actSC);
		
		
		
	}

}
