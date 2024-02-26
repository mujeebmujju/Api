package GenericUtilities_API;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass 
{
	public DatabaseLibrary dlib=new DatabaseLibrary();
	public JavaLibrary jlib=new JavaLibrary();
	public RestAssuredLibrary rlib=new RestAssuredLibrary();
	public RequestSpecification reqst;
	public ResponseSpecification resp;
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		dlib.connectTODB();
		reqst=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
		.setContentType(ContentType.JSON).build();
		new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}
	
	@AfterSuite
	public void asConfig() throws SQLException
	{
		dlib.closeDB();
	}

}
