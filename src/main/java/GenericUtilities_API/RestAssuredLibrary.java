package GenericUtilities_API;

import io.restassured.response.Response;

public class RestAssuredLibrary
{
	/**
	 * This method will return json data from the corresponding response body
	 * @author mujeeb
	 * @param response
	 * @param path
	 * @return
	 */
	
	public String getJsonData(Response response,String path)
	{
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}

}
