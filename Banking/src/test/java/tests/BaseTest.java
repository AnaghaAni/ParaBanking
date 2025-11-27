package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import drivers.DriverFactory;
import drivers.DriverManager;
import utils.ConfigReader;

public class BaseTest 
{
	// Initialize the logger for test execution tracking and debugging
	
	public static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	/**
     * Setup method to initialize WebDriver before each test method.
     * 
     * @param os       - The operating system parameter (passed from TestNG XML)
     * @param browser  - The browser parameter (passed from TestNG XML)
     */
	
	@Parameters({"os","browser"})
	@BeforeMethod
	public void setUp( String os,String browser)
	{
		
		WebDriver driverRef = DriverFactory.createDriver(browser);
		DriverManager.setWebDriver(driverRef);
		
	    // Navigate to application under test
		DriverManager.getWebDriver().get(ConfigReader.get("base.url"));
	}
	

    /**
     * Tear down method to quit WebDriver after each test method execution.
     * Ensures that browser instances are closed and resources are cleaned up.
     */
	
	@AfterMethod
	public void tearDown()
	{
		if(DriverManager.getWebDriver() !=null)
		{
			DriverManager.getWebDriver().quit(); // close browser
			DriverManager.removeDriver(); //clear ThreadLocal
		}
	}
	
	
}
