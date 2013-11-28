


// Author :: Bhimraj Gupta (Team: Transformers )
// Formatted Date :: 31 May 2013
// System Info :: Firefox web browser, Selenium Webdriver
// Aim    ::  To check for various "Delivery charges" for the third party based on the varying pincodes
//            in Flipkart.
//  		  "Third party's delivery charges vary according to the pincodes on the basis of Local,
//             Zonal and National proximity, check the different delivery charges in the shopping cart for 
//             different pincodes"
// Need for Automation :: Confirming the consistency in the delivery charges for various locations.
// Future Upgrades applicable :: This script can be upgraded for reliability testing, 
// by adding more no. of locations and checking for the consistency of the charges.*/

/* Approach :: Here we are checking the delivery charges of various location of Bangalore by changing
 *             the pin codes and taking a note of the various delivery charges.
 *             This script has been completed with the use of "Page object orientation, which would 
 *             be clear and easy for the stakeholders to go through
			   scripts and understand what is exactly happening while the script is running." 
            PageObject basically consists of two scripts.
			1) The main script (FlipkartDeliveryTest.java) is the one in which we call the method from
			   the other scripts where the pageObjects has been created.
			2) The other script (Delivery.java) is the one where we create objects for every action we
			   perform and call it through different methods.  */

// This script is "Delivery.java"


package com.flipkartpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Delivery 
{
	private WebDriver driver;
	String q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12;
	// strings is a collection of variables (in technical terms), used to store the data.
	
	public  Delivery(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// Here we are locating each element by different ways say xpath, name, id etc and creating an object.
	
	// Select any item from the Flipkart list.
    // Say we choose laptops & accessories
	
	@FindBy(linkText="Laptops & Accessories")
	private WebElement item;
	
	//selecting an item which has more than one seller.
	
	@FindBy(linkText="WD My Passport 1 TB External Hard Disk")
	private WebElement product;
	@FindBy(linkText="View all Sellers (6) »")
	private WebElement sellers;
	@FindBy(name="pincode")
	private WebElement pin;
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[3]/div/div[1]/form/input[2]")
	private WebElement check;
	
	//Locating various sellers & the charges charged by them.
	
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[3]/div[4]/a")
	private WebElement seller;
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[3]/div[1]")
	private WebElement price;
	
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[4]/div[4]/a")
	private WebElement seller2;
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[4]/div[1]")
	private WebElement price2;
	
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[5]/div[4]/a")
	private WebElement seller3;
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[5]/div[1]")
	private WebElement price3;
	
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[7]/div[4]/a")
	private WebElement seller4;
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[7]/div[1]")
	private WebElement price4;
	
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[8]/div[4]/a")
	private WebElement seller5;
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[8]/div[1]")
	private WebElement price5;
	
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[6]/div[4]/a")
	private WebElement seller6;
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[4]/div[1]/div/div[6]/div[4]/a")
	private WebElement price6;
	
	@FindBy(xpath=".//*[@id='fk-mainbody-id']/div/div[3]/div/div[2]/a")
	private WebElement pinchange;
	
	// Fetching the seller & price information & displaying on the console.
	
	public void info()
	{		
		q1=seller.getText();
		q2=price.getText();
		System.out.println("\n"+ q1 + "\t"+q2);
		
		q3=seller2.getText();
		q4=price2.getText();
		System.out.println("\n"+ q3 +"\t"+ q4);
		
		q5=seller3.getText();
		q6=price3.getText();
		System.out.println("\n"+ q5 +"\t"+ q6);
		
		q7=seller4.getText();
		q8=price4.getText();
		System.out.println("\n"+ q7 +"\t"+ q8);
		
		q9=seller5.getText();
		q10=price5.getText();
		System.out.println("\n"+q9 + "\t"+ q10);
		
		q11=seller6.getText();
		q12=price6.getText();
		System.out.println( "\n"+q11 + "\t"+  q12);
	}
	
	
	//Checking the delivery charges for one location.
	public void pin() throws InterruptedException
	{
		pin.click();
		Thread.sleep(2000);
		pin.clear();
		Thread.sleep(2000);
		pin.sendKeys("560068");
		Thread.sleep(2000);
		check.click();
	}
	
	// Checking the delivery charges for another location, by changing the pin code.
	public void pin1() throws InterruptedException
	{
		pinchange.click();
		Thread.sleep(2000);
		pin.click();
		pin.clear();
		Thread.sleep(2000);
		pin.sendKeys("560004");
		Thread.sleep(2000);
		check.click();
	}
	
	//Selecting an item.
	public void item()
	{
		item.click();
		product.click();
		sellers.click();
	}
	
	//Method to initiate the browser.
	public void getURL(String string)
	{
		driver.get(string);
	}
	
	//Method to close the current window.
	public void close()
	{
		driver.quit();
	}
	
}
