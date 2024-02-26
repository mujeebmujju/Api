package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Basic_Auth 
{
	@Test
	public void BAsic()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat()
		.statusCode(202)
		.log().all();
	}

}
