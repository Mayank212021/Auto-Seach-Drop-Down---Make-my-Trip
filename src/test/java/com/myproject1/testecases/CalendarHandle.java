package com.myproject1.testecases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.myproject1.pageobject.Interview;

public class CalendarHandle extends baseClass {
	
	@Test
	public void calendarhandle() {
		
		
		//Select Departure Date on Make My Trip
		Interview interview = new Interview(driver);
		logger.info("Calendar Handling");
		interview.openDepartureCalendar();
		logger.info(" Departure Calendar opened");
		
	
		// Press arrow if departure date does not match 15 july
		String flag = "False";
		while(flag == "False")
		{
			if(driver.findElements(By.xpath("//div[@aria-label='Sat Jul 15 2023']")).size()>0) {
				
				interview.selectDepartureDate();
				flag = "True";
				logger.info(" Jul 15 selected");
			}
			
			else {
				
			interview.clickOnarrow();
			logger.info(" Arrow clicked");
			}
			
		}
		
		// Select Return Date
		
		interview.openReturnCalendar();
		logger.info(" Return Calendar opened");
		
		String flag1 = "False";
		while(flag1 == "False")
		{
             if(driver.findElements(By.xpath("//div[@aria-label='Wed Nov 15 2023']")).size()>0) {
				
				interview.selectReturnDate();
				flag1 = "True";
				logger.info(" Nov 15 selected");
			}
			
			else {
				
			interview.clickOnarrow();
			logger.info(" Arrow clicked");
			}
			
			
		}
			
		
		
		
		
	}

}
