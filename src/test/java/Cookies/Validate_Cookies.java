package Cookies;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Validate_Cookies 
{
	@Test
	public void validate()
	{
		given()
		.when()
	    .get("https://www.google.com")
	    
	    .then()
	    .cookie("1P_JAR")
	    .cookie("AEC")
	    .cookie("NID")
	    
	    .log().all();
	}
	

}
