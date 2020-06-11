/**
 * 
 */
package testCases.web;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import web.base.WebSetup;
import web.pages.BankDetails;
import web.pages.CartPanel;
import web.pages.CreditCardPayment;
import web.pages.HomePage;
import web.pages.OrderSummary;
import web.pages.SelectPayment;

/**
 * @author nitinthite
 *
 */
public class PositiveBuy extends WebSetup {

	public PositiveBuy() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeSuite
	public void beforeAllScenarios()  {
		System.out.println("Inside Hooks @Before");
		setUp();
	}

	@Test(priority=1)
	public void itemAddedToCart() throws Throwable {
		
		// Creating Page object for accessing respective methods
		HomePage homepage = new HomePage();
		
		// Steps for adding item to cart and verifying same
		homepage.clickBuyNowButton();
		
		CartPanel cartPanel = new CartPanel();
		cartPanel.clickCheckoutButton();
		
		OrderSummary ordersummary = new OrderSummary();
		ordersummary.clickContinue();
	}

	@Test(priority=2)
	public void enterValidDetails() throws Throwable {
		
		// Payment details for Credit card
		SelectPayment selectpayment = new SelectPayment();
	    selectpayment.selectCreditCardOption();
	    
	    CreditCardPayment payment = new CreditCardPayment();
	    payment.enterCardDetails(properties.getProperty("validCardNumber"), 
	    		properties.getProperty("expiryDate"), properties.getProperty("cvv"));
	    payment.importantMessageDisaplyed();
	    payment.clickPayNowButton();
	}
	
	@Test(priority=3)
	public void purchaseSuccess() throws Throwable {
		
		BankDetails bankdetails = new BankDetails();
		bankdetails.enterOTP(properties.getProperty("otp"));
		
		HomePage homepage = new HomePage();
	    homepage.verifySuccessMessage();
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
