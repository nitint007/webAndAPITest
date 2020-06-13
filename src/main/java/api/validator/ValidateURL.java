package api.validator;

import java.net.MalformedURLException;
import io.restassured.internal.UriValidator;

public class ValidateURL {
	
	// To check if URL is valid
	public boolean isValidURL(String URL) throws MalformedURLException {
		
		boolean validation;
		
		// To access methods of UriValidator class for validating URL received
		UriValidator urlValidator = new UriValidator();
		validation = urlValidator.isUri(URL);
		
	return validation;
	}
}
