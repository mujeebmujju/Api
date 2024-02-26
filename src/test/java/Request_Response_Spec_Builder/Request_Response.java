package Request_Response_Spec_Builder;

import org.testng.annotations.Test;

import GenericUtils.Pojoclass;
import GenericUtils.RandomNum;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
public class Request_Response
{
	@Test
	public void builder()
	{
		RandomNum ran=new RandomNum();
		Pojoclass pc=new Pojoclass("Mujju","ZLX"+ran.getRandomNo(),"Ongoing",12);
		
		  RequestSpecification reqst = new RequestSpecBuilder()
		 .setBaseUri("http://rmgtestingserver:8084")
		 .setContentType(ContentType.JSON).build();
		  
		    ResponseSpecification resp = new ResponseSpecBuilder()
		   .expectContentType(ContentType.JSON)
		   .expectStatusCode(201).build();
		    
		    given().spec(reqst).body(pc)
		    
		    .when()
		    .post("/addProject")
		    
		    .then().spec(resp).log().all();
		    
		       
	
	}

}
