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
import pom.ProductDetailsPage;
import pom.ProductPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class AddToCartTest extends BaseTest{
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
	public void verifyAddToCartFromProductPage() {
		test = extent.createTest("verifyAddToCartFromProductPage");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnAddTocartbutton(1);
		productPage.getTextOfRemoveButton(0, driver);
		Assert.assertEquals(productPage.getTextOfRemoveButton(0, driver), "Remove");
	}
	@Test(priority=2)
	public void verifyAddToCartFromProductPageWithProductCount() {
		test = extent.createTest("verifyAddToCartFromProductPageWithProductCount");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();		
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnAddTocartbutton(1);
		productPage.countShoopingCart(driver);
		Assert.assertEquals(productPage.countShoopingCart(driver), 1);
	}
	@Test(priority=3)
	public void verifyRemoveProductFromProductPage() {
		test = extent.createTest("verifyRemoveProductFromProductPage");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnAddTocartbutton(1);
		productPage.clickOnRemoveButton(0, driver);
		productPage.getTextOfAddToCartButton(1, driver);
		Assert.assertEquals(productPage.getTextOfAddToCartButton(1, driver), "Add to cart");
	}
	@Test(priority=4)
	public void addMultipleProductToCart() {
		test = extent.createTest("addMultipleProductToCart");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnMultipleAddTocartbutton(2);
		productPage.getCountOfRemoveButton(0, driver);
		Assert.assertNotEquals(productPage.getCountOfRemoveButton(0, driver), 0);	
	}
	@Test(priority=5)
	public void verifyAddToCartFromProductDetailsPage() {
		test = extent.createTest("verifyAddToCartFromProductDetailsPage");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnProductName(1);
		
		ProductDetailsPage productDetails=new ProductDetailsPage(driver);
		productDetails.clickOnAddToCardButton();
		Assert.assertEquals(productDetails.getTextOfRemoveButton(driver), "Remove");
	}
	@Test(priority=6)
	public void verifyAddToCartFromProductDetailsPageWithProductCount() {
		test = extent.createTest("verifyAddToCartFromProductDetailsPageWithProductCount");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnProductName(1);
		
		ProductDetailsPage productDetails=new ProductDetailsPage(driver);
		productDetails.clickOnAddToCardButton();	
		productPage.countShoopingCart(driver);
		Assert.assertEquals(productPage.countShoopingCart(driver), 1);	
	}
	@Test(priority=7)
	public void verifyRemoveProductFromProductDetailsPage() {
		test = extent.createTest("verifyRemoveProductFromProductDetailsPage");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnProductName(1);
		
		ProductDetailsPage productDetails=new ProductDetailsPage(driver);
		productDetails.clickOnAddToCardButton();
		productDetails.clickOnRemoveButton(driver);
		Assert.assertEquals(productDetails.getTextOfAddToCartButton(driver), "Add to cart");
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
