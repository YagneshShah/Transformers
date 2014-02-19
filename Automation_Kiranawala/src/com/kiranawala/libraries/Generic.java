package com.kiranawala.libraries;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Generic {
	static public int getXlRowCount(String xlpath, String sheetName)
	{
	int rc;
    try
    {
		FileInputStream fis = new FileInputStream (xlpath);
		Workbook wb = WorkbookFactory.create(fis);
		 rc = wb.getSheet(sheetName).getLastRowNum();
		 return rc;
	  } 
    catch (Exception e)
    {
		rc = -1;
		return rc;
	  }

	}
	
	static public String getXlCellValue(String xlpath, String sheetName, int rowNum, int cellNum)
	{
		String v;
        try
        {
			FileInputStream fis = new FileInputStream (xlpath);
			Workbook wb = WorkbookFactory.create(fis);
			 v = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
			 return v;
		  } 
        catch (Exception e)
        {
			v = "";
			return v;
		 }
	}
     
	static public double getXlNumCellValue(String xlpath, String sheetName, int rowNum, int cellNum)
    	{
              double v;
            try
            {
    			FileInputStream fis = new FileInputStream (xlpath);
    			Workbook wb = WorkbookFactory.create(fis);
    			 v = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
    			 return v;
    		  } 
            catch (Exception e)
            {
    			
    			return 0;
    		 }

	}
}

