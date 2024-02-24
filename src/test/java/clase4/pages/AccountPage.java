package clase4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


import clase4.proyInt2.BaseLaboratorio4Alt;
import clase4.utilities.WaitUtilities;

public class AccountPage extends BaseLaboratorio4Alt{
	public AccountPage(WebDriver driver){
		 this.driver = driver;
		 PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	
	}

	@FindBy(css = "p.alert.alert-success")
	WebElement accountCreateOkMessage;
	public WebElement getAccountCreateOkMessage() {
	    WebElement accountCreatedOkMessageWithWait = WaitUtilities.waitForVisibility(driver, 5, accountCreateOkMessage);
		return accountCreatedOkMessageWithWait;
		
	}
	public boolean accountCreateOkMessageIsDisplayed() {
		return getAccountCreateOkMessage().isDisplayed();
		
	}
	public String getAccountCreateOkMessageText() {
		return getAccountCreateOkMessage().getText();
		
	}
	
}
