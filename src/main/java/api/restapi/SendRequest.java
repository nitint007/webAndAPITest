package api.restapi;

import java.net.URISyntaxException;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SendRequest {
	
	// To make the objects available throughout the class methods and sub packages
		protected RequestSpecification httpRequest;
		protected Response response;
		protected String bodyAsString;
		protected ResponseBody body;


		// To fetch response from requested url and reverting respective
		public String getResponse(String url) throws ParseException, URISyntaxException  {
			
			// Method variables and declaring objects
			int actualStatusCode;
			String res;
			
			// Specifying URI to test
			RestAssured.baseURI = url;
			httpRequest = RestAssured.given();

			// Storing response received in response object
			response = httpRequest.request().get();
			
			actualStatusCode = response.getStatusCode();
			
			// Code block for valid responses for further operations
			if (actualStatusCode == 200) {
				
				// Retrieve the body of the Response
				body = response.getBody();

				// To check for sub string presence get the Response body as a String.
				bodyAsString = body.asString();
				
				res = bodyAsString;
			}
			else {
				res = "Invalid";
			}
			return res;
		}
}
