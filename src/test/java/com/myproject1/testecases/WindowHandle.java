package com.myproject1.testecases;

import java.util.Set;

import org.testng.annotations.Test;

import com.myproject1.pageobject.Interview;



public class WindowHandle extends baseClass{
	
	@Test
	public void windowHandle() throws InterruptedException {
		
		Interview interview = new Interview(driver);
		interview.clickonNewWindowButton();
		String parentWindow = driver.getWindowHandle();
		Set<String> childwindows = driver.getWindowHandles();
		
		for(String wind : childwindows) {
			
			driver.switchTo().window(wind);
			if(driver.getTitle().equals("")) {
				
				driver.manage().window().maximize();
				Thread.sleep(3000);
		String childtext =	interview.getTextofChildWindow();
		System.out.println(childtext);
		driver.close();
				
			}
			
		}
		
		driver.switchTo().window(parentWindow);
		String parentTitle = driver.getTitle();
		System.out.println(parentTitle);
		
	}
}