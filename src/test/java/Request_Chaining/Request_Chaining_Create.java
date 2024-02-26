package Request_Chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtils.RandomNum;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Request_Chaining_Create 
{
	@Test
	public void Request()
	{
         baseURI="http://rmgtestingserver";
         port=8084;
         
         RandomNum ran = new RandomNum();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Rehaman");
		jObj.put("projectName", "MRF11"+ran.getRandomNo());
		jObj.put("status", "Ongoing");
		jObj.put("teamSize", 20);

		//Step1 precondition
        Response resp = given()
        		.body(jObj)
        		.contentType(ContentType.JSON)

		//Step 2 actions
		.when()
		.post("/addProject");

		String pid = resp.jsonPath().get("projectId");
		System.out.println(pid);
		resp.then().log().all();
		
		
		//Step 3 Get another get request
		 given()
		.pathParam("proId", pid)
		.when().get("/projects/{proId}")
		.then().log().all();
		
	
		
		
		
	}

}
