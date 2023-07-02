package com.myproject1.testecases;



import org.testng.annotations.Test;

import com.myproject1.pageobject.Interview;

public class StaleElementReferenceException extends baseClass {
	
	@Test
	public void staleElementException() throws InterruptedException  {
		
		Interview interview = new Interview(driver);
		interview.enterText1("This is my Text Test");
		logger.info("Text entered in text box");
		
		interview.clickonLink();
		logger.info("Clicked on link");
	
		driver.navigate().back();
		logger.info("Back to home page");
		Thread.sleep(3000);
		
		interview.clearText1();
		logger.info("Text cleared");
		Thread.sleep(3000);
	
			
			
		}
		
		


}
