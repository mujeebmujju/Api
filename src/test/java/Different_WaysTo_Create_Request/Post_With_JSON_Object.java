package Different_WaysTo_Create_Request;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Post_With_JSON_Object 
{
		@Test
		public void Post()
		{
		   
			JSONObject jObj = new JSONObject();
			jObj.put("createdBy","Mujeeb");
			jObj.put("projectName", "MR151");
			jObj.put("status", "Ongoing");
			jObj.put("teamSize", 15);
			
			
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



