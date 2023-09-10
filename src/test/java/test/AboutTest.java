package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.ProductPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class AboutTest extends BaseTest{
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		extent=Reports.createReports();	
	}
	@BeforeMethod
	public void openbBrowser() {
		driver=LaunchBrowser.chrome();
	}
	@Test(priority=1)
	public void verifyAboutPage() {
		test = extent.createTest("verifyAboutPage");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnMenu();
		productPage.clickOnAbout();
		String currentTitle=driver.getTitle();
		Assert.assertEquals(currentTitle, "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
	}
	@AfterMethod
	public void captureResult(ITestResult result) {
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
		
		driver.close();
	  }
	
	@AfterTest
	public void publish() {
		extent.flush();
	}
}
