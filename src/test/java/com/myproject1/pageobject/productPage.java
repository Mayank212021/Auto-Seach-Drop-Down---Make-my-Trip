package com.myproject1.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class productPage {
	WebDriver ldriver;

	public productPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);   //
	}
	

	@FindBy(id= "quantity_wanted")
	WebElement quanWanted;

	@FindBy(id="group_1")
	WebElement size;

	@FindBy(name ="Submit")
	WebElement addCart;
	
	@FindBy(linkText="Proceed to checkout")
	WebElement proceed;
	
	@FindBy(linkText= "More")
	WebElement more;

	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement tshirtProduct;
	
	@FindBy(xpath="//a[@class='addToWishlist wishlishProd_1]")
	WebElement  addToWishList;
	
	@FindBy(xpath="//p[@class='fancybox-error']")
	WebElement  alertforAddToWishList;
	
//Actions methods
	
	public void setQuantity(String qty)
	{
		quanWanted.clear();
		quanWanted.sendKeys(qty);
	}
	public void setSize(String sizeType)
	{
		Select select = new Select(size);
		select.selectByVisibleText(sizeType);
		
	}
	
	public void clickOnAddtoCart() 
	{
		
		addCart.click();
		
	}
	public void clickOnProceedtoCheckOut() 
	{
		
		proceed.click();   
		
	}
	
	public void  clickOnMoreBtn() {
		more.click();
	}

	public void mouseOverOnTshirtProduct() 
	{
		
		Actions action = new Actions(ldriver);  
		action.moveToElement(tshirtProduct).build().perform();
		
	}
	public void clickOnAddToWishList() 
	{
		
		addToWishList.click();   
		
	}
	
	public String getTextofAlertWishList() 
	{
		
		return(alertforAddToWishList.getText());   
		
	}
	
	
}
