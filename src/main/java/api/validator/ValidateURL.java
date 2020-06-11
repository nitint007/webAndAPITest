package api.validator;

import java.net.MalformedURLException;
import io.restassured.internal.UriValidator;

public class ValidateURL {
	
	// To check if URL is valid
	public boolean isValidURL(String URL) throws MalformedURLException {
		
		boolean validation;
		
		UriValidator urlValidator = new UriValidator();
		validation = urlValidator.isUri(URL);
		
	return validation;
	}
}
