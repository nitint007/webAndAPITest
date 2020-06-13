/**
 * Package contains testNG classes with test cases related to WEB automation suite
 */
package testCases.web;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import commonSteps.CommonPurchaseSteps;
import web.base.WebSetup;
import web.pages.HomePage;

/**
 * @author nitinthite
 * Test steps to check results on providing valid details
 */
public class PositiveBuy extends WebSetup {

	public PositiveBuy() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeGroups("webautomation")
	public void beforeAllScenarios() throws Exception {
		System.out.println("Inside @BeforeGroups");
		setUp();
	}

	@Test(priority = 1, groups = "webautomation")
	public void purchaseWithValidDetails() throws Throwable {

		CommonPurchaseSteps commonsteps = new CommonPurchaseSteps();
		commonsteps.purchaseSteps(properties.getProperty("validCardNumber"));
	}
	
	@Test(priority = 2, groups = "webautomation")
	public void verifySuccess() throws Throwable {

		HomePage homepage = new HomePage();
		homepage.verifySuccessMessage();
	}
	
	// To close all active instances of webdriver
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
