package CrudWithBDD_Using_RMG;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class DeleteProject_Delete 
{
	@Test
	public void Delete()
	{
	
		when()
		.delete("http://rmgtestingserver:8084/projects/TY_PROJ_1211")
		
		.then()
		.log().all()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON);
	}

}
