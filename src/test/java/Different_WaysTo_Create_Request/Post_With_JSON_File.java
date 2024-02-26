package Different_WaysTo_Create_Request;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Post_With_JSON_File 
{
	@Test
	public void JSON()
	{
		baseURI="http://rmgtestingserver";
		port=8084;	
		File fi = new File(".\\src\\test\\resources\\JSONFile.json");

		given()
		.body(fi)
		.contentType(ContentType.JSON)

		.when()
		.post("/addProject")

		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();

	}

}
