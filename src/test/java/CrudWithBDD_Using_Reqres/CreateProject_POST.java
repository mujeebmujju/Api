package CrudWithBDD_Using_Reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtils.RandomNum;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CreateProject_POST 
{
	@Test
	public void Post()
	{
	   
		JSONObject jObj = new JSONObject();
		
		//jObj.put("name","ZAK"+new RandomNum().getRandomNo()); ----> To Append Random Number
		
		jObj.put("name","ZAK");
		jObj.put("job","Cricketer");
  
		
		given()
	   .body(jObj)
	   .contentType(ContentType.JSON)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
		
	
		
	}

}
