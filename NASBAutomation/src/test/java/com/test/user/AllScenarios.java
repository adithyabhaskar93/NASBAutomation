package com.test.user;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.BasePackage.Base_Class;

import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.pages_Lead.CustomerPortalLogin;
import com.pages_Lead.LeadPageLogin;
import com.pages_Lead.LeadPageLogout;
import com.pages_Lead.LeadVerification;
import com.pages_Lead.ReadEmail;





public class AllScenarios extends Base_Class {

	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	
	@BeforeSuite
	public void reference() {
		Base_Class = new Base_Class();

		log=new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);

		

	}

	@Test(dataProvider = "TestData")
	public  void RUNALL(Map <Object,Object> testdata, ITestContext context) throws IOException, InterruptedException {

		try {

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {

				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");	
				context.setAttribute("fileName", "Customer Account Creation");
				Base_Class.setup();				
				CustomerPortalLogin cpl=new CustomerPortalLogin();
				cpl.customerLogin();
				ExtentTestManager.getTest().log(Status.PASS, "Customer Portal New User Created Successfully");
				Log.info("New User Created In Customer Portal");
				
				context.setAttribute("fileName", "Logout");
				driver.quit();
				ExtentTestManager.getTest().log(Status.PASS, "Browser Closed");
				Log.info("Chrome is closed");
				
				Thread.sleep(4000);
				context.setAttribute("fileName", "Lead Login");
				LeadPageLogin ll=new LeadPageLogin();
				ll.leadLogin();
				ExtentTestManager.getTest().log(Status.PASS, "Successfully Logged into the Lead Page");
				Log.info("Logged into Lead Page");
				
				Thread.sleep(4000);
				context.setAttribute("fileName", "Lead Value Verification");
				LeadVerification lv=new LeadVerification();
				lv.verifyLead();
				ExtentTestManager.getTest().log(Status.PASS, "Newly created Loan details are verified and captured in spread sheet");
				Log.info("Values in Lead Page are verified and Stored in spread sheet");
				
				context.setAttribute("fileName", "Lead Logout");
				LeadPageLogout llogout=new LeadPageLogout();
				llogout.leadlogout();		
				ExtentTestManager.getTest().log(Status.PASS, "Successfully logged out from Lead page");
				Log.info("Logged out from Lead Page");
				
				context.setAttribute("fileName", "Logout");
				driver.quit();
				ExtentTestManager.getTest().log(Status.PASS, "Browser Closed");
				Log.info("Chrome is closed");
				
				context.setAttribute("fileName", "EmailRead");
				ReadEmail re=new ReadEmail();
				re.readMail();
				ExtentTestManager.getTest().log(Status.PASS, "Outlook Email Read Successfully");
				Log.info("Email Read Successfully");
				
				context.setAttribute("fileName", "Logout");
				driver.quit();
				ExtentTestManager.getTest().log(Status.PASS, "Browser Closed");
				Log.info("Chrome is closed");
				
				// EndTest
				System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString()+ " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

			}

		}
		catch (Exception e) {
			System.out.println("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName, testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			//driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***");
		}
		catch (AssertionError e) {
			System.out.println("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName, testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			//driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***");
		}

	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException{

		Object[][] objectarry=null;
		java.util.List<Map<String,String>> completedata=com.Utility.ExcelReader.getdata();

		objectarry=new Object[completedata.size()][1];

		for(int i=0;i<completedata.size();i++) {
			objectarry[i] [0]= completedata.get(i);
		}
		return objectarry;

	}







}
