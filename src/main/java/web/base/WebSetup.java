/**
 * Parent class for all classes used under WEB automation suite
 */
package web.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import web.util.UserValues;

/**
 * @author nitinthite
 * Class with custom constructor to initialise objects for properties used in child classes
 * Also to initialise webdriver session with intended properties i.e accessible to child classes
 */
public class WebSetup {

	// Webdriver instance for easy access
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties properties;


	// Class constructor for initialising objects
	public WebSetup() throws FileNotFoundException, IOException {
		BufferedReader reader;
		try {
			String configFilePath = "./src/test/resources/testdataresources/testData/web/Data.properties";
			reader = new BufferedReader(new FileReader(configFilePath));
			properties = new Properties();
			properties.load(reader);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			throw new RuntimeException("File Data.properties not found at given path.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new RuntimeException("Issue on reading file.");
		}
	}

	/*
	 * Method details out configuration for selected browser
	 * 
	 * @param browser
	 * 
	 * @throws Exception
	 */
	@BeforeTest
	// @Parameters("chrome")
	public WebDriver setUp() throws Exception {

		// To accept and assign 'browser name' user input to test
		UserValues uv = new UserValues();
		String browser = uv.setBrowserName();

		// To check if parameter passed from TestNG is 'chrome'
		if (browser.equalsIgnoreCase("chrome")) {
			
			// To create firefox instance
			driver = new ChromeDriver();
		}
		// Check if parameter passed as 'firefox'
		else if (browser.equalsIgnoreCase("firefox")) {
			
			// create chrome instance
			driver = new FirefoxDriver();
		} else {
			
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		// To maximise the browser
		driver.manage().window().maximize();

		// Deleting all cookies
		driver.manage().deleteAllCookies();

		// Maximum time for wait for page to load to timeout
		driver.manage().timeouts().pageLoadTimeout(65, TimeUnit.SECONDS);

		// Describing default wait time for each element in tests
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// To open the URL in browser window
		driver.get(properties.getProperty("url"));
		
		return driver;
	}
}
