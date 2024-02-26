package Cookies;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class To_Pass_Multiplele_Cookies
{
	@Test
	public void multiplecookie()
	{
		given()
		.cookies("1P_JAR","2023-12-26-09",
				"AEC","Ackid1RlcRlQ3OjCwmJcw6khIOdmhZE62rIf6atzAgXxa6ehJPGEXnW1eA",
				"NID","511%3DljsFiUtNfvY1rchyOag1pg_Q7zP1soIteudAlZYEstjTaSmcUxjKoMjHF-yt6pF4jIVJkTAeLl_I1JZVTyZByTLCzZaQMQ3zYdP9ku3berZA5_wa0tlhGiDH-8TjwbYpnDIfHW6NrdUGFvLiwuJwHlur-rbKrjJ9IRBY6bvH9bk")
		
		.when()
		.get("https://www.google.com")
		
		.then().log().all();
	}
	
}