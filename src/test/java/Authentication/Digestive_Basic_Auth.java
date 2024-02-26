package Authentication;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class Digestive_Basic_Auth
{
	@Test
	public void Digestive()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.auth().digest("rmgyantra","rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat().statusCode(202)
		.log().all();
	}
}