package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PrameterPractice {

	WebDriver driver;

	@BeforeMethod
	@Parameters({"url"})
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/aniruddhabasak/BCS053/jsf-for-beginners/workspace/2020December-TestNG/lib/chromedriver");
		driver = new ChromeDriver();
		driver.get(url);


	}

	@Test
	@Parameters({"email"})
	public void logInPageTest(@Optional("optional message") String email) {

		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);

		System.out.println(email); //this will print the "optional message" from @Optional on the 2nd run


	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
