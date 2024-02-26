package Request_Chaining;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericUtils.Pojoclass;
import GenericUtils.RandomNum;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class RequestChaing_From_POJO_And_Create_And_Upadate_Project 
{
	
	@Test
	public void CreateAndUpadate_Project()
	{
		RandomNum ran = new RandomNum();
		Pojoclass cp = new Pojoclass("Rehaman786","Redmi"+ran.getRandomNo(),"Ongoing",15);
		baseURI="http://rmgtestingserver";
		port=8084;

		Response resp = given() 
				.body(cp)
				.contentType(ContentType.JSON)

				.when()
				.post("/addProject");

		String pID = resp.jsonPath().get("projectId");
		System.out.println(pID);


		resp.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();



		// Send Request for update Project

		Pojoclass cp1 = new Pojoclass("Mujeeb789","Samsung123"+ran.getRandomNo(),"Completed",20);
		baseURI="http://rmgtestingserver";
		port=8084;

		given()
		.body(cp1)
		.contentType(ContentType.JSON)
		.pathParam("proId", pID)

		.when()	
		.put("/projects/{proId}")

		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();

	



		// Delete Project
		 given()
		.pathParam("proId", pID)
		.when()
		.delete("/projects/{proId}")

		.then()
		.assertThat().statusCode(204)
		.assertThat().time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}

