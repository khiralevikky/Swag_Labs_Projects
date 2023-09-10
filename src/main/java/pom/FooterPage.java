package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {
	@FindBy (xpath="//a[text()='Twitter']")        private WebElement twitter;
	@FindBy (xpath="//a[text()='Facebook']")       private WebElement facebook;
	@FindBy (xpath="//a[text()='LinkedIn']")       private WebElement linkdin;
	@FindBy (xpath="//div[@class='footer_copy']")  private WebElement privacyPolicy;
	
	public FooterPage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }
	public void clickOnTwitter() {
	    twitter.click();
	}
	public void clickOnFacebook() {
		facebook.click();
	}
	public void clickOnLinkdin() {
		linkdin.click();
	}
	public String getChildWindowUrl(WebDriver driver) {
		String actualTitle="";
		Set<String> handles=driver.getWindowHandles();	
		Iterator<String> i=handles.iterator();		
		while(i.hasNext())
		{
			String handle=i.next();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.switchTo().window(handle);
		    actualTitle =driver.getCurrentUrl();
			//System.out.println(actualTitle);
		}
		return actualTitle;
	}
	public String getTextOfPrivacyPolicy() {
		String policy=privacyPolicy.getText();
		return policy;
	}
	
}
