/**
 * 
 */
package web.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

import web.base.WebSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author nitinthite
 *
 */
public class OrderSummary extends WebSetup {
	
	// Class constructor to initialising same properties as parent constructor
	public OrderSummary () throws FileNotFoundException, IOException {
		
		super();
		assertOrderSummary();
	}

	// Making sure if driver reached to intended page
	public void assertOrderSummary() {
		
		switchToOrderSummaryFrame();
		Assert.assertTrue(orderSummary().isDisplayed());
	}
	
	public void switchToOrderSummaryFrame() {
		
		driver.switchTo().frame(orderSummaryFrame());
		System.out.println("*** Switched to Order Summary iFrame");
	}

	public void clickContinue() {
		
		Assert.assertTrue(continueButton().isEnabled());
		continueButton().click();
	}

	// ******** Element locators listed below for the Order Summary - are used by methods above ********
	private WebElement orderSummaryFrame() {
		
		return driver.findElement(By.id("snap-midtrans"));
	}
	
	private WebElement orderSummary() {
		
		return driver.findElement(By.xpath("//*[text()='Order Summary']"));
	}

	private WebElement continueButton() {

		return driver.findElement(By.xpath("//a[@class='button-main-content']"));
	}

}
