package DemoProg.OfficeProj;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RestAssuredDemo {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Ravi");
		requestParams.put("job", "testing-robo");
		request.body(requestParams).toString();
		Response response = request.post("/api/users");
		int statusCode = response.getStatusCode();
		//Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		//Assert.assertEquals("Correct Success code was returned", successCode, "OPERATION_SUCCESS");

	}

}
