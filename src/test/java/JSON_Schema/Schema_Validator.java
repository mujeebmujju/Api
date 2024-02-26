package JSON_Schema;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class Schema_Validator
{
	@Test
	public void schema()
	{
		File fi = new File(".\\src\\test\\resources\\schemadata.json");
		
		when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(fi))
		.log().all();
	}

}

      //to convert json to jsonschema
     // https://jsonformatter.org/json-to-jsonschema