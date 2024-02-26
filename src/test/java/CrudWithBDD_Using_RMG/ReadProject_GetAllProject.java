package CrudWithBDD_Using_RMG;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReadProject_GetAllProject 
{
	@Test
	public void Post()
	{
		
	    
		when()
		.get("http://rmgtestingserver:8084/projects")
		
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
	}


}
