package Different_WaysTo_Create_Request;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericUtils.Pojoclass;
import io.restassured.http.ContentType;

public class Post_With_POJO 
{
	@Test
	public void Pojo()
	{
		Pojoclass cp = new Pojoclass("Mujjum121","vSCMFLEX01","Ongoing",15);
		
		 given()  
		.body(cp)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://rmgtestingserver:8084/addProject")
		
		.then()
		.log().all()
		.assertThat()
		.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)  // to validate response time
		
		.statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
		
	}

}