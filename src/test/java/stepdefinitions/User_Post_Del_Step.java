package stepdefinitions;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.TestDataBuild;
import resources.Utils;
import excelUtillity.ExcelUtil;

public class User_Post_Del_Step extends Utils {

	public static String userPostReqBody;
	Map<String, String> xl;
	int StatusCode;
	String Msg;
	public static String UserID;

	@Given("User creates {string} method Endpoint with data from {string} and {int}")
	public void user_creates_method_endpoint_with_data_from_and(String method, String SheetName, Integer RowNumber)
			throws IOException {

		xl = ExcelUtil.getxlData(SheetName).get(RowNumber);

		if (method.equalsIgnoreCase("Post")) {
			userPostReqBody = TestDataBuild.userpostPayLoad(xl);
			requestSpecBuilder = given().spec(requestSpecification());

		} else if (method.equalsIgnoreCase("Delete")) {
			requestSpecBuilder = given().spec(requestSpecification());

		}

	}

	@When("User calls {string} endpoint with {string} https Request")
	public void user_calls_endpoint_with_https_request(String resource, String method) {

		if (method.equalsIgnoreCase("Post")) {
			response = requestSpecBuilder.body(userPostReqBody).when().post(resource(resource));
		} else if (method.equalsIgnoreCase("Delete")) {
			UserID = xl.get("User_ID");
			response = requestSpecBuilder.when().delete((resource(resource)) + UserID);
		}

	}

	@Then("User should receive status code and response body in {string} method")
	public void user_should_receive_status_code_and_response_body_in_method(String method) throws IOException {


		StatusCode = response.getStatusCode();
		if (StatusCode == 200) {

			if(method.equalsIgnoreCase("Post")) {
				response.then().assertThat().body(matchesJsonSchemaInClasspath(getGlobalValue("UserPostResSchema")));
				UserID = getJsonPath(response, "user_id");
				Msg = getJsonPath(response, "message_response");
				assertEquals(Msg, xl.get("Message"));
			}
			else if (method.equalsIgnoreCase("Delete")) {
				Msg = getJsonPath(response, "message_response");
				assertEquals(Msg, xl.get("Message"));

			}

		} else
			System.out.println(StatusCode);
		// Msg = getJsonPath(response,"message");
		// assertEquals(Msg,xl.get("ErrorMessage"));

	}

}
