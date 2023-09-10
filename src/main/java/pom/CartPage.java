package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	@FindBy (xpath="//div[@class='cart_item']")          private List<WebElement> productList;
	@FindBy (xpath="//div[@class='cart_item_label']//a") private List<WebElement> productName;
	@FindBy (xpath="//button[text()='Remove']")          private List<WebElement> removeButton;
	@FindBy (xpath="//button[@id='checkout']")           private WebElement checkoutButton;
	@FindBy (xpath="//button[@id='continue-shopping']")  private WebElement continueShoppingButton;
	
	public CartPage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }
	public boolean isProductDisplayedInCart(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productList));		
		boolean result;
		if(productList.size() > 0) {
			result = true;
		}
		else {
			result =false;
		}
		return result;
	}
	
	public void clickOnCheckoutButton() {
		checkoutButton.click();
	}
	public void clickOnContinueShooping() {
		continueShoppingButton.click();
	}
	public String getProductName(int i,WebDriver driver) {	   
		String	name=productName.get(i).getText();    
		return name;	
	}
	public void ClickOnProductNameLink(int i,WebDriver driver) {	  
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productName));
		WebElement product=productName.get(i);   	
		product.click();
	}
	public String getProductPrice(int i,WebDriver driver) {	   
		String	name=productName.get(i).getText();    
		return name;	
	}
	public void clickOnRemoveButton(int i, WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(6000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(removeButton));
		WebElement product=removeButton.get(i);
		product.click();
	}
	public boolean isProductCountInCart(WebDriver driver) {		
		boolean result;
		if(productList.size() <= 0) {
			result = true;
		}
		else {
			result =false;
		}
		return result;
	}
	
	
}
