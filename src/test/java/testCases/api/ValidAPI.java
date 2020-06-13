/**
 * Package contains testNG classes with test cases related to API test automation suite
 */
package testCases.api;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.base.Base;
import api.comparator.ResponseComparator;
import api.validator.ValidateFile;

/**
 * @author nitinthite
 * Test steps to check if API is invalid
 */
public class ValidAPI extends Base{

	public ValidAPI() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test(priority=1)
	public void validateFiles() throws Throwable {

		ValidateFile vurl = new ValidateFile();
		Assert.assertTrue(vurl.isValidFile(properties.getProperty("file1")));
		Assert.assertTrue(vurl.isValidFile(properties.getProperty("file2")));
	}
	
	@Test(priority=2)
	public void ifResponseEqual() throws Throwable {

		ResponseComparator compare = new ResponseComparator();
		Assert.assertEquals(true,
				compare.compareResponses(properties.getProperty("file1"), properties.getProperty("file2")));
	}
	
	@Test(priority=3)
	public void respondAsEqual() throws Throwable {

		ResponseComparator compare = new ResponseComparator();
		Assert.assertEquals(false, compare.comparisonResult());
	}

}
