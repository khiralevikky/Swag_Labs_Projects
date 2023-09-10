package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	@FindBy (xpath="//input[@id='first-name']")  private WebElement firstName;
	@FindBy (xpath="//input[@id='last-name']")   private WebElement lastName;
	@FindBy (xpath="//input[@id='postal-code']") private WebElement zipCode;
	@FindBy (xpath="//input[@id='continue']")    private WebElement continueButton;
	@FindBy (xpath="//button[@id='cancel']")     private WebElement cancelButton;
	@FindBy (xpath="//h3[@data-test='error']")     private WebElement errorMessage;
	
	public CheckoutPage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	public void enterZipCode(String zipcode) {
		zipCode.sendKeys(zipcode);
	}
	public void clickOnContinueButton() {
		continueButton.click();
	}
	public void clickOnCancelButton() {
		cancelButton.click();
	}	
	public String displayingErrorMessage() {
		String errorMsg="";
		 errorMsg=errorMessage.getText();
		 return errorMsg;
		
	}
	
}
