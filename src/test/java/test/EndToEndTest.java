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
import pom.CartPage;
import pom.CheckoutOverviewPage;
import pom.CheckoutPage;
import pom.ProductPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class EndToEndTest extends BaseTest{
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
	public void verifyOrderPlace() {
		test = extent.createTest("verifyOrderPlace");
		test = extent.createTest("verifyFinishButton");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnMultipleAddTocartbutton(2);
		productPage.clickOnShoppingCartButton(driver);
		CartPage cartPage=new CartPage(driver);
		cartPage.isProductDisplayedInCart(driver);
		cartPage.clickOnCheckoutButton();	
		CheckoutPage checkoutPage=new CheckoutPage(driver);	
		checkoutPage.enterFirstName("virat");
		checkoutPage.enterLastName("kohli");
		checkoutPage.enterZipCode("442302");		
		checkoutPage.clickOnContinueButton();
		
		CheckoutOverviewPage checkoutOverview = new CheckoutOverviewPage(driver);
		checkoutOverview.isProductDisplayedInCart(driver);
		checkoutOverview.clickOnFinishButton();
		String success=checkoutOverview.getTextOrderSuccess();
		Assert.assertEquals(success,"Thank you for your order!");
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
