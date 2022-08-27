package com.myproject1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderShippingPage {

	WebDriver ldriver;

	public orderShippingPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "cgv")
	WebElement TOC;
	
	@FindBy(xpath = "//button[@class='button btn btn-default standard-checkout button-medium']")
	WebElement proceedShipping;

	//Action method
	public void clickOnProceedtoCheckOut() 
	{
		proceedShipping.click();   

	}
	public void acceptTOC() 
	{
		TOC.click();   

	}

}


