package com.pages_Lead;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;

public class CreteNewPurchaseLoanWithOptOutSMS extends Base_Class{
	public void createNewPurchaseTypeLoanWithOptOutSMS ()
	{
		driver.findElement(By.xpath("//*[@id=\"apply-page\"]/loan-purpose/ion-content/form/div/ion-item[1]/ion-segment/ion-segment-button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"apply-page\"]/loan-purpose/ion-content/form/div/ion-item[2]/yes-no-bool/ion-segment/ion-segment-button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"apply-page\"]/loan-purpose/apply-footer/div/ion-button")).click();
		driver.findElement(By.xpath("//*[@id=\"apply-page\"]/loan-purpose/ion-content/form/div/ion-item[4]/div/ion-input/input")).sendKeys("2133577858");
		
		driver.findElement(By.xpath("//*[@id=\"apply-page\"]/purchase-property/ion-content/form/ion-item[1]/yes-no-bool/ion-segment/ion-segment-button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"apply-page\"]/purchase-property/ion-content/form/ion-item[2]/div/ion-input/input")).sendKeys("90038");
		
		
	}

}
