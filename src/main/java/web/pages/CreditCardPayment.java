/**
 * 
 */
package web.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import web.base.WebSetup;

/**
 * @author nitinthite
 *
 */
public class CreditCardPayment extends WebSetup {

	@FindBy(xpath = "//*[@class='text-page-title-content']")
	WebElement creditCardPaymentTitle;

	@FindBy(xpath = "//*[@class='pop']")
	WebElement importantMessage;

	@FindBy(name = "cardnumber")
	WebElement creditCardNumberInputField;

	@FindBy(xpath = "//*[@class='validation']")
	WebElement creditCardNumberValidation;

	@FindBy(xpath = "//input[@placeholder='MM / YY']")
	WebElement creditCardExpiryDateInputField;

	@FindBy(xpath = "//input[@placeholder='123']")
	WebElement creditCardCVVInputField;

	@FindBy(xpath = "//*[@class='notice danger']//span")
	WebElement invalidCardDetailsMessage;

	@FindBy(xpath = "//*[@class='button-main-content']")
	WebElement payNowButton;

	// Initialising objects mentioned in parent class constructor
	public CreditCardPayment() throws FileNotFoundException, IOException {

		super();

		PageFactory.initElements(driver, this);

		assertCreditCardPaymentDisplayed();
	}

	// Making sure if driver reached to intended page
	public void assertCreditCardPaymentDisplayed() {

		Assert.assertTrue(creditCardPaymentTitle.isDisplayed());

		System.out.println("User On :" + creditCardPaymentTitle.getText());
	}

	public void importantMessageDisaplyed() {

		Assert.assertTrue(importantMessage.isDisplayed());

		System.out.println("Message displayed as :: " + importantMessage.getText());
	}

	// Method to Enter card details
	public void enterCardDetails(String cardNumber, String expDate, String cvv) {

		enterCardDetails(cardNumber, creditCardNumberInputField);
		enterCardDetails(expDate, creditCardExpiryDateInputField);
		enterCardDetails(cvv, creditCardCVVInputField);
	}

	public void clickPayNowButton() throws NoSuchElementException {

		try {
			if (payNowButton.isEnabled()) {

				payNowButton.click();
			} else if (invalidCardDetailsMessage.isDisplayed()) {

				System.out.println("*!*!* Invalid card  - navigating user to Home Page");
				driver.navigate().back();
				driver.navigate().refresh();

			}
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			if (invalidCardDetailsMessage.isDisplayed()) {
				driver.navigate().back();
				driver.navigate().refresh();
			}
			throw new RuntimeException("* * * * * Issue with proceeding with scenario execution!!!");
		}
	}

	// Method to check if Invalid Card Message displayed
	private void invalidCardMessage() {

		if (invalidCardDetailsMessage.isDisplayed()) {
			System.out.println("Message displayed on entering card number : " + invalidCardDetailsMessage.getText());
			System.out.println("Invalid card details - navigating to Home page");
			driver.navigate().refresh();
		} else {
			System.out.println("Invalid card details message NOT displayed");
		}
	}

	// Method to enter card details
	private void enterCardDetails(String cardDetail, WebElement element) {

		Assert.assertTrue(element.isDisplayed());

		// Steps for entering credit card number
		element.click();
		element.clear();
		element.sendKeys(String.valueOf(cardDetail));

		Assert.assertTrue(creditCardNumberValidation.isDisplayed());
	}

}
