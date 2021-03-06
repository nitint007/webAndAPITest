/**
 * Package contains testNG classes with test cases related to API test automation suite
 */
package testCases.api;

import org.testng.annotations.Test;

import api.base.Base;
import api.comparator.ResponseComparator;
import api.validator.ValidateFile;

import org.testng.AssertJUnit;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

/**
 * @author nitinthite To check URL validation test steps
 */
public class CheckURL extends Base {

	public CheckURL() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority = 1)
	public void validateFiles() throws Throwable {

		ValidateFile vurl = new ValidateFile();
		AssertJUnit.assertTrue(vurl.isValidFile(properties.getProperty("longfile1")));
		AssertJUnit.assertTrue(vurl.isValidFile(properties.getProperty("longfile2")));
	}

	@Test(priority = 2)
	public void ifNoURL() throws Throwable {

		ResponseComparator compare = new ResponseComparator();
		Assert.assertNotEquals(false,
				compare.compareResponses(properties.getProperty("longfile1"), properties.getProperty("longfile2")));
	}

	@Test(priority = 3)
	public void respondInvalidURL() throws Throwable {

		ResponseComparator compare = new ResponseComparator();
		AssertJUnit.assertFalse(compare.comparisonResult());
	}

}
