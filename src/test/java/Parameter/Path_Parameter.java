package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Path_Parameter 
{
	@Test
	public void Path()
	{
	  baseURI="http://rmgtestingserver";
	  port=8084;
	  
	  
	  given()
	  .pathParam("pid", "TY_PROJ_1407")
	  
	  //actions 
	  
	  .when()
	  .get("projects/{pid}")
	  
	  //validation
	  .then()
	  .assertThat()
	  .statusCode(200)
	  .log().all();
	  
	}

}
