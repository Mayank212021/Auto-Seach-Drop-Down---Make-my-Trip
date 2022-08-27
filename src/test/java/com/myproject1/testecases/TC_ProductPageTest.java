package com.myproject1.testecases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.myproject1.pageobject.LoginPage;
import com.myproject1.pageobject.MyAccountPage;
import com.myproject1.pageobject.indexPage;
import com.myproject1.pageobject.orderAddressPage;
import com.myproject1.pageobject.orderConfirmationPage;
import com.myproject1.pageobject.orderPaymentPage;
import com.myproject1.pageobject.orderShippingPage;
import com.myproject1.pageobject.orderSummaryPage;
import com.myproject1.pageobject.productPage; 
import com.myproject1.utilities.readExcelFile;

public class TC_ProductPageTest extends baseClass {

	/*
	 // Test case 01
	@Test(dataProvider = "loginDataProvider")
	public void verifysearchProduct(String uEmail , String uPass , String expUName ) throws IOException {
		logger.info("-----------------Verfiying search product test case started-----------------");
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
			// registereduser.clickOnSignOutBtn();
		}
		else {
			logger.info("Verification Login :Failed");
			captureScreenShot(driver ,"verifysearchProduct");
			Assert.assertTrue(false); 

		}
		searchResultPage sign = new searchResultPage(driver);
	//Enter search text in the search box
		registereduser.enterDataInSearchBox("T-shirts");
		logger.info("Entered the T-shirts in the search box");
		registereduser.clickOnSearchBtn();
		logger.info("Clicked on the search button");
	// Fetching text	
		searchResultPage resultPg = new searchResultPage(driver);
		String searchResultProdName = resultPg.getSearchedProd();
		if(searchResultProdName.contains("T-shirts"))
		{
			logger.info("Searched Product Testcase :Passed"); 	
			Assert.assertTrue(true);
			sign.clickOnSignOutBtn();
			logger.info("Clicked on signout button");
		}
		else {
			logger.info("Searched Product Testcase :Failed");
			captureScreenShot(driver ,"verifysearchProduct");
			Assert.assertTrue(false); 

		}	
		logger.info("-----------------Verifying search product test case execution ended-----------------"); 
	}  
	 */
    
	
	
	//Test case 02
	@Test(dataProvider = "loginDataProvider")
	public void verifyBuyProduct(String uEmail , String uPass , String expUName) throws IOException, InterruptedException {
		logger.info("-----------------Verfiying Buy product test execution started-----------------");
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
			// registereduser.clickOnSignOutBtn();
		}
		else {
			logger.info("Verification Login :Failed");
			captureScreenShot(driver ,"verifysearchProduct");
			Assert.assertTrue(false); 

		}
		//searchResultPage sign = new searchResultPage(driver);
		//Enter search text in the search box
		registereduser.enterDataInSearchBox("T-shirts");
		logger.info("Entered the T-shirts in the search box");
		registereduser.clickOnSearchBtn();
		logger.info("Clicked on the search button");
		// Fetching text	
		productPage prodPg1 = new productPage(driver);
		prodPg1.mouseOverOnTshirtProduct();
		prodPg1.clickOnMoreBtn();
		logger.info("Clicked on the More button");
		try { 
			Thread.sleep(5000);

		}catch(Exception e)
		{
			System.out.println("*****Search is taking more time********"); 

		}

		//productPage prodPg1 = new productPage(driver);
		prodPg1.setQuantity("2");
		logger.info("Entered the 2 quantities");

		prodPg1.setSize("M");
		logger.info("Size M is selected");

		prodPg1.clickOnAddtoCart();
		logger.info("Clicked on Add to cart button");
		prodPg1.clickOnProceedtoCheckOut();
		logger.info("Clicked on Proceed to Checkout button on product page");
		orderSummaryPage orderSumm = new orderSummaryPage(driver);
		orderSumm.clickOnProceedtoCheckOut();
		logger.info("Clicked on Proceed to Checkout button on order summary page");
		
		Thread.sleep(2000);
		orderAddressPage orderAdd = new orderAddressPage(driver);
		orderAdd.clickOnProceedtoCheckOut();
		logger.info("Clicked on Proceed to Checkout button on address tab");
		orderShippingPage orderShipping = new orderShippingPage(driver);
		orderShipping.acceptTOC();
		logger.info("Clicked on T&C checkbox");
		orderShipping.clickOnProceedtoCheckOut();
		logger.info("Clicked on Proceed to Checkout button order shipping page");

		orderPaymentPage orderPay = new orderPaymentPage(driver);
		orderPay.clickOnPayByCheque();
		logger.info("Clicked on pay be cheque");

		orderConfirmationPage orderConfirm = new orderConfirmationPage(driver);
		orderConfirm.clickonConfirmOrder();
		logger.info("Clicked on confirm order button");

		String successMsg =	orderConfirm.getOrderSuccessMsg();
		if(successMsg.equals("Your order on My Store is complete.")){

			logger.info(" Buy Product Test Case : Passed");
			Assert.assertTrue(true);
			orderConfirm.clickOnSignOutBtn();
		}
		else
		{
			logger.info(" Buy Product Test Case : Failed");
			captureScreenShot(driver ,"verifyBuyProduct");
			Assert.assertTrue(false); 

		}
		logger.info("-----------------Verfiying Buy Product test execution ended-----------------");	


	}
	
	
	//Test Case 03
	@Test(enabled  = false)
	public void verifyAddToWishList() throws IOException {
		logger.info("-----------------Verfiying  Product add to wish list test execution started-----------------");	
		indexPage ipage = new indexPage(driver);
		ipage.clickOnTshirtMenu();
		productPage prodPg1 = new productPage(driver); 
		prodPg1.mouseOverOnTshirtProduct();
		prodPg1.clickOnAddToWishList();
		String actualAlertMsg=	prodPg1.getTextofAlertWishList();
		String expectedAlertMsg = "You must be logged in to manage your wishlist.";
		if(actualAlertMsg.equals(expectedAlertMsg)) {
			
			logger.info("Alert is working fine");
			Assert.assertTrue(true);
			
		}
		else {
			logger.info("*******Alert is not working fine*******");
			captureScreenShot(driver ,"verifyAddToWishList");
			Assert.assertTrue(false);
		}


		logger.info("-----------------Verfiying  Product add to wish list test execution ended-----------------");	


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
