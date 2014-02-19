package com.kiranawala.libraries;

		import java.util.concurrent.TimeUnit;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.support.ui.Select;


	public class Demo
	{

		   
		public static void main(String[] args) 
		{
		       
		        WebDriver driver = new FirefoxDriver();
		        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		        driver.get("http://kiranawala.in/authentication?back=my-account.php");
		        driver.findElement(By.id("email_create")).sendKeys("liddhi.ahir@gmail.com");
		        driver.findElement(By.id("SubmitCreate")).click();
		        driver.findElement(By.id("id_gender2")).click();
		        driver.findElement(By.id("customer_firstname")).sendKeys("Siddhi");
		        driver.findElement(By.id("customer_lastname")).sendKeys("Ahir");
		        driver.findElement(By.id("passwd")).sendKeys("ToBuy0$");
		        driver.findElement(By.id("days")).click();
		        Select select = new Select(driver.findElement(By.id("days")));
		        select.selectByValue("31");
		        driver.findElement(By.id("months")).click();
		        Select select1 = new Select(driver.findElement(By.id("months")));
		        select1.selectByValue("1");
		        driver.findElement(By.id("years")).click();
		        Select select2= new Select(driver.findElement(By.id("years")));
		  /**      
		        driver.findElement(By.id("address1")).sendKeys(arg0);
		        driver.findElement(By.id("postcode")).sendKeys(arg0);
		        driver.findElement(By.id("city")).sendKeys(arg0);
		        driver.findElement(By.id("phone_mobile")).sendKeys(arg0);
		        driver.findElement(By.id("alias")).clear();
		        driver.findElement(By.id("alias")).sendKeys(arg0);
		        driver.findElement(By.id("submitAccount")).click();
		        
		        
		        driver.findElement(By.id("company")).sendKeys(arg0);
		        driver.findElement(By.id("address2")).sendKeys(arg0);
		        driver.findElement(By.id("other")).sendKeys(arg0);
		        driver.findElement(By.id("phone")).sendKeys(arg0);
		        driver.findElement(By.id("referralprogram")).sendKeys(arg0);



		     **/   
            

	}

}
