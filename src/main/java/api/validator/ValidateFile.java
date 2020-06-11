package api.validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class ValidateFile {

	// To check if given file is valid or not
	public boolean isValidFile(String file) throws MalformedURLException, FileNotFoundException {

		boolean validation = false;

		File f = new File(file.toString());

		validation = f.isFile();

		return validation;
	}

}
