/**
 * 
 */
package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.WebSetup;
import pageObjects.BankDetails;
import pageObjects.CartPanel;
import pageObjects.CreditCardPayment;
import pageObjects.HomePage;
import pageObjects.OrderSummary;
import pageObjects.PaymentStatus;
import pageObjects.SelectPayment;

/**
 * @author nitinthite
 *
 */
public class PositiveBuy extends WebSetup {
	
	// Classes utilised
		HomePage homepage;
		CartPanel cartPanel;
		OrderSummary ordersummary;
		SelectPayment selectpayment;
		BankDetails bankdetails;
		PaymentStatus paymentstatus;
		CreditCardPayment payment;

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
		homepage = new HomePage();
		
		// Steps for adding item to cart and verifying same
		homepage.clickBuyNowButton();
		
		cartPanel = new CartPanel();
		cartPanel.clickCheckoutButton();
		
		ordersummary = new OrderSummary();
		ordersummary.clickContinue();
	}

	@Test(priority=2)
	public void enterValidDetails() throws Throwable {
		
		// Payment details for Credit card
	    selectpayment = new SelectPayment();
	    selectpayment.selectCreditCardOption();
	    
	    payment = new CreditCardPayment();
	    payment.enterCardDetails(properties.getProperty("validCardNumber"), 
	    		properties.getProperty("expiryDate"), properties.getProperty("cvv"));
	    payment.importantMessageDisaplyed();
	    payment.clickPayNowButton();
	}
	
	@Test(priority=3)
	public void purchaseSuccess() throws Throwable {
		
		bankdetails = new BankDetails();
		bankdetails.enterOTP(properties.getProperty("otp"));
		
	    homepage = new HomePage();
	    homepage.verifySuccessMessage();
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
