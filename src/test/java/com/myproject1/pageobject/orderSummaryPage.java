package com.myproject1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderSummaryPage {
	WebDriver ldriver;

	public orderSummaryPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath ="(//i[@class='icon-chevron-right right'])[3]")
	WebElement proceed;

	//Action method
	public void clickOnProceedtoCheckOut() 
	{
		proceed.click();   

	}


}
