/**
 * Package contains testNG classes with test cases related to WEB automation suite
 */
package testCases.web;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import commonSteps.CommonPurchaseSteps;
import web.base.WebSetup;
import web.pages.PaymentStatus;

/**
 * @author nitinthite
 * Test steps to check results on providing invalid details
 */
public class NegativeBuy extends WebSetup {

	public NegativeBuy() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority = 3, groups = "webautomation")
	public void purchaseWithInvalidDetails() throws Throwable {

		CommonPurchaseSteps commonsteps = new CommonPurchaseSteps();
		commonsteps.purchaseSteps(properties.getProperty("invalidCardNumber"));
	}
	
	@Test(priority = 4, groups = "webautomation")
	public void verifyPaymentStatus() throws Throwable {

		PaymentStatus paymentstatus = new PaymentStatus();
		paymentstatus.paymentStatusAction();
	}
}
