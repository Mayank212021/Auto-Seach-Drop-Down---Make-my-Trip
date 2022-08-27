package com.myproject1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver ldriver;
	public MyAccountPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement myAccountName;

	@FindBy(linkText= "Sign out")
	WebElement signOut;
	
	@FindBy(name = "search_query")
	WebElement searchBox;
	@FindBy(name = "submit_search")
	WebElement submitSearch;
	@FindBy(linkText= "Women")
	WebElement womenMenu;
	@FindBy(linkText= "T-shirts")
	WebElement tshirtMenu;
	
	
	
	// method for getting the text 
	public String getUserName() {
		String text = myAccountName.getText();
		return text;
	}

	public void  clickOnSignOutBtn() {
          signOut.click();
	}

   public void enterDataInSearchBox(String searchKey)
   {
	   searchBox.sendKeys(searchKey);
   }
   public void clickOnSearchBtn()
   {
	   submitSearch.click();
   }
}
