package com.myproject1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	// For new user
	@FindBy(id = "email_create")
	WebElement emailid;
	@FindBy(id = "SubmitCreate")
	WebElement submitCreate;

	//Already registered users
	@FindBy(id = "email")
	WebElement registereduseremailid;
	@FindBy(id = "passwd")
	WebElement registereduserpassword;
	@FindBy(id = "SubmitLogin")
	WebElement submitLogin;

	// Actions method for new users
	public void enterEmail(String email) {
		emailid.sendKeys(email);
	}

	public void submit() {
		submitCreate.click();

	}
	// Actions method for registered users	
	public void enterregisteredEmail(String email) {
		registereduseremailid.sendKeys(email);
	}
	public void enterregisteredpassword(String pwd) {
		registereduserpassword.sendKeys(pwd);
	}
	public void submitLoginBtn() {
		submitLogin.click();
	}

}
