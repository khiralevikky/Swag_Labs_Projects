package test;

import java.util.ArrayList;

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
public class ProductsPageTest extends BaseTest{
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
	public void verifyDisplayOfProduct() {
		test = extent.createTest("verifyDisplayOfProduct");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.isProductDisplayed(driver);
		Assert.assertTrue(productPage.isProductDisplayed(driver));		
	}
	@Test(priority=2)
	public void verifyProductNameLink() {
		test = extent.createTest("verifyProductNameLink");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnProductName(1);
		String currentTitle=driver.getCurrentUrl();
		Assert.assertTrue(currentTitle.contains("inventory-item.html"));
	}
	@Test(priority=3)
	public void verifyProductImageLink() {
		test = extent.createTest("verifyProductImageLink");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnProductImage(0);
		String currentTitle=driver.getCurrentUrl();
		Assert.assertTrue(currentTitle.contains("inventory-item.html"));
	}
	@Test(priority=4)
	public void verifyFilterByNameAtoZ() {
		test = extent.createTest("verifyFilterByNameAtoZ");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);		
		ArrayList<String> sortList=productPage.productNameSortedAtoZBeforeClick();
		productPage.clickOnFilter(0,driver);	
	    Assert.assertEquals(sortList, productPage. productNameSortedList());
	}
	@Test(priority=5)
	public void verifyFilterByNameZtoA() {
		test = extent.createTest("verifyFilterByNameZtoA");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);		
		ArrayList<String> sortList=productPage.productNameSortedZtoABeforeClick();
		productPage.clickOnFilter(1,driver);	
	    Assert.assertEquals(sortList, productPage. productNameSortedList());
	}
	@Test(priority=6)
	public void verifyFilterByPriceLowToHigh() {
		test = extent.createTest("verifyFilterByPriceLowToHigh");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnFilter(2,driver);
		productPage.productPriceAfterSorted();
		Assert.assertEquals(productPage.productPriceAfterSorted(), productPage.productPriceSortLowToHigh());
	}
	@Test(priority=7)
	public void verifyFilterByNamePriceHighToLow() {
		test = extent.createTest("verifyFilterByNamePriceHighToLow");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnFilter(3,driver);
		productPage.productPriceSortHighToLow();
		Assert.assertEquals(productPage.productPriceAfterSorted(), productPage.productPriceSortHighToLow());
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
