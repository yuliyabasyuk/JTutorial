package testPackage;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testPackage.Utility;

public class NewTest {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	/*
	 * @Parameters({ "num1", "num2", "sum" })
	 * 
	 * @Test public void sum(int num1, int num2, int sum) {
	 * System.out.println("Sum"); Assert.assertEquals(sum, num1 + num2); }
	 */

	@Test
	public void method1() throws IOException {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("/Users/ybasi/Pictures/report1.html");
		report = new ExtentReports();
		report.attachReporter(reporter);
		logger = report.createTest("verifyHomePageTitle", "Checking the Title");

		System.setProperty("webdriver.chrome.driver", "/Users/ybasi/Downloads/chromedriver");
		driver = new ChromeDriver();
		logger.log(Status.INFO, "Chrome Browser Launched Successfully");

		driver.get("http://total-qa.com");
		logger.log(Status.INFO, "Navigated to URL");

		String actual = driver.getTitle();
		logger.log(Status.INFO, "Actual Title returned :: " + actual);

		String expected = "Total-QA - Future of Software Testing";  
		logger.log(Status.INFO, "Expected Title returned:: " + expected);

		Assert.assertEquals(actual, expected);

		/*
		 * // log with snapshot logger.pass("details",
		 * MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		 * 
		 * // test with snapshot logger.addScreenCaptureFromPath("screenshot.png");
		 * 
		 * extent.flush();
		 */

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{

		if (result.getStatus() == ITestResult.FAILURE) {
			Utility utility = new Utility();
			utility.captureScreenshot(driver, result.getName());
			
			logger.addScreenCaptureFromPath(utility.getScreenshotPath());
		}
		//driver.quit();
		//report.endTest(logger);
		report.flush();
		
		//driver.get("/Users/ybasi/Pictures/report1.html");
		
		

	}

}
