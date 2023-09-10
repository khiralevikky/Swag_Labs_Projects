package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage {
	@FindBy (xpath="//div[@class='cart_item']")                             private List<WebElement> productList;
	@FindBy (xpath="//div[@class='cart_item']//a")                          private List<WebElement> productName;
	@FindBy (xpath="//div[@class='inventory_item_price']")                  private List<WebElement> productPrice;
	@FindBy (xpath="//div[@class='summary_subtotal_label']")                private WebElement itemTotal;
	@FindBy (xpath="//div[@class='summary_tax_label']")                     private WebElement tax;
	@FindBy (xpath="//div[@class='summary_info_label summary_total_label']")private WebElement total;
	@FindBy (xpath="//button[@id='finish']")                                private WebElement finish;
	@FindBy (xpath="//button[@id='cancel']")                                private WebElement cancel;
	@FindBy (xpath="//h2[text()='Thank you for your order!']")              private WebElement orderSuccess;
	
	public CheckoutOverviewPage(WebDriver driver) {
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
	public double checkProductPrice(int i,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productPrice));
		WebElement getPrice=productPrice.get(i);
		String text=getPrice.getText();	
		String s=text.substring(1);
		double price =Double.parseDouble(s);
		return price;
	}
	public double additionOfPrice(int i,WebDriver driver) {
		double num=0;
		double d=0;
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productPrice));			
		for(i=0;i<productPrice.size();i++) {
			String name=productPrice.get(i).getText();
			String s=name.substring(1);
			 d =Double.parseDouble(s);
	    	       num= num + d;  	    	   
		}		
		return num;		
	}
	public double checkItemTotal() {
		String itemtext=itemTotal.getText();
		String t=itemtext.substring(13);
		double itemtotal=Double.parseDouble(t);
		return itemtotal;
	}
	public double checkTaxPrice() {
		String itemtext=tax.getText();
		String t=itemtext.substring(6);
		double itemtotal=Double.parseDouble(t);
		return itemtotal;
	}
	public double checkTotalPrice() {
		String itemtext=total.getText();
		String s=itemtext.substring(8);
		double total=Double.parseDouble(s);
		return total;
	}
	public void clickOnFinishButton() {
		finish.click();
	}
	public void clickOnCancelButton() {
		cancel.click();
	}
	public String getTextOrderSuccess() {
		String success=orderSuccess.getText();
		return success;
	}
}




