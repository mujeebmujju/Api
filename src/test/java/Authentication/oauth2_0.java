package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class oauth2_0 
{
	@Test
	public void oauth()
	{
	     Response resp = given()
	    .formParam("client_id", "TechWizard")
	    .formParam("client_secret","60fa1eb1b589dd5c8a3c14e2b0cd999b")
	    .formParam("grant_type", "client_credentials")
	    .formParam("redirect_uri", "http://scmflex786.com")
	    .formParam("code","authorization_code")
	    
	    .when()
	    .post("http://coop.apps.symfonycasts.com/token");
	    
	   
	    //capture the acces token from the response of the above request
	    String token = resp.jsonPath().get("access_token");
	    System.out.println(token);
	    
	    //create another request and use the token token to access the APIs
	    
	    given()
	    .auth().oauth2(token)
	    .pathParam("USER_ID",4793)
	    
	    .when()
	    .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-co")
	    
	    .then()
	    .log().all();
	    
	    
	     
	    
	    
	}

}
