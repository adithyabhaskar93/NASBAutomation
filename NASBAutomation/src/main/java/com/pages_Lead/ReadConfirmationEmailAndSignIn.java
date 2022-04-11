package com.pages_Lead;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.BasePackage.Base_Class;
import com.Utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadConfirmationEmailAndSignIn extends Base_Class{
	
	public void readConfirmationEmail() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Log.info("Driver has initialized successful for chrome browser");
		
		driver.get("https://mail.speridian.com/owa/adithya.bhaskar@speridian.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("adithya.bhaskar@speridian.com");
		driver.findElement(By.id("password")).sendKeys("Kdsadi@46");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"lgnDiv\"]/div[9]/div/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("_ariaId_42")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//span[@class='_lv_01 lvHighlightAllClass lvHighlightSubjectClass']")).click();
		//System.out.println("Clicked");
		String from=driver.findElement(By.xpath("//span[@class='bidi allowTextSelection']")).getText();
		System.out.println("Sender Address: "+from);
		String sub=driver.findElement(By.xpath("//span[@class='rpHighlightAllClass rpHighlightSubjectClass']")).getText();
		System.out.println("Subject Line: "+sub);
		String msg=driver.findElement(By.xpath("//*[@id=\"Item.MessageUniqueBody\"]/div/div/div/table/tbody/tr/td")).getText();
		System.out.println("Message Body: " +msg);
		
		//Click on Sign-In Below
		driver.findElement(By.xpath("//*[@id=\"Item.MessageUniqueBody\"]/div/div/div/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/center/table/tbody/tr/td/table/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr/td/a/strong")).click();
		
	}

}
