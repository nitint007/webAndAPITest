/**
 * 
 */
package pageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.WebSetup;

/**
 * @author nitinthite
 *
 */
public class PaymentStatus extends WebSetup {
	
	// Class constructor to initialising same properties as parent constructor
	public PaymentStatus() throws FileNotFoundException, IOException {
		
		super();
		switchToCreditCardFrame();
	}
	
	// To switch driver handle on frame for further operations
	public void switchToCreditCardFrame() {
		
		driver.switchTo().frame(creditCardFrame());
		System.out.println("*** Switched to Credit card payment status iFrame");
	}

	// Method to Retry transaction on failure or complete same in case Successful
	public void paymentStatusAction() {
		
		paymentStatusButton().click();
		driver.navigate().refresh();
	}

	// ******** Element locators listed below for the Credit card payment status - used by methods above ********
	private WebElement creditCardFrame() {
			
			return driver.findElement(By.id("snap-midtrans"));
	}
	
	private WebElement creditCardStatus() {
		
		return driver.findElement(By.id("//*[@class='main-container']//span"));
}
	
	private WebElement paymentStatusButton() {
		
		return driver.findElement(By.xpath("//a[@class='button-main-content']"));
	}
	
	private WebElement paymentStatus() {
		
		return driver.findElement(By.xpath("//*[@class='bottom']//div"));
	}
	
	private String paymentStatusBottomText() {

		String message =  paymentStatus().getText();
		System.out.println("Transsaction status message :" +message);
		
		return message;
	}
}
