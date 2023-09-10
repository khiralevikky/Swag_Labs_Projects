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
import pom.FooterPage;
import pom.ProductPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class FooterTest extends BaseTest{
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
	public void verifyTwitterLink() {
		test = extent.createTest("verifyTwitterLink");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		FooterPage footerPage=new FooterPage(driver);
		footerPage.clickOnTwitter();
		String currentUrl=footerPage.getChildWindowUrl(driver);
		Assert.assertEquals(currentUrl, "https://twitter.com/saucelabs");
		
	}
	@Test(priority=2)
	public void verifyFacebookLink() {
		test = extent.createTest("verifyFacebookLink");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		FooterPage footerPage=new FooterPage(driver);
		footerPage.clickOnFacebook();
		String currentUrl=footerPage.getChildWindowUrl(driver);
		Assert.assertEquals(currentUrl, "https://www.facebook.com/saucelabs");
	}
	@Test(priority=3)
	public void verifyLinkdinLink() {
		test = extent.createTest("verifyLinkdinLink");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		FooterPage footerPage=new FooterPage(driver);
		footerPage.clickOnLinkdin();
		String currentUrl=footerPage.getChildWindowUrl(driver);
		Assert.assertEquals(currentUrl, "https://www.linkedin.com/company/sauce-labs/");	
	}
	@Test(priority=4)
	public void verifyPrivacyPolicy() {
		test = extent.createTest("verifyPrivacyPolicy");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		FooterPage footerPage=new FooterPage(driver);
		String privacyPolicy=footerPage.getTextOfPrivacyPolicy();
		Assert.assertEquals(privacyPolicy, "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
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
