package API_FrameWork_TestScript;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities_API.BaseClass;
import GenericUtilities_API.EndPointsLibrary;
import GenericUtilities_API.Pojoclass;
import  io.restassured.response.Response;

public class createProjectandVerifyInDB extends BaseClass
{
	@Test
	public void createproject() throws SQLException, InterruptedException
	{
	
		//Step 1-- create pre requisites
		Pojoclass cp=new Pojoclass("Rehaman", "TYSS"+jlib.getRandomNo(), "Ongoing", 10);
		
		//Step 2-- Sned the Request
		Response resp=given()
		.spec(reqst).body(cp)
		
		.when().post(EndPointsLibrary.createProject);
		
		//Step 3--Capture the project id
		String expData = rlib.getJsonData(resp, "projectId");
		String projectName=rlib.getJsonData(resp, "projectName");//
		System.out.println(expData);
		
		//Step 4--validat the id in Database
		String query = "select * from project;";
		String actData = dlib.readDataFromDBAndValidate(query, 1, expData);
		Assert.assertEquals(expData, actData);
		System.out.println("TC pass");
		
		resp.then().log().all();
		
		//Step 5--validate the id in front end
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().window().maximize();
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("Projects")).click();
	    
	    String actData1 = driver.findElement(By.xpath("//tbody/tr/td[.='"+projectName+"']/preceding-sibling::td")).getText();
	    Assert.assertEquals(expData, actData1);
	    System.out.println("project is verified ");
	    
		
	}
		
		
		
		
		
}