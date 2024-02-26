package API_FrameWork_TestScript;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenericUtilities_API.BaseClass;
import GenericUtilities_API.EndPointsLibrary;
import GenericUtilities_API.JavaLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_Project_In_Front_End extends BaseClass
{
	@Test
	public void create() throws InterruptedException, SQLException
	{
		JavaLibrary jlib=new JavaLibrary();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().window().maximize();
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[text()='Projects']")).click();
	    driver.findElement(By.xpath("//span[.='Create Project']")).click();
	    
	    String projectName="SCM123123"+jlib.getRandomNo();
	    driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName);
	    driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Mujeeb");
	    WebElement element = driver.findElement(By.xpath("//label[.='Project Status ']/parent::div/child::select[@name='status']"));
	    Select sel=new Select(element);
	    sel.selectByVisibleText("Created");
	    driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	    String projectid = driver.findElement(By.xpath("//td[.='TY_PROJ_-117']")).getText();
	    System.out.println(projectid);
	    driver.close();
	    
	    //api validation
	    Response res = given().spec(reqst)
	    
	    .when()
	    .get(EndPointsLibrary.getSingleProject+"/"+projectid);
	    
	    res.then()
	    .assertThat().statusCode(200)
	    .assertThat().contentType(ContentType.JSON)
	    .log().all();
	    
	    
	    
//	    //Api Testing
//	    Response resp=given()
//	    		.spec(reqst)
//	    		
//	    		.when().post(EndPointsLibrary.getAllprojects);
//	    
//	    List<String> Projectid = resp.jsonPath().get("projectId");
//	    boolean flag=false;
//	    String expData="";
//	    for(String exp:Projectid)
//	    {
//	    	if(exp.equalsIgnoreCase(actdata))
//	    	{
//	    		flag=true;
//	    		expData=exp;
//	    		break;
//	    	}
//	    }
//	    Assert.assertTrue(flag);
//	    System.out.println("Data is verified and present");
//	    System.out.println(expData);
	    
	    
//	  //Step 4--validat the id in Database
//	  		String query = "select * from project;";
//	  		String actData = dlib.readDataFromDBAndValidate(query, 1, expData);
//	  		Assert.assertEquals(expData, actData);
//	  		System.out.println("TC pass");
//	  		
//	  		resp.then().log().all();
	    		
	}
	
	
	

}
