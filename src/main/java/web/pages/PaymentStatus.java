/**
 * 
 */
package web.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import web.base.WebSetup;

/**
 * @author nitinthite
 *
 */
public class PaymentStatus extends WebSetup {
	
	
	@FindBy(id = "snap-midtrans")
	WebElement creditCardFrame;
	
	@FindBy(xpath = "//*[@class='main-container']//span")
	WebElement creditCardStatus;
	
	@FindBy(xpath = "//a[@class='button-main-content']")
	WebElement paymentStatusButton;
	
	@FindBy(xpath = "//*[@class='bottom']//div")
	WebElement paymentStatus;
	
	// Class constructor to initialising same properties as parent constructor
	public PaymentStatus() throws FileNotFoundException, IOException {
		
		super();
		
		PageFactory.initElements(driver, this);
		
		switchToCreditCardFrame();
	}
	
	private String paymentStatusBottomText() {

		String message =  paymentStatus.getText();
		System.out.println("Transsaction status message :" +message);
		
		return message;
	}
	
	// To switch driver handle on frame for further operations
	public void switchToCreditCardFrame() {
		
		driver.switchTo().frame(creditCardFrame);
		System.out.println("*** Switched to Credit card payment status iFrame");
	}

	// Method to Retry transaction on failure or complete same in case Successful
	public void paymentStatusAction() {
		
		paymentStatusButton.click();
		driver.navigate().refresh();
	}
}
