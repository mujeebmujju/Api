package Data_Driven_Testing;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtils.Pojoclass;
import GenericUtils.RandomNum;
import io.restassured.http.ContentType;

public class DataDrivenTesting 
{
	@DataProvider(name="getData")
	public Object[][] data() 
	{
		Object[][] data = new Object[3][4]; 
		
		
		data[0][0]="Mujeeb";
		data[0][1]="HP";
		data[0][2]="Completed";
		data[0][3]=10;
				
		data[1][0]="Mujju";
		data[1][1]="Dell";
		data[1][2]="Ongoing";
		data[1][3]=15;
		
		data[2][0]="Rehaman";
		data[2][1]="Lenovo";
		data[2][2]="Created";
		data[2][3]=20;
		
		return data;
	}
	
	@Test(dataProvider="getData")
	public void createProject(String createdBy,String projectName,String status,int teamSize)
	{
		//pre conditions
		RandomNum ran = new RandomNum();
		Pojoclass pc = new Pojoclass(createdBy,projectName+ran.getRandomNo(),status,teamSize);
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.body(pc)
		.contentType(ContentType.JSON)
		
		//actions
		.when()
		.post("/addProject")
		
		
		.then()
		.log().all() 
		.assertThat()
		.statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
	}
}
		
		
		
		
		
		
		
		
		
		
	