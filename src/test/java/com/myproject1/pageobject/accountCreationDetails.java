package com.myproject1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails {

	WebDriver ldriver;

	public  accountCreationDetails(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Select title Mr
	@FindBy(name = "id_gender")
	WebElement userTitle;
	@FindBy(id= "customer_firstname")
	WebElement userfName;
	@FindBy(id= "customer_lastname")
	WebElement userlName;
	@FindBy(id= "passwd")
	WebElement userPass;
	@FindBy(id= "firstname")
	WebElement fNameAdd;
	@FindBy(id= "lastname")
	WebElement lNameAdd;
	@FindBy(id= "address1")
	WebElement userAddress;
	@FindBy(id= "city")
	WebElement userCity;
	@FindBy(id= "id_state")
	WebElement userState;
	@FindBy(id= "postcode")
	WebElement userPostcode; 
	@FindBy(id= "id_country")
	WebElement userCountry;
	@FindBy(id= "phone_mobile")
	WebElement userMobile;
	@FindBy(id= "alias")
	WebElement userAliasAdd;
	//submitAccount
	@FindBy(id= "submitAccount")
	WebElement registerBtn;


	// Actions methos on the web elements
	public void selectTitle() {
		userTitle.click();

	}
	public void enterFirstName(String fName) {
		userfName.sendKeys(fName);
	}
	public void enterLastName(String lName) {
		userlName.sendKeys(lName);

	}
	public void enterPass(String upass) {
		userPass.sendKeys(upass);

	}
	public void enterAddfName(String addfName) {
		fNameAdd.clear();
		fNameAdd.sendKeys(addfName);

	}
	public void enterAddlName(String addlName) {
		lNameAdd.clear();
		lNameAdd.sendKeys(addlName);

	}
	public void enterAddress(String userAdd) {
		userAddress.sendKeys(userAdd);

	}
	public void enterCity(String city) {
		userCity.sendKeys(city);

	}
	// state is drop down ,so we will use select class 
	public void enterState(String state) {

		Select obj = new Select(userState);
		obj.selectByVisibleText(state);

	}
	public void enterPostalCode(String code) {
		userPostcode.sendKeys(code);

	}
	public void enterCountry(String country) {

		Select obj = new Select(userCountry);
		obj.selectByVisibleText(country);

	}
	public void enterMobile(String mobile) {
		userMobile.sendKeys(mobile);

	}	
	public void enterAliasAdd(String aliasadd) {
		userAliasAdd.clear();
		userAliasAdd.sendKeys(aliasadd);

	}
	public void clickOnRegister() {
		registerBtn.click();

	}
}
