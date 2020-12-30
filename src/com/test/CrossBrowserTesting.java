package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	
	WebDriver driver;
	
	
	@BeforeMethod
	@Parameters({"url", "browser"})
	public void setUp(String url, String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/aniruddhabasak/BCS053/jsf-for-beginners/workspace/2020December-TestNG/lib/geckodriver");
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/aniruddhabasak/BCS053/jsf-for-beginners/workspace/2020December-TestNG/lib/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}
		
		driver.get(url);
		
		
	}
	
	@Test
	public void verifyGooglePageTitle() {
		driver.getTitle();
		Reporter.log("We have used chromedriver version 87");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
