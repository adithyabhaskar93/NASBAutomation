package com.pages_Lead;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.Utility.SpreadSheetReader;

public class CustomerPortalLogin extends Base_Class{
	
	public void customerLogin() throws Exception
	{
		Thread.sleep(4000);
		String spreadSheetPath="D:\\BAC_Automation_V2\\BAC_Automation2\\src\\test\\resources\\CustomerPortalData.xlsx";
		driver.findElement(By.id("firstName")).sendKeys(SpreadSheetReader.reader(spreadSheetPath, 9, 9));
		driver.findElement(By.id("lastName")).sendKeys(SpreadSheetReader.reader(spreadSheetPath, 9, 10));
		
		
		driver.findElement(By.id("phone")).sendKeys(SpreadSheetReader.reader(spreadSheetPath, 9, 15));
		driver.findElement(By.id("email")).sendKeys(SpreadSheetReader.reader(spreadSheetPath, 9, 7));
		driver.findElement(By.id("cnfm-email")).sendKeys(SpreadSheetReader.reader(spreadSheetPath, 9, 7));
		driver.findElement(By.xpath("//option[@ng-reflect-value='What is the food you least lik']")).click();
		driver.findElement(By.id("answer")).sendKeys(SpreadSheetReader.reader(spreadSheetPath, 9, 11));
		driver.findElement(By.id("login")).sendKeys(SpreadSheetReader.reader(spreadSheetPath, 9, 12));
		driver.findElement(By.id("password")).sendKeys(SpreadSheetReader.reader(spreadSheetPath, 9, 13));
		driver.findElement(By.id("cnfm-password")).sendKeys(SpreadSheetReader.reader(spreadSheetPath, 9, 14));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='submit']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-large submit no-arrow ng-star-inserted' and @title='Send my code via text message.']")).click();
		Thread.sleep(4000);
	}

}
