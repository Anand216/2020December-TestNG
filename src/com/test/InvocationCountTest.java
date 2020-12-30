package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount=5)
	public void sum() {
		int i=1;
		int j=2;
		int k=i+j;
		System.out.println(k+1);
	}

}
