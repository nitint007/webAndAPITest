/**
 * Package for webpage objects and method related to that
 */
package web.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

import web.base.WebSetup;

/**
 * @author nitinthite
 * Class contains required web elements and respective methods from BankDetails frame 
 */
public class BankDetails extends WebSetup{

	// Initialising objects mentioned in parent class constructor
	public BankDetails() throws FileNotFoundException, IOException {

		super();
		goToIssuingBankFrame();
	}

	// To switch driver handle on frame for further operations
	public void goToIssuingBankFrame() throws NoSuchWindowException{
		
		try {
			driver.switchTo().frame(issuingBankiFrame());
			System.out.println("*** Switched to Issuing Bank iFrame");
		} catch (NoSuchWindowException nswe) {
			nswe.printStackTrace();
		}
	}

	public void enterOTP(String otp) throws InterruptedException, NoSuchElementException {

		try {
			Thread.sleep(10000);
			otpInputField().click();
			otpInputField().clear();
			otpInputField().sendKeys(otp);

			// Submitting Bank OTP
			otpInputField().submit();

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

	// ******** Element locators listed below for the Bank Details - are used by
	// methods above ********
	private WebElement otpInputField() {
		
		return driver.findElement(By.xpath("//input[@type='password']"));
	}

	private WebElement issuingBankiFrame() {
	
		return driver.findElement(By.xpath("//*[@class='main-container']//iframe"));
	}
}
