package com.myproject1.testecases;

import org.testng.annotations.Test;

import com.myproject1.pageobject.Interview;

public class HandleDropDownSelect extends baseClass {
	@Test
	public void dropDownBySelectClass() throws InterruptedException {
		
		Interview interview = new Interview(driver);
		logger.info("Drop down handling by Select Class");
		logger.info("Portolo website Opened");
		
		interview.enterEmailAddress("123");
		logger.info("Email entered");
		interview.enterPassword("Test@123");
		logger.info("Password entered");
		interview.clickonSignIn();
		logger.info("Clicked on Sign in button");
		Thread.sleep(2000);
		interview.clickonMyPages();
		logger.info("User logged in and clicked on My Pages menu");
		interview.clickonMyProfile();
		logger.info("Clicked on My Profile");
		Thread.sleep(4000);
		
		interview.selectCountry("India");
		logger.info(" India Selected");
		Thread.sleep(2000);
		
		interview.selectTimeZone("Asia/India/Kolkata");
		logger.info(" Time Zone Selected");
		interview.clickonSaveButton();
		logger.info("Profile Saved");
		
	}

}
