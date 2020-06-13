package api.validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

// To validate file received
public class ValidateFile {

	// To check if given file is valid or not
	public boolean isValidFile(String file) throws MalformedURLException, FileNotFoundException {

		// To store results and used to return same
		boolean validation = false;

		// To store received file in string format
		File f = new File(file.toString());

		// To check if file is valid to avoid processing further in case invalid file
		// Used '.isFile() method from File class
		validation = f.isFile();

		return validation;
	}

}
