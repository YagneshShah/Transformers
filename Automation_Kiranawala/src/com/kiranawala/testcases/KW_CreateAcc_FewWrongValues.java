package com.kiranawala.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.kiranawala.libraries.Generic;
import com.kiranawala.libraries.ProjectSpecificKi;
import com.kiranawala.libraries.SuperTestNGki;

public class KW_CreateAcc_FewWrongValues extends SuperTestNGki
{
	@Test
	public void testKW_CreateAcc_FewWrongValues()
    {
		
		// Create Your Account page fill up
		
					String xlpath ="./excelfiles/config.xlsx";
					String sheetName = "sheet2";
					String userName = Generic.getXlCellValue(xlpath,sheetName,0,3);
					ProjectSpecificKi.createUserAccount(userName);
					
					Reporter.log("Step1",true);

								
	   // Mandatory Fields fill Up
					String firstName = Generic.getXlCellValue(xlpath,sheetName,1,3);
					String lastName = Generic.getXlCellValue(xlpath,sheetName,2,3);
					String password = Generic.getXlCellValue(xlpath,sheetName,3,3);
					String address = Generic.getXlCellValue(xlpath,sheetName,4,3);
					double pincode = Generic.getXlNumCellValue(xlpath,sheetName,5,3);
					String city = Generic.getXlCellValue(xlpath,sheetName,6,3);
					double mobile = Generic.getXlNumCellValue(xlpath, sheetName, 7,3);
					String alias = Generic.getXlCellValue(xlpath,sheetName,8,3);
					double day = Generic.getXlNumCellValue(xlpath, sheetName, 9, 3);
					double month = Generic.getXlNumCellValue(xlpath, sheetName, 10, 3);
					double year = Generic.getXlNumCellValue(xlpath, sheetName, 11,3);
					
					ProjectSpecificKi.mandatoryFields(firstName, lastName, password, address, pincode, city, mobile, alias,day, month, year);
					
					Reporter.log("Step2",true);
       // Optional Field fillup
					
					String company = Generic.getXlCellValue(xlpath,sheetName,12,3);
					String address2= Generic.getXlCellValue(xlpath,sheetName,13,3);
					String other = Generic.getXlCellValue(xlpath,sheetName,14,3);
					double phone = Generic.getXlNumCellValue(xlpath, sheetName,15,3);
					String refpgm = Generic.getXlCellValue(xlpath,sheetName,16,3);
					ProjectSpecificKi.optionalFields(company, address2, other, phone, refpgm);	
					
					Reporter.log("Step3",true);	
				
				
		//submit
					ProjectSpecificKi.submit();
					
					
					String eMsg = "There are 3 errors :";
					ProjectSpecificKi.verifySuccesMsg(eMsg);
					
					
			}
			
    } 

