/**
 * Package containing page specific elements and respective methods
 */
package web.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import web.base.WebSetup;

/**
 * @author nitinthite
 * Class contains element locators and respective methods of from HomePage
 */
public class HomePage extends WebSetup{
	
	@FindBy(xpath = "//*[text()='Midtrans Pillow']")
	WebElement homePage;
	
	@FindBy(xpath = "//*[@class='btn buy']")
	WebElement buyNowButton;
	
	@FindBy(xpath = "//*[text()='Thank you for your purchase.']")
	WebElement thankyouMessage;
		
	// Class custom constructor
	public HomePage() throws FileNotFoundException, IOException {
		
		super();
		
		PageFactory.initElements(driver, this);
		
		verifyHomePage();
	}

	// Verifying if driver handle reached home page
	public void verifyHomePage() throws NoSuchWindowException {
		
		try {
			if (homePage.isDisplayed()) {
				
				System.out.println("User is on Home page");
			}
			else {
				System.out.println("There is some issue with the navigation. Refreshing the page.");
				
				driver.navigate().refresh();
				}
		}catch(NoSuchWindowException nswe) {
			nswe.printStackTrace();
		}
	}

	public void clickBuyNowButton() {
		
		Assert.assertTrue(buyNowButton.isDisplayed());
		
		buyNowButton.click();
	}
	
	public void verifySuccessMessage() {
		
		Assert.assertTrue(thankyouMessage.isDisplayed());
	}
}