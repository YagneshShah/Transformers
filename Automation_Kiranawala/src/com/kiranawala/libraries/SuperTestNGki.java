package com.kiranawala.libraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SuperTestNGki
{
      	  
	public static WebDriver driver;
	
	@ BeforeMethod (groups={"all"})

	public void preCondition()
	{
		String xlpath ="./excelfiles/config.xlsx";
		String sheetName = "sheet1";
		String browser = Generic.getXlCellValue(xlpath,sheetName,0,1);
		
		if(browser.equals("GC"))
		{
			String chromepath = "./exefiles/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromepath); 
			driver = new ChromeDriver();
			Reporter.log("OPening chrome browser");
           
		}
		else if(browser.equals("IE"))
		{
			String ie_path = "./exefiles/IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", ie_path);
			driver= new InternetExplorerDriver();
			
		}
		else
		{
			driver = new FirefoxDriver();
			Reporter.log ("Opening Mozilla Firefox Browser",true);
		}
		
	driver.manage().window().maximize();		
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	String url = Generic.getXlCellValue(xlpath, sheetName, 1, 1);
	driver.get(url);
	Reporter.log("Navigating to URL: "+url,true);
	
	}
	
	@ AfterMethod (groups={"all"})
	public void postCondition()
	{
	    driver.quit();
	    Reporter.log("Closing the Browser",true);
	}
	
   }	
	

