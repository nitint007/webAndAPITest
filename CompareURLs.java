/**
 * To provide step definitions or implementation details for Feature file
 */
package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import base.Base;
import comparator.ResponseComparator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import validator.ValidateFile;

/**
 * @author nitinthite
 * To provide feature file implementation
 */
public class CompareURLs extends Base {

	ResponseComparator compare;
	ValidateFile validatefile;
	ValidateFile vurl;

	// Class constructor to initialising same properties as parent constructor
	public CompareURLs() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	// ************** @Given - implementation details **************
	/*
	 * Precondition for all scenarios - starting point for each scenario
	 */
	@Given("^Provided urls are valid$")
	public void validateFiles() throws Throwable {

		vurl = new ValidateFile();
		Assert.assertTrue("* * * File Provided is NOT valid", vurl.isValidFile(properties.getProperty("file1")));
		Assert.assertTrue("* * * File Provided is NOT valid", vurl.isValidFile(properties.getProperty("file2")));
	}

	// ************** @When - implementation details **************
	/*
	 * To performing actions
	 */
	@When("^If response data is equal$")
	public void ifResponseEqual() throws Throwable {

		compare = new ResponseComparator();
		Assert.assertEquals(true,
				compare.compareResponses(properties.getProperty("file1"), properties.getProperty("file2")));
	}

	@When("^If response data not equal$")
	public void ifResponseNotEqual() throws Throwable {

		compare = new ResponseComparator();
		Assert.assertNotEquals(false,
				compare.compareResponses(properties.getProperty("file1"), properties.getProperty("file2")));
	}

	@When("^If one not URL$")
	public void ifNoURL() throws Throwable {

		compare = new ResponseComparator();
		Assert.assertNotEquals(false,
				compare.compareResponses(properties.getProperty("file1"), properties.getProperty("file2")));
	}

	// ************** @Then - implementation details **************
	/*
	 * To verify the results of respective actions
	 */
	@Then("^Should respond result as equal$")
	public void respondAsEqual() throws Throwable {

		compare = new ResponseComparator();
		Assert.assertEquals("URLs provided are NOT Equal", compare.comparisonResult());
	}

	@Then("^Should respond result as not equal$")
	public void respondNotEqual() throws Throwable {

		compare = new ResponseComparator();
		Assert.assertNotEquals("URLs provided are Equal", compare.comparisonResult());
	}

	@Then("^Should respond Invalid URL$")
	public void respondInvalidURL() throws Throwable {

		compare = new ResponseComparator();
		Assert.assertFalse("Data provided not a URL", compare.comparisonResult());
	}
}