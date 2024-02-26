package CrudWithBDD_Using_RMG;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject_POST 
{
	@Test
	public void Post()
	{
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Mujeeb Ur Rehaman");
		jObj.put("projectName", "R15");
		jObj.put("status", "Ongoing");
		jObj.put("teamSize", 10);
		
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://rmgtestingserver:8084/addProject")
		
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
		
		
		
			 
			  
			
	}

}
