package com.pages_Lead;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.Utility.SpreadSheetReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadPageLogin extends Base_Class{
	public void leadLogin() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Log.info("Driver has initialized successful for chrome browser");
		driver.get("https://lm.prod.velocify.com/Web/Login.aspx");
		
		String spreadSheetPath="D:\\BAC_Automation_V2\\BAC_Automation2\\src\\test\\resources\\LeadLoginData.xlsx";
		driver.findElement(By.id("usernameTextBox")).sendKeys(SpreadSheetReader.reader(spreadSheetPath, 1, 0));
		driver.findElement(By.id("passwordTextBox")).sendKeys(SpreadSheetReader.reader(spreadSheetPath, 1, 1));
		driver.findElement(By.id("loginButton")).click();
	}
}
