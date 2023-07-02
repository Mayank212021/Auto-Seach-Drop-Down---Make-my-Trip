package com.myproject1.testecases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.myproject1.pageobject.Interview;

public class AutosearchDropDown extends baseClass{
	
	@Test
	public void autoSearch() throws InterruptedException {
		
		Interview interview = new Interview(driver);
		logger.info("Verifying autosuggestion");
		interview.clickOnFrom();
		logger.info("Clicked on From");
		
		interview.selectFromCity("De");
		Thread.sleep(5000);
		logger.info("De entered in the field box");
		List<WebElement>  lists = driver.findElements(By.xpath("//ul[contains(@role,'listbox')]/li"));
		System.out.println("Total number:" + lists.size());
		
		for(WebElement list : lists){
		    
			System.out.println(list);
			if(list.getText().equals("Dehradun, India")) {
				list.click();
				break;
			}
			
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
