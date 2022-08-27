package com.myproject1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	WebDriver ldriver;

	public indexPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Click on sign in button on the page , but this is link because start with
	// anchor tag.
	@FindBy(linkText = "Sign in")
	WebElement signin;
	
	
	@FindBy(xpath = "(//a[@title='T-shirts'][1])[2]")
	WebElement tshirtsMenu;
	
	public void clickOnSignBtn() {

		signin.click();
	}
	
	public String getPageTitle() {
		
		return(ldriver.getTitle());
	}
	public void clickOnTshirtMenu() {
		
		tshirtsMenu.click();
	}

}
