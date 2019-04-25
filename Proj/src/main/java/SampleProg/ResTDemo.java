package SampleProg;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResTDemo {
	public static void main(String args[]){
	Response res = RestAssured.given().contentType("multipart/form-data").multiPart("response_type", "json").with()
			.auth().basic("appointplus899/2391", "1aace0702bae78a43667c38ae48ccb3f2c9c13c4")
			.post("");

	res.prettyPrint();

}
}