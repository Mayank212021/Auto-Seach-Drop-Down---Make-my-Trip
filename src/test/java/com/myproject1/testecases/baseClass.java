package com.myproject1.testecases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.myproject1.utilities.readConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	readConfig  readconfig = new readConfig();
	String URL =  readconfig.getbaseURL();
	String Browser = readconfig.getBroswer();
	//String emailAddress = readconfig.getEmail();
 //	String passWord = readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() {
		
		switch(Browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;	
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
	// maximize window 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// Logging
	logger = LogManager.getLogger("MyProject1");	
	
	//open URL
			driver.get(URL);
			logger.info("URL is opened");
			
	}
	
	//Capture screenshot method which is common to all test cases
     public void captureScreenShot(WebDriver driver , String testname) throws IOException
     {
    	//Step1 : convert webdriver object to the TakesScreenshot interface Typecasting
    	 TakesScreenshot screenshot = ((TakesScreenshot)driver);
    	 // Step 2 : call getScreenshotAs method to create image file
    	 File src = screenshot.getScreenshotAs(OutputType.FILE);
    	 File destination = new File(System.getProperty("user.dir") + "\\Screenshots\\" + testname + ".png");
    	 //Step 3: copy image file into destination
    	 FileUtils.copyFile(src, destination);    	 
    	 
     }
	//Tear down method for close and quit the browser.
	@AfterClass
	public void teardown() {
		
		driver.close();
		driver.quit();
	}
	
}
