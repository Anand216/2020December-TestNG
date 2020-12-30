package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/aniruddhabasak/BCS053/jsf-for-beginners/workspace/2020December-TestNG/lib/chromedriver/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
	}
	
	@Test(priority=1, groups= "Title")
	public void googleTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google", "Google title is not matching.");
		
		System.out.println(title);
	}
	
	//@Test
	public void googleLogoTest() {
		boolean b = driver.findElement(By.xpath("//img[@class=\"lnXdpd\" and @alt=\"Google\"]")).isDisplayed();
	}
	
	@Test(priority=2, groups="Link", dependsOnMethods="googleTitleTest")
	public void gmailLinkTest() {
		boolean b1 = driver.findElement(By.xpath("//a[@class=\"gb_g\" and @data-pid=23]")).isDisplayed();
		
		Assert.assertTrue(b1, "The GMail link is not displayed");
	}
	
	@Test(priority=3, groups="Link")
	public void imagesLinkTest() {
		boolean b2 = driver.findElement(By.xpath("//a[@class=\"gb_g\" and @data-pid=2]")).isDisplayed();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
