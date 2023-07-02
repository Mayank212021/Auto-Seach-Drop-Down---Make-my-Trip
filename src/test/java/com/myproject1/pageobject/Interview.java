package com.myproject1.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class Interview {

	WebDriver ldriver;

	public Interview(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
   // Hard Assertion
	@FindBy(name = "q")
	WebElement searchbox;

	public void enterText(String text) {

		searchbox.sendKeys(text, Keys.ENTER);

	}
	
	
	//SoftAssertion on Facebook page
	
	@FindBy(name="email")
	WebElement emailaddress;
	public void enterEmail(String text) {

		emailaddress.sendKeys(text, Keys.ENTER);

	}
	
	@FindBy(name ="login")
	WebElement loginButton;
	public void clickOnLogin() {

		loginButton.click();   
		

	}
	
	//Calendar handle makemytrip.com
	
	@FindBy(xpath = "//span[contains(.,'Departure')]")
	WebElement  openDepCalendar;
	public void openDepartureCalendar() {

		openDepCalendar.click();   
	}
	
	@FindBy(xpath ="//div[@aria-label='Sat Jul 15 2023']")
	WebElement departureDate;
	
	public void selectDepartureDate() {

		departureDate.click();  
		
	}
	
	@FindBy(xpath = "//span[@aria-label='Next Month']")
	WebElement arrow;
	
	public void clickOnarrow() {

		arrow.click();  
			
	}
	@FindBy(xpath = "//span[contains(text(), 'Return')]")	
	WebElement openRetCalendar;
	public void openReturnCalendar() {

		openRetCalendar.click();   
	}
	
	
	
	@FindBy(xpath ="//div[@aria-label='Wed Nov 15 2023']")
	WebElement returnDate;
	
	public void selectReturnDate() {

		returnDate.click();  
		
	}
	
	
	
	//AutoSearch drop down in makemytrip
	
	@FindBy(xpath = "//span[normalize-space()='From']")
	WebElement from;
	public void clickOnFrom() {
		
		from.click();
	}
	
	
	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement fromCity;
	
	public void selectFromCity(String city) {

		fromCity.sendKeys(city ,Keys.ENTER);  
		
	}
	
	
	// Drop Down handle by Select Class on Portolo QA
	
	@FindBy(xpath ="//a[@class='brdr-1 save-btn']")
	WebElement signButton;

	@FindBy(id="Portolo_id_username")
	WebElement emailadd;
	
	@FindBy(id="id_password")
	WebElement passWord;
	
	@FindBy(id="login")
	WebElement signInButton;
	
	@FindBy(xpath = "//a[normalize-space()='My Pages']")
	WebElement myPagesMenu;
	
	@FindBy(xpath = "//a[normalize-space()='My Profile']")
	WebElement myProfileOption;
	
	
	@FindBy(id="Country")
	WebElement countries;
	
	@FindBy(id="Timezone")
	WebElement timeZone;
	
	@FindBy(id = "Saveid")
	WebElement saveButton;
	
	
	//Window handle on  ToolsQA https://demoqa.com/browser-windows
	
	@FindBy(id = "windowButton")
	WebElement newWindowButton1;
	
	@FindBy(id="sampleHeading")
	WebElement childwindowText;
	
	
	//StaleElementReferenceException on https://omayo.blogspot.com/
	@FindBy(id="ta1")
	WebElement textBox;
	
	@FindBy(linkText ="compendiumdev")
	WebElement link;
	
	
	
	
	
	
	
	
	
	// Actions Methods
	
	 public void clickonSignButton() {
		   signButton.click();
	   }
	
	public void enterEmailAddress(String text) {

		emailadd.sendKeys(text, Keys.ENTER);

	}
	
	public void enterPassword(String text) {
		passWord.sendKeys(text , Keys.TAB);
	}
	
   public void clickonSignIn() {
	   signInButton.click();
   }
	
   public void clickonMyPages() {
	   myPagesMenu.click();
	   
   }
   
   public void clickonMyProfile() {
	   myProfileOption.click();
	   
   }
	
   public void selectCountry(String country) {
		countries.click();
		Select select = new Select(countries);
		select.selectByVisibleText(country);
		
	}
	
   public void selectTimeZone(String zone) {
		timeZone.click();
		Select select = new Select(timeZone);
		select.selectByVisibleText(zone);
		
	}
   public void clickonSaveButton() {
	   saveButton.click();
	   
   }
   
   
 //Window handle on  ToolsQA https://demoqa.com/browser-windows
   
   public void clickonNewWindowButton() {
	   newWindowButton1.click();
	   
   }
   
   public String getTextofChildWindow() {
	   String text = childwindowText.getText();
	   return text;
	   
   }
   
   
   
	//StaleElementReferenceException on https://omayo.blogspot.com/
   
   public void enterText1(String text){
	   textBox.sendKeys(text);
	   
   }
   
   public void clearText1(){
	   textBox.clear();
	   
   }

   public void clickonLink(){
	   link.click();
	   
   }
}
