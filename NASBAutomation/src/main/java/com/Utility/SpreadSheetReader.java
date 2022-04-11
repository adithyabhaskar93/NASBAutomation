package com.Utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpreadSheetReader {
	public static String reader(String path, int r, int c) throws Exception
	{
	
	String excelFilePath = path;
	FileInputStream inputstream = new FileInputStream (excelFilePath);
	XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
	XSSFSheet sheet = workbook.getSheetAt(0); //"Sheet1"
	
	XSSFRow row = sheet.getRow(r);
	XSSFCell cell=row.getCell(c);
	return cell.getStringCellValue();
			
	}

}
