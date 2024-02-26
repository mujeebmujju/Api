package CrudWithBDD_Using_Reqres;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteProject_Delete 
{
	@Test
	public void Delete()
	{
	
		when()
		.delete("https://reqres.in/api/users/2")
		
		.then()
		.log().all()
		.assertThat().statusCode(204);
		//.assertThat().contentType(ContentType.JSON);
	}


}
