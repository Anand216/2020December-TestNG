package com.datadriven.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.excel.utility.TestUtil;

public class YahooLoginTest {
	
	WebDriver driver;
	Properties prop;
	FileInputStream ip;
	
	@BeforeMethod
	@Parameters({"URL", "browser"})
	public void setUp(String URL, String browser) throws IOException {
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "/Users/aniruddhabasak/BCS053/jsf-for-beginners/workspace/2020August-Selenium/lib/chromedriver/chromedriver");
		driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(URL);
		
		prop = new Properties();
		ip = new FileInputStream("/Users/aniruddhabasak/BCS053/jsf-for-beginners/workspace/2020December-TestNG/src/com/datadriven/test/config.properties");

		prop.load(ip);
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	
	@Test(dataProvider = "getTestData")
	public void yahooRegistrationTest(String firstName, String surName, String eMail, String mobile, String birthMonth, String birthDay, String birhtYear, String gender) {
		driver.findElement(By.xpath(prop.getProperty("firstName"))).clear();
		driver.findElement(By.xpath(prop.getProperty("firstName"))).sendKeys(firstName);	
		
		driver.findElement(By.xpath(prop.getProperty("lastName"))).clear();
		driver.findElement(By.xpath(prop.getProperty("lastName"))).sendKeys(surName);

	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		ip.close();
		driver.quit();
	}

}
