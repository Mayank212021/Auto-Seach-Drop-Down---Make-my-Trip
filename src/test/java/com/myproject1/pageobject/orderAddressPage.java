package com.myproject1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderAddressPage {
	
	WebDriver ldriver;

	public orderAddressPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//button[@class = 'button btn btn-default button-medium']")
	WebElement proceed;

	//Action method
	public void clickOnProceedtoCheckOut() 
	{
		proceed.click();   

		
	}


}


