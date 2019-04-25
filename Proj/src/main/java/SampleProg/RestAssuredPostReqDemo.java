package SampleProg;
import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestAssuredPostReqDemo {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject jObj=new JSONObject();
		jObj.put("name","ravi");
		jObj.put("job","QA");
		httpRequest.header("content-type","application/json");
		httpRequest.body(jObj.toString());
		System.out.println("Json obj="+jObj.toString());
		
		Response response = httpRequest.post("/api/users");
		
		String resBody=response.getBody().asString();
		System.out.println("Response body="+resBody);
		System.out.println(response.getStatusCode());


	}

}
