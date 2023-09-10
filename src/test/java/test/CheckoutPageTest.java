package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.CheckoutPage;
import pom.ProductPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class CheckoutPageTest extends BaseTest{
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
	public void verifyFirstNameFieldByEnteringAlphaChar() {		
		test = extent.createTest("verifyFirstNameFieldByEnteringAlphaChar");
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
		checkoutPage.clickOnContinueButton();
		Assert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: Last Name is required");
	}
	@Test(priority=2)
	public void verifyFirstNameFieldByEnteringNumber() {	
		test = extent.createTest("verifyFirstNameFieldByEnteringNumber");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnMultipleAddTocartbutton(2);
		productPage.clickOnShoppingCartButton(driver);
		CartPage cartPage=new CartPage(driver);
		cartPage.isProductDisplayedInCart(driver);
		cartPage.clickOnCheckoutButton();	
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		checkoutPage.enterFirstName("12345");		
		checkoutPage.clickOnContinueButton();
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: First Name is required only character");
		softAssert.assertAll();
	}
	@Test(priority=3)
	public void verifyFirstNameFieldByEnteringSpecialCharacters() {	
		test = extent.createTest("verifyFirstNameFieldByEnteringSpecialCharacters");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnMultipleAddTocartbutton(2);
		productPage.clickOnShoppingCartButton(driver);
		CartPage cartPage=new CartPage(driver);
		cartPage.isProductDisplayedInCart(driver);
		cartPage.clickOnCheckoutButton();	
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		checkoutPage.enterFirstName("%#@#");		
		checkoutPage.clickOnContinueButton();
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: First Name is required only character");
		softAssert.assertAll();
	}
	@Test(priority=4)
	public void verifyFirstNameFieldByEnteringAlphaCharactersAndNumbers() {	
		test = extent.createTest("verifyFirstNameFieldByEnteringAlphaCharactersAndNumbers");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnMultipleAddTocartbutton(2);
		productPage.clickOnShoppingCartButton(driver);
		CartPage cartPage=new CartPage(driver);
		cartPage.isProductDisplayedInCart(driver);
		cartPage.clickOnCheckoutButton();	
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		checkoutPage.enterFirstName("virat123");		
		checkoutPage.clickOnContinueButton();
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: First Name is required only character");
		softAssert.assertAll();
	}
	@Test(priority=5)
	public void verifyLastNameFieldByEnteringAlphaChar() {	
		test = extent.createTest("verifyLastNameFieldByEnteringAlphaChar");
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
		checkoutPage.enterLastName("Kohli");		
		checkoutPage.clickOnContinueButton();
		String msg=checkoutPage.displayingErrorMessage();
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: Postal Code is required");
		softAssert.assertAll();
	}
	@Test(priority=6)
	public void verifyLastNameFieldByEnteringNumber() {		
		test = extent.createTest("verifyLastNameFieldByEnteringNumber");
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
		checkoutPage.enterLastName("12345");		
		checkoutPage.clickOnContinueButton();
	    checkoutPage.displayingErrorMessage();
	    SoftAssert softAssert= new SoftAssert();
	    softAssert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: Last Name is required only character");
	    softAssert.assertAll();
	}
	@Test(priority=7)
	public void verifyLastNameFieldByEnteringSpecialCharacters() {	
		test = extent.createTest("verifyLastNameFieldByEnteringSpecialCharacters");
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
		checkoutPage.enterLastName("%#@#");		
		checkoutPage.clickOnContinueButton();
	    checkoutPage.displayingErrorMessage();
	    SoftAssert softAssert= new SoftAssert();
	    softAssert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: Last Name is required only character");
	    softAssert.assertAll();
	}
	@Test(priority=8)
	public void verifyLastNameFieldByEnteringAlphaCharactersAndNumbers() {	
		test = extent.createTest("verifyLastNameFieldByEnteringAlphaCharactersAndNumbers");
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
		checkoutPage.enterLastName("Virat123");		
		checkoutPage.clickOnContinueButton();
	    checkoutPage.displayingErrorMessage();
	    SoftAssert softAssert= new SoftAssert();
	    softAssert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: Last Name is required only character");
	    softAssert.assertAll();
	}
	
	@Test(priority=9)
	public void verifyZipCodeFieldByEnteringValidNumber() {		
		test = extent.createTest("verifyZipCodeFieldByEnteringValidNumber");
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
		checkoutPage.enterLastName("Kohli");	
		checkoutPage.enterZipCode("442302");		
		checkoutPage.clickOnContinueButton();
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("checkout-step-two.html"));
	}
	@Test(priority=10)
	public void verifyZipCodeFieldByEnteringInvalidNumber() {
		test = extent.createTest("verifyZipCodeFieldByEnteringInvalidNumber");
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
		checkoutPage.enterLastName("Kohli");	
		checkoutPage.enterZipCode("4423");		
		checkoutPage.clickOnContinueButton();
		SoftAssert softAssert= new SoftAssert();
	    softAssert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: Zip Code is Invalid");
	    softAssert.assertAll();
	}
	@Test(priority=11)
	public void verifyZipCodeFieldByEnteringCharacter() {		
		test = extent.createTest("verifyZipCodeFieldByEnteringCharacter");
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
		checkoutPage.enterLastName("Kohli");	
		checkoutPage.enterZipCode("mahi");		
		checkoutPage.clickOnContinueButton();
		SoftAssert softAssert= new SoftAssert();
	    softAssert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: Zip Code is Invalid");
	    softAssert.assertAll();
	}
	@Test(priority=11)
	public void verifyZipCodeFieldByEnteringSpecialCharacter() {
		test = extent.createTest("verifyZipCodeFieldByEnteringSpecialCharacter");
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
		checkoutPage.enterLastName("Kohli");	
		checkoutPage.enterZipCode("@#$%");		
		checkoutPage.clickOnContinueButton();
		SoftAssert softAssert= new SoftAssert();
	    softAssert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: Zip Code is Invalid");
	    softAssert.assertAll();
	}
	@Test(priority=13)
	public void verifyContinueButtonWithoutInformation() {	
		test = extent.createTest("verifyContinueButtonWithoutInformation");
		SwaglabsLoginTest loginTest=new SwaglabsLoginTest();
		loginTest.loginWithValidCredentials();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.clickOnMultipleAddTocartbutton(2);
		productPage.clickOnShoppingCartButton(driver);
		CartPage cartPage=new CartPage(driver);
		cartPage.isProductDisplayedInCart(driver);
		cartPage.clickOnCheckoutButton();	
		CheckoutPage checkoutPage=new CheckoutPage(driver);		
		checkoutPage.clickOnContinueButton();
		Assert.assertEquals(checkoutPage.displayingErrorMessage(), "Error: First Name is required");
	}
	@Test(priority=14)
	public void verifyContinueButtonWithInformation() {		
		test = extent.createTest("verifyContinueButtonWithInformation");
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
		String currentUrl=driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("checkout-step-two.html"));
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
