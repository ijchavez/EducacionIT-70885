package clase4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import clase4.proyInt2.BaseLaboratorio4Alt;
import clase4.utilities.WaitUtilities;


public class LoginPage extends BaseLaboratorio4Alt{
	public LoginPage(WebDriver driver){
		 this.driver = driver;
		 PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	
	}
	@FindBy(id = "email_create")
	WebElement emailCreateInput;
	public void sendKeysToEmailInput(String email) {
		WebElement emailCreateInputWithWait = WaitUtilities.waitForVisibility(driver, 5, emailCreateInput);
		emailCreateInputWithWait.sendKeys(email);
		
	}
	@FindBy(id = "SubmitCreate")
	WebElement createAnAccountBtn;
	public void clickOnCreateAnAccountBtn() {
		WebElement createAnAccountBtnWithWait = WaitUtilities.waitForClickability(driver, 5, createAnAccountBtn);
	    createAnAccountBtnWithWait.click();
	    
	}
	@FindBy(className = "page-heading")
	WebElement titleTextForm;
	public WebElement getTitleTextForm() {
		return titleTextForm;
		
	}
    public String getTitleTextFormText() {
    	return getTitleTextForm().getText();
    	
    }
	@FindBy(id = "email")
	WebElement emailLoginInput;
	public void sendKeysToEmailLoginInput(String loginEmail) {
		WebElement emailLoginInputWithWait = WaitUtilities.waitForVisibility(driver, 5, emailLoginInput);
		emailLoginInputWithWait.sendKeys(loginEmail);
		
	}
	@FindBy(id = "passwd")
	WebElement passwordLoginInput;
	public void sendKeysToPasswordLoginInput(String loginPassword) {
		WebElement passwordLoginInputWithWait = WaitUtilities.waitForVisibility(driver, 5, passwordLoginInput);
		passwordLoginInputWithWait.sendKeys(loginPassword);
		
	}
	@FindBy(id = "SubmitLogin")
	WebElement submitLoginBtn;
	public void clickOnSubmitLoginBtn() {
		submitLoginBtn.click();
		
	}
}
