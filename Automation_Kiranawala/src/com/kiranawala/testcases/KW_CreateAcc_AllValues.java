package com.kiranawala.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.kiranawala.libraries.Generic;
import com.kiranawala.libraries.ProjectSpecificKi;
import com.kiranawala.libraries.SuperTestNGki;
/**
 * Author : Siddhi
 * 
 */



public class KW_CreateAcc_AllValues extends SuperTestNGki 
{

		@ Test
		
	    public void testKW_CreateAcc_AllValues()
	    {
			
		 // Create Your Account page fill up
			
			String xlpath ="./excelfiles/config.xlsx";
			String sheetName = "sheet2";
			String userName = Generic.getXlCellValue(xlpath,sheetName,0,1);
			ProjectSpecificKi.createUserAccount(userName);
				
			Reporter.log("Step1",true);
						
	    // Mandatory Fields fill Up
			String firstName = Generic.getXlCellValue(xlpath,sheetName,1,1);
			String lastName = Generic.getXlCellValue(xlpath,sheetName,2,1);
			String password = Generic.getXlCellValue(xlpath,sheetName,3,1);
			String address = Generic.getXlCellValue(xlpath,sheetName,4,1);
			double pincode = Generic.getXlNumCellValue(xlpath,sheetName,5,1);
			String city = Generic.getXlCellValue(xlpath,sheetName,6,1);
			double mobile = Generic.getXlNumCellValue(xlpath, sheetName, 7,1);
			String alias = Generic.getXlCellValue(xlpath,sheetName,8,1);
			double day = Generic.getXlNumCellValue(xlpath, sheetName, 9, 1);
			double month = Generic.getXlNumCellValue(xlpath, sheetName, 10, 1);
			double year = Generic.getXlNumCellValue(xlpath, sheetName, 11,1);
			
			ProjectSpecificKi.mandatoryFields(firstName, lastName, password, address, pincode, city, mobile, alias,day, month, year);
			Reporter.log("Step2",true);
			// Optional Field fillup
			
			String company = Generic.getXlCellValue(xlpath,sheetName,12,1);
			String address2= Generic.getXlCellValue(xlpath,sheetName,13,1);
			String other = Generic.getXlCellValue(xlpath,sheetName,14,1);
			double phone = Generic.getXlNumCellValue(xlpath, sheetName,15,1);
			String refpgm = Generic.getXlCellValue(xlpath,sheetName,16,1);
			ProjectSpecificKi.optionalFields(company, address2, other, phone, refpgm);
		// submit
			
			ProjectSpecificKi.submit();

        // Logout
			ProjectSpecificKi.logout();
			Reporter.log("Step3",true);

		//login
			
			ProjectSpecificKi.login(userName, password);
		//logout	
			ProjectSpecificKi.logout();
			Reporter.log("Step4",true);	
	   	  
	}
	}


