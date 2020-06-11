/**
 * 
 */
package testCases.web;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import web.base.WebSetup;
import web.pages.BankDetails;
import web.pages.CartPanel;
import web.pages.CreditCardPayment;
import web.pages.HomePage;
import web.pages.OrderSummary;
import web.pages.PaymentStatus;
import web.pages.SelectPayment;

/**
 * @author nitinthite
 *
 */
public class NegativeBuy extends WebSetup {

	public NegativeBuy() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority = 1)
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

	@Test(priority = 2)
	public void enterInvalidDetails() throws Throwable {

		// Payment details for Credit card
		SelectPayment selectpayment = new SelectPayment();
		selectpayment.selectCreditCardOption();

		CreditCardPayment payment = new CreditCardPayment();
		payment.enterCardDetails(properties.getProperty("invalidCardNumber"), 
				properties.getProperty("expiryDate"), properties.getProperty("cvv"));
		payment.importantMessageDisaplyed();
		payment.clickPayNowButton();
	}

	// Method to verify results on invalid entries
	@Test(priority = 3)
	public void purchaseFailed() throws Throwable {
		BankDetails bankdetails = new BankDetails();
		bankdetails.enterOTP(properties.getProperty("otp"));

		PaymentStatus paymentstatus = new PaymentStatus();
		paymentstatus.paymentStatusAction();
	}

}
