package CrudWithBDD_Using_RMG;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProject_PUT 
{
  @Test
  public void Put()
  {
	  JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Mujeeb");
		jObj.put("projectName", "R15 Yamaha");
		jObj.put("status", "completed");
		jObj.put("teamSize", 12);
		
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("http://rmgtestingserver:8084/projects/TY_PROJ_1198")
		
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
  }

}
