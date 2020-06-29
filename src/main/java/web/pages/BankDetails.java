/**
 * 
 */
package web.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import web.base.WebSetup;

/**
 * @author nitinthite
 * Class contains web elements and respective methods from BankDetails frame 
 */
public class BankDetails extends WebSetup{
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement otpInputField;
	
	@FindBy(xpath = "//*[@class='main-container']//iframe")
	WebElement issuingBankiFrame;

	// Initialising objects mentioned in parent class constructor
	public BankDetails() throws FileNotFoundException, IOException {

		super();
		
		PageFactory.initElements(driver, this);
		
		goToIssuingBankFrame();
	}

	// To switch driver handle on frame for further operations
	public void goToIssuingBankFrame() throws NoSuchWindowException{
		
		try {
			driver.switchTo().frame(issuingBankiFrame);
			System.out.println("*** Switched to Issuing Bank iFrame");
		} catch (NoSuchWindowException nswe) {
			nswe.printStackTrace();
		}
	}

	public void enterOTP(String otp) throws InterruptedException, NoSuchElementException {

		try {
			Thread.sleep(10000);
			otpInputField.click();
			otpInputField.clear();
			otpInputField.sendKeys(otp);

			// Submitting Bank OTP
			otpInputField.submit();

			driver.switchTo().defaultContent();
			System.out.println("Switched to Default content");
		} 
		catch (InterruptedException ie)
		{
			ie.printStackTrace();
		} 
		catch (NoSuchElementException nse)
		{
			nse.printStackTrace();
			throw new RuntimeException("* * * * * Issue finding element");
		}
	}
}
