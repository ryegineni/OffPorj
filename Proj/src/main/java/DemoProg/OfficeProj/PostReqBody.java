package DemoProg.OfficeProj;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class PostReqBody {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, JSONException {
		System.out.print("Added print statement");

		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		
		ObjectMapper mapper=new ObjectMapper();
		EmpDetails details=new EmpDetails("Ravi","QA");
		mapper.writeValue(new File("D:\\user.json"), details);
		
		//Convert object to JSON string	
		String jsonInString = mapper.writeValueAsString(details);
		System.out.println("Json string========"+jsonInString);
		
		//Convert object to JSON string and pretty print
		jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(details);
		System.out.println(jsonInString);
		
		//POST req
		CloseableHttpResponse closeable=post(jsonInString,headerMap);
		
		//Status code
		int statusCode=closeable.getStatusLine().getStatusCode();
		System.out.println("Status code"+statusCode);
		
		//Response json
		String resString=EntityUtils.toString(closeable.getEntity());
		System.out.println("Response string="+resString);
		
		JSONObject obj=new JSONObject(resString);
		System.out.println("Response JSON="+obj);
		System.out.println("ID########"+obj.getString("id"));

	}
	public static CloseableHttpResponse post(String entity,HashMap<String,String> headerMap) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpPost httpPost=new HttpPost("https://reqres.in/api/users");
		httpPost.setEntity(new StringEntity(entity));
		for(Map.Entry<String,String> entry:headerMap.entrySet()){
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closeableRes=httpClient.execute(httpPost);
		return closeableRes;
	}

}
