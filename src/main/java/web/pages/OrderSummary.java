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
 *
 */
public class OrderSummary extends WebSetup {
	
	@FindBy(id = "snap-midtrans")
	WebElement orderSummaryFrame;
	
	@FindBy(xpath = "//*[text()='Order Summary']")
	WebElement orderSummary;
	
	@FindBy(xpath = "//a[@class='button-main-content']")
	WebElement continueButton;
	
	// Class constructor to initialising same properties as parent constructor
	public OrderSummary () throws FileNotFoundException, IOException {
		
		super();
		
		PageFactory.initElements(driver, this);
		
		assertOrderSummary();
	}

	// Making sure if driver reached to intended page
	public void assertOrderSummary() {
		
		switchToOrderSummaryFrame();
		Assert.assertTrue(orderSummary.isDisplayed());
	}
	
	public void switchToOrderSummaryFrame() {
		
		driver.switchTo().frame(orderSummaryFrame);
		System.out.println("*** Switched to Order Summary iFrame");
	}

	public void clickContinue() {
		
		Assert.assertTrue(continueButton.isEnabled());
		continueButton.click();
	}
}
