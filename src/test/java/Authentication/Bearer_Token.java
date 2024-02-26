package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Bearer_Token 
{
	@Test
	public void bearer()
	{
		baseURI="https://api.github.com";
				
		JSONObject jObj = new JSONObject();
		jObj.put("name", "sdet5-restassured");
		
		given()
		.auth()
		.oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos")
		
		.then().log().all();
		
		
	}

}
