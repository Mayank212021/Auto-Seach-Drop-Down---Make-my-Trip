package com.myproject1.testecases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myproject1.pageobject.accountCreationDetails;
import com.myproject1.pageobject.indexPage;
import com.myproject1.pageobject.LoginPage;
import com.myproject1.pageobject.MyAccountPage;

public class TC_MyAccountPage extends baseClass {
    // Test case -1
	@Test(enabled = false) // disable the test case
	public void verifyRegistrationAndLogin() {


		indexPage ipage = new indexPage(driver);
		logger.info("Verifying registration and login test case started");
		ipage.clickOnSignBtn();
		logger.info("Clicked on the sign in button");
		LoginPage loginpg = new LoginPage(driver);
		loginpg.enterEmail("kaka212021@gmail.com");
		logger.info("Email Id entered on create account section");
		loginpg.submit();
		logger.info("Clicked on the submit button"); 

		accountCreationDetails accountCreate = new accountCreationDetails(driver);
		accountCreate.selectTitle();
		logger.info("Title Selected");
		accountCreate.enterFirstName("Mayank");
		logger.info("Entered First Name");
		accountCreate.enterLastName("Kaushik"); 
		logger.info("Entered Last Name");
		accountCreate.enterPass("Kaka212021");
		logger.info("Entered Password");
		accountCreate.enterAddfName("Mayank");
		logger.info("Entered Address First Name");
		accountCreate.enterAddlName("Kaushik"); 
		logger.info("Entered Address Last Name");
		accountCreate.enterAddress("House No 121 b , New Jersey");
		logger.info("Entered Address");
		accountCreate.enterCity("New Jersey");
		logger.info("Entered City");
		accountCreate.enterCountry("United States");
		logger.info("Entered Country");
		accountCreate.enterState("New Jersey");
		logger.info("Entered State");
		accountCreate.enterPostalCode("07015");
		logger.info("Entered Postal Code");
		accountCreate.enterMobile("8686869988");
		logger.info("Entered Mobiel Number");
		accountCreate.enterAliasAdd("House no 121b , New Jersey");
		logger.info("Entered Alias Address");
		accountCreate.clickOnRegister();
		logger.info("Clicked on Register Button");
		MyAccountPage registereduser = new MyAccountPage(driver);
		String registeredusername = registereduser.getUserName();
		// Verification for logged in user 
		Assert.assertEquals("Mayank Kaushik",registeredusername );
		logger.info("Username is verified");
	}
	// Test case -2
	@Test( enabled =false)
	public void verifyLogin() throws IOException {
		logger.info("Verifiying Login test execution started");
		indexPage ipage = new indexPage(driver);
		ipage.clickOnSignBtn(); 
		logger.info("Clicked on the sign in button");
		LoginPage loginpg = new LoginPage(driver);
		loginpg.enterregisteredEmail("kaka212021@gmail.com");
		logger.info("Entered registered email address");
		loginpg.enterregisteredpassword("Kaka212021");
		logger.info("Entered registered user password");
		loginpg.submitLoginBtn();
		logger.info("Clicked on Login Button");
		MyAccountPage registereduser = new MyAccountPage(driver);
		String registeredusername = registereduser.getUserName();
		// Verification for logged in user 
		if(registeredusername.equals("Mayank Kaushik"))
		 {
			logger.info("Verification LogIN :Passed"); 
			Assert.assertTrue(true);

		}
		else {
			logger.info("Verification  LogIn :Failed");
			captureScreenShot(driver ,"verifyLogin");
			Assert.assertTrue(false);

		}
	}
	@Test
	public void verifySignOut() throws IOException {
		logger.info("Verfiying signout test execution started");
		indexPage ipage = new indexPage(driver);
		ipage.clickOnSignBtn(); 
		logger.info("Clicked on the sign in button");
		LoginPage loginpg = new LoginPage(driver);
		loginpg.enterregisteredEmail("kaka212021@gmail.com");
		logger.info("Entered registered email address");
		loginpg.enterregisteredpassword("Kaka212021");
		logger.info("Entered registered user password");
		loginpg.submitLoginBtn();
		logger.info("Clicked on Login Button");
		MyAccountPage registereduser = new MyAccountPage(driver);
		registereduser.clickOnSignOutBtn();
		logger.info("Clicked on Sign out Button");
	    
		// Verification for sign out 
		if(ipage.getPageTitle().equals("Login - My Store")) {
			logger.info("Verification SignOut :Passed"); 
			Assert.assertTrue(true);

		}
		else {
			logger.info("Verification SignOut :Failed");
			captureScreenShot(driver ,"verifySignOut()");
			Assert.assertTrue(false);

		}
	}
	
		
	}




