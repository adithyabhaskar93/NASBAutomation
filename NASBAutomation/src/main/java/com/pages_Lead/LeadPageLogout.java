package com.pages_Lead;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class LeadPageLogout extends Base_Class{
	public void leadlogout() throws InterruptedException
	{
		driver.findElement(By.id("agentFirstName")).click();
		driver.findElement(By.cssSelector("#signOut > span > strong")).click();
		Thread.sleep(4000);
	}

}
