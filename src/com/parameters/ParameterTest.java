package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
WebDriver driver;
	
	@BeforeMethod
	@Parameters({"url"})
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/aniruddhabasak/BCS053/jsf-for-beginners/workspace/2020December-TestNG/lib/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	@Parameters({"email"})
	public void yahooLoginTest(String email) {
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
