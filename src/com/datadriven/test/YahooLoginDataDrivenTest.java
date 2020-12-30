package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.excel.utility.TestUtil;

public class YahooLoginDataDrivenTest {

	WebDriver driver;

	@BeforeMethod
	@Parameters({"url"})
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/aniruddhabasak/BCS053/jsf-for-beginners/workspace/2020December-TestNG/lib/chromedriver");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(url);
	}
	
	@DataProvider(name = "getTestData")
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	
	//@Test(dataProvider = "getTestData", retryAnalyzer = Analyzer.RetryAnalyzer.class)
	@Test(dataProvider = "getTestData")
	public void yahooLoginPageTest(String firstName, String surName, String eMail, String mobile, String birthMonth, String birthDay, String birhtYear, String gender){
		//enter data
		driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='usernamereg-firstName1']")).sendKeys(firstName);	
		
		driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys(surName);

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}