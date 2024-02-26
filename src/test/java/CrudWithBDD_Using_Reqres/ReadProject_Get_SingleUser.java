package CrudWithBDD_Using_Reqres;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReadProject_Get_SingleUser
{
	@Test
	public void Get()
	{
		when()
		.get("https://reqres.in/api/users/2")
		
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}

}
