package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwaglabsLoginPage {
	    @FindBy (xpath="//input[@id='user-name']")    private WebElement email;
	    @FindBy (xpath="//input[@id='password']")     private WebElement pass;
	    @FindBy (xpath="//input[@id='login-button']") private WebElement login;
	    
	    public SwaglabsLoginPage(WebDriver driver) {
	    	PageFactory.initElements(driver,this);
	    }   
	    public void enterUserName(String id,WebDriver driver) {
	    	WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
			wait.until(ExpectedConditions.visibilityOf(email));
	    	email.sendKeys(id);
	    }
	    public void enterPassword(String password,WebDriver driver) {
	    	WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
			wait.until(ExpectedConditions.visibilityOf(pass));
	    	pass.sendKeys(password);
	    }
	    public void clickOnLogin(WebDriver driver) {
	    	WebDriverWait wait=new WebDriverWait(driver , Duration.ofMillis(3000));
			wait.until(ExpectedConditions.visibilityOf(login));
	    	login.click();
	    }
}
