package com.myproject1.testecases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.myproject1.pageobject.Interview;


public class HardAssertion extends baseClass {
	
	
	@Test
	public void hardassertion() {
	
	Interview interview = new Interview(driver);
	logger.info("Verifying hard assertion");

	interview.enterText("Amazon");
	logger.info("Amazon is entered");
	String expectedTitle = "Amazon - Google Search";
	String actualTitle = driver.getTitle();
	assertEquals(actualTitle , expectedTitle ,"Title mismatch");
	
	driver.get("https://www.facebook.com/");
	logger.info("hard assertion passed");
	
	}

}
