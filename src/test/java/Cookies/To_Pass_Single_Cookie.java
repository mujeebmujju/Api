package Cookies;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class To_Pass_Single_Cookie
{
	@Test
	public void singlecookie()
	{
		given()
		.cookie("1P_JAR","2023-12-26-09")
		
		.when()
		.get("https://www.google.com")
		
		.then().log().all();
	}
	
}