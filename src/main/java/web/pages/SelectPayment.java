/**
 * 
 */
package web.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import web.base.WebSetup;

 /**
 * @author nitinthite
 * Class contains web elements and respective methods for Select Payment Type frame 
 */
public class SelectPayment extends WebSetup {
	
	
	@FindBy(id = "payment-list")
	WebElement selectPaymentPop;
	
	@FindBy(xpath = "//a[@href='#/credit-card']")
	WebElement creditCardOption;
	
	
	// Class constructor to initialising same properties as parent constructor
	public SelectPayment() throws FileNotFoundException, IOException {
		
		super();
		
		PageFactory.initElements(driver, this);
		
		assertSelectPaymentDisplayed();
	}

	// Making sure if driver reached to intended page
	public void assertSelectPaymentDisplayed() {
		
		Assert.assertTrue(selectPaymentPop.isDisplayed());
	}

	public void isCreditCardOptionDisplayed() {
		
		Assert.assertTrue(creditCardOption.isDisplayed());
	}

	public void selectCreditCardOption() {
		
		isCreditCardOptionDisplayed();

		creditCardOption.click();
	}
}
