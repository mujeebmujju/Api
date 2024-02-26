package CrudWithBDD_Using_Reqres;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProject_Patch 
{
	@Test
	public void Patch()
	{
	JSONObject jObj = new JSONObject();
	jObj.put("name","ZAK11");
	jObj.put("job","Cricketer");

	
	given()
   .body(jObj)
   .contentType(ContentType.JSON)
	
	.when()
	.put("https://reqres.in/api/users/2")
	
	.then()
	.log().all()
	.assertThat().statusCode(200)
	.assertThat().contentType(ContentType.JSON);
	}

}
