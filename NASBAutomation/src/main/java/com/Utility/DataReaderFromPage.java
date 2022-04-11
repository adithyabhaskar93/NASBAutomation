package com.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReaderFromPage {
	public void dataReader(String Fname, String Lname, String LS, String Status, String ID) throws IOException
	{
		String excelFilePath = "D:\\BAC_Automation_V2\\BAC_Automation2\\src\\test\\resources\\LeadLoginData.xlsx";
		FileInputStream inputstream = new FileInputStream (excelFilePath);
		XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
		XSSFSheet sheet=workbook.createSheet();
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("FirstName");
		sheet.getRow(0).createCell(1).setCellValue("LastName");
		sheet.getRow(0).createCell(2).setCellValue("LeadSouece");
		sheet.getRow(0).createCell(3).setCellValue("Status");
		sheet.getRow(0).createCell(4).setCellValue("LeadID");
		
		//Reading Lead Data
		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue(Fname);
		sheet.getRow(1).createCell(1).setCellValue(Lname);
		sheet.getRow(1).createCell(2).setCellValue(LS);
		sheet.getRow(1).createCell(3).setCellValue(Status);
		sheet.getRow(1).createCell(4).setCellValue(ID);
		
		FileOutputStream fo=new FileOutputStream(excelFilePath);
		workbook.write(fo);
		workbook.close();
		
		
		
	}

}
