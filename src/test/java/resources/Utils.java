package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static RequestSpecification requestSpecBuilder;
	public static ResponseSpecification responseSpecBuilder;
	public static ResponseSpecification responseSpec;
	static APIResources resourceAPI;
	public static Response response;
	
	
	public static RequestSpecification requestSpecification() throws IOException
	{
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName(getGlobalValue("username"));
        auth.setPassword(getGlobalValue("password"));
       
        if(requestSpecBuilder==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		 requestSpecBuilder=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI"))
				 .setAuth(auth)
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		         .setContentType(ContentType.JSON).build();
		
		}
		return requestSpecBuilder;
		
		
	}
	
	public static String resource(String resource)
	{
		
		resourceAPI = APIResources.valueOf(resource);
		String apiEndpoint = resourceAPI.getResource();
		return apiEndpoint;
		
	}
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream("./src/test/java/resources/config.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	
	public static String getJsonPath(Response response,String key)
	{
		System.out.println("In JsonPath");
		String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
    }
	public ResponseSpecification responseSpecification() throws NumberFormatException, IOException
	{
	responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(Integer.parseInt(getGlobalValue("StatusCode"))).expectContentType(ContentType.JSON).build();
    
	return responseSpecBuilder;
	}
	

	

}
