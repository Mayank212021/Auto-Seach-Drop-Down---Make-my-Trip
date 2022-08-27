package com.myproject1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderConfirmationPage {

	WebDriver ldriver;

	public orderConfirmationPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
	WebElement confirmOrder;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[1]")
	WebElement orderplacedmsg;  
	@FindBy(linkText= "Sign out")
	WebElement signOut;
	
	
	public void clickonConfirmOrder() {
		confirmOrder.click();
	}
	
	public String getOrderSuccessMsg() {
		return(orderplacedmsg.getText());
	}
	public void  clickOnSignOutBtn() {
		signOut.click();
}
}
