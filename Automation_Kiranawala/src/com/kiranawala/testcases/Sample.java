package com.kiranawala.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Sample {
	 WebDriver driver = new FirefoxDriver();
	 Actions dragger = new Actions(driver);
     WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//*[@id='jobreslist_outercontainer']/div/div[2]/div"));

     // drag downwards
     { int numberOfPixelsToDragTheScrollbarDown = 50;
     for (int i=10;i<500;i=i+numberOfPixelsToDragTheScrollbarDown){
         try{
     // this causes a gradual drag of the scroll bar, 10 units at a time
     dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
     Thread.sleep(1000L);
         }catch(Exception e1){}
        } 
     }
     // now drag opposite way (downwards)
     {int numberOfPixelsToDragTheScrollbarDown = -50;
     for (int j=500;j>10;j=j+numberOfPixelsToDragTheScrollbarDown){
     // this causes a gradual drag of the scroll bar, -10 units at a time
     dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
     try {
		Thread.sleep(1000L);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     }
   }
   
}