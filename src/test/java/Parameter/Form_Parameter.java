package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Form_Parameter 
{
	@Test
	public void Form()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		
		given()
		.formParam("createdBy","Mujeeb")
		.formParam("projectName", "SCMflex")
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}

}
