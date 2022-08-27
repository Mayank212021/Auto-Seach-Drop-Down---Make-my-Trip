package com.myproject1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderPaymentPage {

	WebDriver ldriver;

	public orderPaymentPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(className = "cheque")
	WebElement payByCheque;
	@FindBy(className = "bakwire")
	WebElement payByBankWire;
	
	
	//Action method
	public void clickOnPayByCheque()
	{
		payByCheque.click();
	}
	public void clickOnPayByBankWire()
	{
		payByBankWire.click();
	}
	
}
