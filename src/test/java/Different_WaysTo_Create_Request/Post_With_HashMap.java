package Different_WaysTo_Create_Request;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Post_With_HashMap 
{
	@Test
	public void HashMap()
	{
		
	    HashMap map = new HashMap();
	    map.put("createdBy","Mujeeb Ur Rehaman11");
	    map.put("projectName", "R151");
	    map.put("status", "Ongoing");
	    map.put("teamSize", 12);
		 
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://rmgtestingserver:8084/addProject")
		
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
	}

}
