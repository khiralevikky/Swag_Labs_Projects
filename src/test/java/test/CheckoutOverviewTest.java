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
public class CheckoutOverviewTest extends BaseTest{
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
	public void verifyDisplayOfProductOnCheckoutOverviewPage() {
		test = extent.createTest("verifyDisplayOfProductOnCheckoutOverviewPage");
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
		
		CheckoutOverviewPage checkoutOverview=new CheckoutOverviewPage(driver);
		checkoutOverview.isProductDisplayedInCart(driver);		
		Assert.assertTrue(checkoutOverview.isProductDisplayedInCart(driver));		
	}
	@Test(priority=2)
	public void verifyProductPrice() {
		test = extent.createTest("verifyProductPrice");
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
		
		CheckoutOverviewPage checkoutOverview=new CheckoutOverviewPage(driver);
		checkoutOverview.isProductDisplayedInCart(driver);	
		double price=checkoutOverview.checkProductPrice(0, driver);
	//	System.out.println(price);
		Assert.assertEquals(checkoutOverview.checkProductPrice(0, driver), 29.99);
	}
	@Test(priority=3)
	public void verifyItemTotalWithAdditionOfProductPrice() {
		test = extent.createTest("verifyItemTotalWithAdditionOfProductPrice");
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
		
		CheckoutOverviewPage checkoutOverview=new CheckoutOverviewPage(driver);
		checkoutOverview.isProductDisplayedInCart(driver);
		Double itemTotal=checkoutOverview.additionOfPrice(0, driver);
		Assert.assertEquals(checkoutOverview.checkItemTotal(), itemTotal);	
	}
	@Test(priority=4)
	public void verifySumOfItemTotalAndTaxWithTotalPrice() {
		test = extent.createTest("verifySumOfItemTotalAndTaxWithTotalPrice");
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
		
		CheckoutOverviewPage checkoutOverview=new CheckoutOverviewPage(driver);
		checkoutOverview.isProductDisplayedInCart(driver);
		double sum=checkoutOverview.checkItemTotal()+ checkoutOverview.checkTaxPrice();
		Assert.assertEquals(checkoutOverview.checkTotalPrice(), sum);
	}
	@Test(priority=5)
	public void verifyFinishButton() {
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
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("checkout-complete.html"));
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
		cartPage.clickOnCheckoutButton();	
		CheckoutPage checkoutPage=new CheckoutPage(driver);	
		checkoutPage.enterFirstName("virat");
		checkoutPage.enterLastName("kohli");
		checkoutPage.enterZipCode("442302");		
		checkoutPage.clickOnContinueButton();
		
		CheckoutOverviewPage checkoutOverview = new CheckoutOverviewPage(driver);
		checkoutOverview.isProductDisplayedInCart(driver);
		checkoutOverview.clickOnCancelButton();
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory.html"));
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
