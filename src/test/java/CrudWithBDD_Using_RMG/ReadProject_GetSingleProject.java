package CrudWithBDD_Using_RMG;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class ReadProject_GetSingleProject
{
	@Test
	public void Post()
	{
		
	
		when()
		.get("http://rmgtestingserver:8084/projects/TY_PROJ_1211")
		
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
	}
}