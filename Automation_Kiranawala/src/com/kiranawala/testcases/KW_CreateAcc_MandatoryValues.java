package com.kiranawala.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.kiranawala.libraries.Generic;
import com.kiranawala.libraries.ProjectSpecific;
import com.kiranawala.libraries.SuperTestNG;


public class KW_CreateAcc_MandatoryValues extends SuperTestNG 
{

		@ Test
	    public void testKW_CreateAcc_AllValues()
	    {
			
		 // Create Your Account page fill up
			
			String xlpath ="./excelfiles/config.xlsx";
			String sheetName = "sheet2";
			String userName = Generic.getXlCellValue(xlpath,sheetName,0,2);
			ProjectSpecific.createUserAccount(userName);
			
	    // Mandatory Fields fill Up
			String firstName = Generic.getXlCellValue(xlpath,sheetName,1,2);
			String lastName = Generic.getXlCellValue(xlpath,sheetName,2,2);
			String password = Generic.getXlCellValue(xlpath,sheetName,3,2);
			String address = Generic.getXlCellValue(xlpath,sheetName,4,2);
			double pincode = Generic.getXlNumCellValue(xlpath,sheetName,5,2);
			String city = Generic.getXlCellValue(xlpath,sheetName,6,2);
			double mobile = Generic.getXlNumCellValue(xlpath, sheetName,7,2);
			String alias = Generic.getXlCellValue(xlpath,sheetName,8,2);
			double day = Generic.getXlNumCellValue(xlpath, sheetName, 9,2);
			double month = Generic.getXlNumCellValue(xlpath, sheetName,10,2);
			double year = Generic.getXlNumCellValue(xlpath, sheetName, 11,2);
			
			ProjectSpecific.mandatoryFields(firstName, lastName, password, address, pincode, city, mobile, alias,day, month, year);
			Reporter.log("Step2");

	        // Logout
				ProjectSpecific.logout();
				Reporter.log("Step3");

			//login
				
				ProjectSpecific.login(userName, password);
			//logout	
				ProjectSpecific.logout();
				Reporter.log("Step4");	
		   	  

		}
			
}