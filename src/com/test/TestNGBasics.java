package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test(priority=1, groups= "sanity")
	public void test() {
		System.out.println("Test");
	}
	
	@AfterMethod
	public void afterMehtod() {
		System.out.println("After Method");
	}

}
