/**
 * 
 */
package pageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.WebSetup;

/**
 * @author nitinthite
 *
 */
public class CartPanel extends WebSetup {
	
	// Initialising objects mentioned in parent class constructor
	public CartPanel() throws FileNotFoundException, IOException {
		
		super();
		assertCartPanel();
	}

	// Making sure if driver reached to intended page
	public void assertCartPanel() {

		Assert.assertTrue(shoppingCartPanel().isDisplayed());
		
	}

	// Fetching number of items added to cart
	public int ifCartHasItems() {
		
		Assert.assertTrue(cartItems().isDisplayed());

		int items = Integer.parseInt(cartItems().getText());
		
		return items;
	}

	public void clickCheckoutButton() {
		
		if (ifCartHasItems() >= 1) {
			
			Assert.assertTrue(checkoutButton().isDisplayed());

			checkoutButton().click();
		}
		else {
			System.out.println("*** Cart is Empty!!!");
		}
	}

	// ******** Element locators listed below for the CART PANEL - are used by methods above ********
	private WebElement shoppingCartPanel() {

		return driver.findElement(By.xpath("//*[@class='cart-head']/span[1]"));
	}

	private WebElement cartItems() {

		return driver.findElement(By.xpath("//*[@class='cart-head']/span[2]"));
	}

	private WebElement checkoutButton() {

		return driver.findElement(By.xpath("//*[@class='cart-checkout']"));
	}

}