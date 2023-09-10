package test;

import org.openqa.selenium.WebDriver;

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
import pom.SwaglabsLoginPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class SwaglabsLoginTest extends BaseTest{
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
    public void loginStandardUserWithValidCredentials() {
    	test = extent.createTest("loginStandardUserWithValidCredentials");
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("standard_user",driver);
    	obj.enterPassword("secret_sauce",driver);
    	obj.clickOnLogin(driver);
    	String CurrentUrl=driver.getCurrentUrl();
    	Assert.assertEquals(CurrentUrl, "https://www.saucedemo.com/inventory.html");
    }
    public void loginWithValidCredentials() {
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("standard_user",driver);
    	obj.enterPassword("secret_sauce",driver);
    	obj.clickOnLogin(driver);
    }
    @Test(priority=2)
    public void loginStandardUserWithValidUsernameAndInvalidPassword() {
    	test = extent.createTest("loginStandardUserWithValidUsernameAndInvalidPassword");
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("standard_user",driver);
    	obj.enterPassword("xyznn",driver);
    	obj.clickOnLogin(driver);
    	String CurrentUrl=driver.getCurrentUrl();
    	Assert.assertNotEquals(CurrentUrl, "https://www.saucedemo.com/inventory.html");
    }
    @Test(priority=3)
    public void loginStandardUserWithInvalidUsernameAndValidPassword() {
    	test = extent.createTest("loginStandardUserWithInvalidUsernameAndValidPassword");
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("virat_xyz",driver);
    	obj.enterPassword("secret_sauce",driver);
    	obj.clickOnLogin(driver);
    	String CurrentUrl=driver.getCurrentUrl();
    	Assert.assertNotEquals(CurrentUrl, "https://www.saucedemo.com/inventory.html");
    }
    
    @Test(priority=4)
    public void loginOfLockedOutUserWithValidCredentials() {
    	test = extent.createTest("loginOfLockedOutUserWithValidCredentials");
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("locked_out_user",driver);
    	obj.enterPassword("secret_sauce",driver);
    	obj.clickOnLogin(driver);
    	String CurrentUrl=driver.getCurrentUrl();
    	Assert.assertEquals(CurrentUrl, "https://www.saucedemo.com/");
    }
    @Test(priority=5)
    public void loginLockedOutUserWithValidUsernameAndInvalidPassword() {
    	test = extent.createTest("loginLockedOutUserWithValidUsernameAndInvalidPassword");
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("locked_out_user",driver);
    	obj.enterPassword("secretxyz",driver);
    	obj.clickOnLogin(driver);
    	String CurrentUrl=driver.getCurrentUrl();
    	Assert.assertEquals(CurrentUrl, "https://www.saucedemo.com/");
    }
    @Test(priority=6)
    public void loginOfProblemUserWithValidCredentials() {
    	test = extent.createTest("loginOfProblemUserWithValidCredentials");
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("problem_user",driver);
    	obj.enterPassword("secret_sauce",driver);
    	obj.clickOnLogin(driver);
    	String CurrentUrl=driver.getCurrentUrl();
    	Assert.assertEquals(CurrentUrl, "https://www.saucedemo.com/inventory.html");
    }
    @Test(priority=7)
    public void loginOfProblemUserWithValidUsernameAndInvalidPassword() {
    	test = extent.createTest("loginOfProblemUserWithValidUsernameAndInvalidPassword");
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("problem_user",driver);
    	obj.enterPassword("secretxyz",driver);
    	obj.clickOnLogin(driver);
    	String CurrentUrl=driver.getCurrentUrl();
    	Assert.assertEquals(CurrentUrl, "https://www.saucedemo.com/");
    }
    @Test(priority=8)
    public void loginOfProblemUserWithInvalidUsernameAndValidPassword() {
    	test = extent.createTest("loginOfProblemUserWithInvalidUsernameAndValidPassword");
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("virat_xyz",driver);
    	obj.enterPassword("secret_sauce",driver);
    	obj.clickOnLogin(driver);
    	String CurrentUrl=driver.getCurrentUrl();
    	Assert.assertEquals(CurrentUrl, "https://www.saucedemo.com/");
    }    
    @Test(priority=9)
    public void loginOfPerformanceGlitchUserWithValidCredentials() {
    	test = extent.createTest("loginOfPerformanceGlitchUserWithValidCredentials");
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("performance_glitch_user",driver);
    	obj.enterPassword("secret_sauce",driver);
    	obj.clickOnLogin(driver);
    	String CurrentUrl=driver.getCurrentUrl();
    	Assert.assertEquals(CurrentUrl, "https://www.saucedemo.com/inventory.html");
    }
    
    @Test(priority=10)
    public void loginOfPerformanceGlitchUserWithValidUsernameAndInvalidPassword() {
    	test = extent.createTest("loginOfPerformanceGlitchUserWithValidUsernameAndInvalidPassword");
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("performance_glitch_user",driver);
    	obj.enterPassword("secretabc",driver);
    	obj.clickOnLogin(driver);
    	String CurrentUrl=driver.getCurrentUrl();
    	Assert.assertEquals(CurrentUrl, "https://www.saucedemo.com/");
    }
    @Test(priority=11)
    public void loginOfPerformanceGlitchUserWithInvalidUsernameAndValidPassword() {
    	test = extent.createTest("loginOfPerformanceGlitchUserWithInvalidUsernameAndValidPassword");
    	SwaglabsLoginPage obj=new SwaglabsLoginPage(driver);
    	obj.enterUserName("performance_abc",driver);
    	obj.enterPassword("secret_sauce",driver);
    	obj.clickOnLogin(driver);
    	String CurrentUrl=driver.getCurrentUrl();
    	Assert.assertEquals(CurrentUrl, "https://www.saucedemo.com/");
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
