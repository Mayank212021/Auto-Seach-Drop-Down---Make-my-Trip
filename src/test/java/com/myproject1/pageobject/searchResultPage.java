package com.myproject1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchResultPage {

	WebDriver ldriver;

	public searchResultPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts'][normalize-space()='Faded Short Sleeve T-shirts']")
	WebElement searchResultProd;
	@FindBy(linkText= "Sign out")
	WebElement signOut;

	//Action method

	public String getSearchedProd() {

		return(searchResultProd.getText());

	}

	public void  clickOnSignOutBtn() {
		signOut.click();
	}

}



