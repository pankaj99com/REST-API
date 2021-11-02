package TestCase;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class SimpleGetTest {

	@Test
	public void GetWeatherDetails() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the
		// method URL.
		// This will return the Response from the server. Store the response in
		// a variable.
		Response response = httpRequest.request(Method.GET, "/Bangalore");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

		// Validate status code

		int status = response.getStatusCode();
		System.out.println("Status code is " + status);
		Assert.assertEquals(status, 200);

		// Validate status line
		String statusline = response.getStatusLine();
		System.out.println("Status line is " + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}

}