package com.myproject1.testecases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myproject1.pageobject.accountCreationDetails;
import com.myproject1.pageobject.indexPage;
import com.myproject1.utilities.readExcelFile;
import com.myproject1.pageobject.LoginPage;
import com.myproject1.pageobject.MyAccountPage;

public class TC_MyAccountPage_Datadriven extends baseClass {
	// Test case -1
	@Test(enabled = false)  // disable the test case
	public void verifyRegistrationAndLogin() {


		indexPage ipage = new indexPage(driver);
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
	@Test(dataProvider = "loginDataProvider")
	public void verifyLogin(String uEmail , String uPass , String expUName ) throws IOException {
		logger.info("Verfiying Login test execution started");
		indexPage ipage = new indexPage(driver);
		ipage.clickOnSignBtn();
		logger.info("Clicked on the sign in button");
		LoginPage loginpg = new LoginPage(driver);
		loginpg.enterregisteredEmail(uEmail);
		logger.info("Entered registered email address");
		loginpg.enterregisteredpassword(uPass);
		logger.info("Entered registered user password");
		loginpg.submitLoginBtn();
		logger.info("Clicked on Login Button");
		MyAccountPage registereduser = new MyAccountPage(driver);
		String registeredusername = registereduser.getUserName();
		// Verification for logged in user 
		if(registeredusername.equals(expUName)) {
			logger.info("Verification Login :Passed"); 
			Assert.assertTrue(true);
			registereduser.clickOnSignOutBtn();
		}
		else {
			logger.info("Verification Login :Failed");
			captureScreenShot(driver ,"verifyLogin");
			Assert.assertTrue(false); 

		}

	}
	//Data provider always return two dimensional object
	@DataProvider(name ="loginDataProvider") // To know this method is data provider method
	public String[][] loginDataProvider() {
		//storing the path of the excel file
		String fileName = System.getProperty("user.dir")+ "\\TestData\\MyProject1_Data.xlsx";

		int ttlRows = readExcelFile.getRowCount(fileName, "VerifyLogin" );
		int ttlColumns = readExcelFile.getColCount(fileName, "VerifyLogin");
		String data[][] = new String[ttlRows-1][ttlColumns];

		for(int i=1; i<ttlRows; i++) //Rows count
		{
			for (int j=0;j<ttlColumns;j++) {

				data[i-1][j]   =readExcelFile.getCellValue(fileName, "VerifyLogin",i, j);

			}
 
		}
      return data;

	}

}
