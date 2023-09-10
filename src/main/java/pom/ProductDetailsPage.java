package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
   @FindBy (xpath="//button[text()='Add to cart']")                   private WebElement addToCart;
   @FindBy (xpath="//button[text()='Remove']")                        private WebElement productRemove;
   @FindBy (xpath="//div[@class='inventory_details_name large_size']")private WebElement productName;
	
   public ProductDetailsPage (WebDriver driver) {
   	PageFactory.initElements(driver,this);
   }
   
   public void verifyProductName() {
	   
   }
   
   public void clickOnAddToCardButton() {
	   addToCart.click();
   }
   public void clickOnRemoveButton(WebDriver driver) {
	   WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productRemove));
	   productRemove.click();
   }
   public String getTextOfRemoveButton(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productRemove));
		String buttonText="";
		buttonText=productRemove.getText();
		return buttonText;
	}
   public String getTextOfAddToCartButton(WebDriver driver) {
	   WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
	   wait.until(ExpectedConditions.visibilityOfAllElements(addToCart));
	   String buttonText="";
	   buttonText=addToCart.getText();
	   return buttonText;
   }
}
