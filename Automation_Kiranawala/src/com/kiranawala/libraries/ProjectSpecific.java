package com.kiranawala.libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ProjectSpecific extends SuperTestNG
{
	public static void createUserAccount(String userName)
	{
	
		driver.findElement(By.id("email_create")).sendKeys(userName);
        driver.findElement(By.id("SubmitCreate")).click();
    }
	
	public static void mandatoryFields(String firstName, String lastName, String password, String address, double pincode,String city, double mobile , String alias,double day,double month, double year)
	{
		
		String pincode1 = Integer.toString((int)pincode);
		String mobile1 = Long.toString((long)mobile);
		
		String day1 = Integer.toString((int)day);
		String month1 = Integer.toString((int)month);
		String year1 = Integer.toString((int)year);
		

		driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("address1")).sendKeys(address);
        driver.findElement(By.id("postcode")).sendKeys(pincode1);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("phone_mobile")).sendKeys(mobile1);
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys(alias);
        try
		{   driver.findElement(By.id("id_gender2")).click();
			Thread.sleep(1000);
	//	WebElement days=driver.findElement(By.id("days"));
        Select select = new Select(driver.findElement(By.id("days")));
        Thread.sleep(2000);
        select.selectByValue(day1);
        //days.sendKeys(Keys.RETURN);
		}catch(Exception e)
		{
			Reporter.log("wait");
		}
        
		driver.findElement(By.id("months")).click();
		try
		{
			Thread.sleep(5000);
        
        WebElement months = driver.findElement(By.id("months"));
        Select select1 = new Select(driver.findElement(By.id("months")));
      
        Thread.sleep(2000);
        select1.selectByValue(month1);
        months.sendKeys(Keys.RETURN);
		}
        catch(Exception e)
		{
			Reporter.log("wait");
		}
        
        
		driver.findElement(By.id("years")).click();
        try
		{
			Thread.sleep(2000);
        
        WebElement years = driver.findElement(By.id("years"));
        Select select2= new Select(driver.findElement(By.id("years")));
        Thread.sleep(5000);
        select2.selectByValue(year1);
        years.sendKeys(Keys.RETURN);
        }
        catch(Exception e)
		{
			Reporter.log("wait");
		}
        
        Select select2= new Select(driver.findElement(By.id("id_state")));
        select2.selectByValue("53");
       
	}
	
	
	
	public static void optionalFields(String company, String address2, String other, double phone, String refpgm)
	{
		String phone1 = Long.toString((long)phone);
 
        
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("address2")).sendKeys(address2);
        driver.findElement(By.id("other")).sendKeys(other);
      //  driver.findElement(By.id("phone")).clear();
       driver.findElement(By.id("phone")).sendKeys(phone1);
        driver.findElement(By.id("referralprogram")).sendKeys(refpgm);
		
	}

	
	
	public static void submit()
	{
	driver.findElement(By.id("submitAccount")).click();
	}
		
	public static void login(String userName, String password)
	{
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();	
	}

	public static void logout()
	{
		try
		{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title = 'Log me out']")).click();
		}
		catch(Exception e)
		{
			Reporter.log("wait");
		}
	}

    public static void verifySuccesMsg(String eMsg)
    {
    	String aMsg= driver.findElement(By.xpath("//div[3]/div[2]/div[2]/p")).getText();
    	Assert.assertEquals(aMsg, eMsg);
    	Reporter.log(aMsg,true);
    }
    
}

