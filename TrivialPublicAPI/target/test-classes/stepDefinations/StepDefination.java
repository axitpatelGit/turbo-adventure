package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.time.Instant;
import java.util.TimeZone;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class StepDefination {

	Response response;
	long currentUnixTime;
	
	@Given("trivial public API http GET request")
	public void trivial_API_GET_endPoint() {
		
		RestAssured.baseURI="https://showcase.api.linx.twenty57.net/UnixTime/fromunixtimestamp";
	}

	@When("unix time is current time")
	public void call_Get_request_for_current_time() {
			TimeZone.setDefault( TimeZone.getTimeZone("GMT"));
			currentUnixTime = Instant.now().getEpochSecond();
			response = given().queryParam("unixtimestamp", String.valueOf(currentUnixTime)).log().all()
						.when().get()
						.then().log().all().extract().response();
	}
	
	@When("unix time is {string}")
	public void call_Get_request_for_given_time(String unixDateTime) {
		response = given().queryParam("unixtimestamp", unixDateTime).log().all()
					.when().get()
					.then().log().all().extract().response();
	}
	
	@When("unix time is blank")
	public void call_Get_request_for_given_time() {
		response = given().queryParam("").log().all()
					.when().get()
					.then().log().all().extract().response();
	}
	

	@Then("API call is success with status code {int}")
	public void validate_status_code(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}
	
	@Then("Datetime field present in response should be current Time")
	public void validate_dateTime_value() {
			String responeDateTime = response.jsonPath().get("Datetime");
			String currentdate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(currentUnixTime*1000);
		Assert.assertEquals(currentdate, responeDateTime);			
		System.out.println("expected is : "+currentdate+" and actual is :"+responeDateTime);
	}
	
	@Then("{string} field present in response should be {string}")
	public void validate_dateTime_value(String responseField, String expectedValue) {
		String responseValue = response.jsonPath().get(responseField);
		Assert.assertEquals(expectedValue, responseValue);
		System.out.println("expected is : "+expectedValue+" and actual is :"+responseValue);
	}
}
