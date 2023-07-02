package com.myproject1.testecases;



import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.myproject1.pageobject.Interview;

public class SoftAssertion extends baseClass {

	@Test
	public void softassertion() throws InterruptedException {

		Interview interview = new Interview(driver);
		logger.info("Verifying soft assertion");
		interview.enterEmail("abc");
		logger.info("wrong email is entered");
		interview.clickOnLogin();
		logger.info("Button pressed");
		Thread.sleep(5000);

		// Soft Title Assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log in to Facebookdddd";
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actualTitle, expectedTitle, "Title mismatch");

		
		String expectedURL = "https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjg1MjExNDA4LCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D";
		String actualURL = driver.getCurrentUrl();
		 softassert.assertEquals(actualURL, expectedURL, "URL mismatch");
		 
		 
		 softassert.assertAll();

	}

}
