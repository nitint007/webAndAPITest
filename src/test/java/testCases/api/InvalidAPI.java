/**
 * 
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
 *
 */
public class InvalidAPI extends Base{

	public InvalidAPI() throws FileNotFoundException, IOException {
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
	public void ifResponseNotEqual() throws Throwable {

		ResponseComparator compare = new ResponseComparator();
		Assert.assertNotEquals(false,
				compare.compareResponses(properties.getProperty("file1"), properties.getProperty("file2")));
	}
	
	@Test(priority=3)
	public void respondNotEqual() throws Throwable {

		ResponseComparator compare = new ResponseComparator();
		Assert.assertNotEquals("URLs provided are Equal", compare.comparisonResult());
	}

}
