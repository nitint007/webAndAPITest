/*
 * Package contains classes of common test steps used by classes from package 'testcases'
 */
package commonSteps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;

import web.base.WebSetup;
import web.pages.BankDetails;
import web.pages.CartPanel;
import web.pages.CreditCardPayment;
import web.pages.HomePage;
import web.pages.OrderSummary;
import web.pages.SelectPayment;

// To provide implementation details for common test steps
public class CommonPurchaseSteps extends WebSetup {

	public CommonPurchaseSteps() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 *  To implement details of purchase steps as 
	 *  'add product to cart', 'select credit card as payment type', 'entering credit card details', 'enter bank otp' etc.
	 */
	public void purchaseSteps(String cardNumber)
			throws FileNotFoundException, IOException, NoSuchElementException, InterruptedException {

		// To add product to cart
		HomePage homepage = new HomePage();
		homepage.clickBuyNowButton();

		// To proceed on checkout from cart panel
		CartPanel cartPanel = new CartPanel();
		cartPanel.clickCheckoutButton();

		// To continue from order summary
		OrderSummary ordersummary = new OrderSummary();
		ordersummary.clickContinue();

		// To select payment payment type
		SelectPayment selectpayment = new SelectPayment();
		selectpayment.selectCreditCardOption();

		// To enter card details
		CreditCardPayment payment = new CreditCardPayment();
		payment.enterCardDetails(cardNumber, properties.getProperty("expiryDate"), properties.getProperty("cvv"));
		payment.importantMessageDisaplyed();
		payment.clickPayNowButton();

		// To enter otp
		BankDetails bankdetails = new BankDetails();
		bankdetails.enterOTP(properties.getProperty("otp"));
	}

}
