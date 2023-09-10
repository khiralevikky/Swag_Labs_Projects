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
import pom.CartPage;
import pom.ProductPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class CartPageTest extends BaseTest{
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
	public void verifyAddToCartItemLink() {	
		test = extent.createTest("verifyAddToCartItemLink");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnMultipleAddTocartbutton(2);
		productPage.clickOnShoppingCartButton(driver);
		String currentTitle=driver.getCurrentUrl();
		Assert.assertTrue(currentTitle.contains("cart.html"));		
	}
	@Test(priority=2)
	public void verifyDisplayOfAddToCartProduct() {		
		test = extent.createTest("verifyDisplayOfAddToCartProduct");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnMultipleAddTocartbutton(2);
		productPage.clickOnShoppingCartButton(driver);	
		CartPage cartPage=new CartPage(driver);
		cartPage.isProductDisplayedInCart(driver);
		Assert.assertTrue(cartPage.isProductDisplayedInCart(driver));			
	}
	@Test(priority=3)
	public void verifyAddToCartProductName() {
		test = extent.createTest("verifyAddToCartProductName");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnAddTocartbutton(1);
		productPage.clickOnShoppingCartButton(driver);	
		CartPage cartPage=new CartPage(driver);
		cartPage.getProductName(0, driver);	
		Assert.assertEquals(cartPage.getProductName(0,driver), "Sauce Labs Bike Light");	
	}
	@Test(priority=4)
	public void verifyAddToCartProductNameLink() {
		test = extent.createTest("verifyAddToCartProductNameLink");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnAddTocartbutton(1);
		productPage.clickOnShoppingCartButton(driver);	
		CartPage cartPage=new CartPage(driver);
		cartPage.ClickOnProductNameLink(0, driver);
		String currentTitle=driver.getCurrentUrl();
		Assert.assertTrue(currentTitle.contains("inventory-item.html"));		
	}	
	@Test(priority=5)
	public void verifyRemoveTheProductFromCart() {
		test = extent.createTest("verifyRemoveTheProductFromCart");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnAddTocartbutton(1);
		productPage.clickOnShoppingCartButton(driver);	
		CartPage cartPage=new CartPage(driver);
		cartPage.clickOnRemoveButton(0, driver);
		Assert.assertTrue(cartPage.isProductCountInCart(driver));	
	}
	@Test(priority=6)
	public void verifyCancelButton() {
		test = extent.createTest("verifyCancelButton");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnMultipleAddTocartbutton(2);
		productPage.clickOnShoppingCartButton(driver);	
		CartPage cartPage=new CartPage(driver);
		cartPage.isProductDisplayedInCart(driver);
		Assert.assertTrue(cartPage.isProductDisplayedInCart(driver));
		cartPage.clickOnContinueShooping();
		String currentTitle=driver.getCurrentUrl();
		Assert.assertTrue(currentTitle.contains("inventory.html"));	
	}
	@Test(priority=7)
	public void verifyCheckoutButton() {
		test = extent.createTest("verifyCheckoutButton");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnMultipleAddTocartbutton(2);
		productPage.clickOnShoppingCartButton(driver);	
		CartPage cartPage=new CartPage(driver);
		cartPage.isProductDisplayedInCart(driver);
		Assert.assertTrue(cartPage.isProductDisplayedInCart(driver));
		cartPage.clickOnCheckoutButton();
		String currentTitle=driver.getCurrentUrl();
		Assert.assertTrue(currentTitle.contains("checkout-step-one.html"));	
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
