package com.pages_Lead;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.BasePackage.Base_Class;
import com.Utility.DataReaderFromPage;

public class LeadVerification extends Base_Class{

	public void verifyLead() throws IOException
	{
		DataReaderFromPage dr=new DataReaderFromPage();
		
		List<WebElement> col=driver.findElements(By.xpath("/html/body/div[5]/div[1]/table/tbody/tr[1]/td"));
		int colsize=col.size();
		System.out.println("Column Size= "+colsize);
		String fName=driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/tbody/tr[1]/td[2]")).getText();
		System.out.println("First Name: "+fName);
		
		String lName=driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/tbody/tr[1]/td[3]")).getText();
		System.out.println("Last Name: "+lName);
		
		String leadSource=driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/tbody/tr[1]/td[10]")).getText();
		System.out.println("Lead Source: "+leadSource);
		
		String status=driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/tbody/tr[1]/td[11]")).getText();
		System.out.println("Status: "+status);
		
		String Lid=driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/tbody/tr[1]/td[25]")).getText();
		System.out.println("Lead ID: "+Lid);
		
		dr.dataReader(fName, lName, leadSource, status, Lid);
		
		//Below code is to display all the first row values
//		for (int i=1;i<=1;i++)
//		{
//			for(int j=1;j<=colsize;j++)
//			{
//				System.out.println(driver.findElement(By.xpath("/html/body/div[5]/div[1]/table/tbody/tr[" + i + "]/td[" + j + "]")).getText());
//			}
//		}


	}
}
