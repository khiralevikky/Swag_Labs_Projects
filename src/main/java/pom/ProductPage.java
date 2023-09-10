package pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	@FindBy (xpath="//a[@class='shopping_cart_link']")           private WebElement shoopingCart;
	@FindBy (xpath="//span[@class='shopping_cart_badge']")       private WebElement shoopingCartCount;
	@FindBy (xpath="//select[@class='product_sort_container']")  private WebElement productFilter;
	@FindBy (xpath="//button[@id='react-burger-menu-btn']")      private WebElement menu;
	@FindBy (xpath="//a[@id='about_sidebar_link']")              private WebElement about;
	@FindBy (xpath="//a[@id='logout_sidebar_link']")             private WebElement logout;
	@FindBy (xpath="//div[@class='inventory_item']")             private List<WebElement> products;
	@FindBy (xpath="//div[@class='inventory_item_label']//a")    private List<WebElement> productName;
	@FindBy (xpath="//div[@class='inventory_item_img']//a")      private List<WebElement> productImage;
	@FindBy (xpath="//div[@class='inventory_item_price']")       private List<WebElement> price;
	@FindBy (xpath="//div[@class='pricebar']//button")           private List<WebElement> addToCartButton;
	@FindBy (xpath="//div[@class='pricebar']//div")              private List<WebElement> productPrice;
	@FindBy (xpath="//button[text()='Remove']")                  private List<WebElement> removeButton;
	
		
	public ProductPage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }
	
	public boolean isProductDisplayed(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(products));		
		boolean result;
		if(products.size() > 0) {
			result = true;
		}
		else {
			result =false;
		}
		return result;
	}	
	public void checkProductNameList(int i) {
    	for(i=1;i<productName.size();i++) {
			String name=productName.get(i).getText();
			System.out.println(name);
		}	
	}
	public void moveToProductName(int i, WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productName));
		WebElement product=productName.get(i);
		Actions action=new Actions(driver);
		action.moveToElement(product);
		action.perform();
	}
	public void clickOnProductName(int i) {
		WebElement name=productName.get(i);
		name.click();
	}
	public void clickOnProductImage(int i) {
		WebElement name=productImage.get(i);
		name.click();
	}
	
	public void clickOnAddTocartbutton(int i) {
		WebElement cartbutton=addToCartButton.get(i);
		cartbutton.click();	
	}
	public void clickOnMultipleAddTocartbutton(int b) {
		for(int i=0;i<b;i++) {	
		    WebElement cartbutton=addToCartButton.get(i);
		    cartbutton.click();	
		}
	}
	public String getTextOfRemoveButton(int i, WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(removeButton));
		String buttonText="";
		buttonText=removeButton.get(i).getText();
		return buttonText;
	}
	public String getTextOfAddToCartButton(int i, WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(addToCartButton));
		String buttonText="";
		buttonText=addToCartButton.get(i).getText();
		return buttonText;
	}
   public void clickOnRemoveButton(int i, WebDriver driver) {
	    WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(6000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(removeButton));
	    WebElement product=removeButton.get(i);
	    product.click();
   }
   
   public void clickOnFilter(int i,WebDriver driver){
		WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productFilter));
		productFilter.click();
	    Select select=new Select(productFilter);				
		select.selectByIndex(i);	
   }
   public void clickOnShoppingCartButton(WebDriver driver) {
	    WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(shoopingCart));
	    shoopingCart.click();
   }
   public int countShoopingCart(WebDriver driver) {
	    WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(shoopingCartCount));
	    String text=shoopingCartCount.getText();
	    int count =Integer.parseInt(text);
	    return count;
   }
   public boolean getCountOfRemoveButton(int i,WebDriver driver) {
	    WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
	    wait.until(ExpectedConditions.visibilityOfAllElements(removeButton));
		boolean result;
		if(removeButton.size() > 1) {
			result = true;
		}
		else {
			result =false;
		}
		return result;
	}
   public void clickOnMenu() {
	    menu.click();
   }
   public void clickOnAbout() {
	    about.click();
   }
   public void clickOnLogout() {
	    logout.click();
   }  
  public ArrayList<Double> productPriceAfterSorted() {	
	    double price; 
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < productPrice.size(); i++) { 
			String name=productPrice.get(i).getText();	
			String s=name.substring(1);
			 price =Double.parseDouble(s);
		     list.add((double) price);   		
		} 			
		//System.out.println(list); 
		return list;
  }

  public ArrayList<Double> productPriceSortLowToHigh() 
  {
		double price; 
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < productPrice.size(); i++) { 
				String name=productPrice.get(i).getText();	
				String s=name.substring(1);
				 price =Double.parseDouble(s);
			     list.add((double) price);   		
		} 			
		Collections.sort(list);
		//System.out.println(list); 	
		return list;
  }
  public ArrayList<Double> productPriceSortHighToLow() {
		double price; 
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < productPrice.size(); i++) { 
				String name=productPrice.get(i).getText();	
				String s=name.substring(1);
				 price =Double.parseDouble(s);
			     list.add((double) price);   		
		} 					
		Collections.sort(list, Collections.reverseOrder());
		//System.out.println(list); 	
		return list;
  }
  
  public ArrayList<String> productNameSortedAtoZBeforeClick() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < productName.size(); i++) { 
				String name=productName.get(i).getText();				
			    list.add(name);   		
		} 					
		Collections.sort(list);
		System.out.println(list); 	
		return list;
   }
  public ArrayList<String> productNameSortedZtoABeforeClick() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < productName.size(); i++) { 
				String name=productName.get(i).getText();				
			    list.add(name);   		
		} 					
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list); 	
		return list;
 }
  public ArrayList<String> productNameSortedList() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < productName.size(); i++) { 
				String name=productName.get(i).getText();				
			    list.add(name);   		
		} 					
		System.out.println(list); 	
		return list;
 }
}







