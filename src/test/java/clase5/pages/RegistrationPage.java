package clase5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;


import clase4.proyInt2.BaseLaboratorio4Alt;
import clase4.utilities.WaitUtilities;

public class RegistrationPage extends BaseLaboratorio4Alt{
	public RegistrationPage(WebDriver driver){
		 this.driver = driver;
		 PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	
	}

	@FindBy(xpath = "//*[contains(@id,'uniform-id_gender2')]")
	WebElement mrsRadioButton;
	public void clickOnMrsRadioButton() {
		WebElement mrsRadioButtonWithWait = WaitUtilities.waitForClickability(driver, 10, mrsRadioButton);
		mrsRadioButtonWithWait.click();
	
	}
	@FindBy(name = "customer_firstname")
	WebElement customerFirstNameInput;
	public void sendKeysToCustomerFirstNameInput(String firstName) {
	    WebElement customerFirstNameInputWithWait = WaitUtilities.waitForVisibility(driver, 5, customerFirstNameInput);
	    customerFirstNameInputWithWait.sendKeys(firstName);
		
	}
	@FindBy(name = "customer_lastname")
	WebElement customerLastNameInput;
	public void sendKeysToCustomerLastNameInput(String lastName) {
		WebElement customerLastNameInputWithWait = 	WaitUtilities.waitForVisibility(driver, 5, customerLastNameInput);
	    customerLastNameInputWithWait.sendKeys(lastName);
		
	}
	@FindBy(id = "passwd")
	WebElement passwordInput;
	public void sendKeysToPasswordInput(String password) {
	    WebElement passwordInputWithWait = WaitUtilities.waitForVisibility(driver, 5, passwordInput);	    
	    passwordInputWithWait.sendKeys(password);
		
	}
	@FindBy(id = "days")
	WebElement daySelect;
	public void setDay(String dayValue) {
		Select dayDropDown = new Select(daySelect);
	    dayDropDown.selectByValue(dayValue);
		
	}

	@FindBy(id = "months")
	WebElement monthSelect;
	public void setMonth(String monthValue) {
		Select monthDropDown = new Select(monthSelect);
		monthDropDown.selectByValue(monthValue);
		
	}
	@FindBy(id = "years")
	WebElement yearsSelect;
	public void setYear(String yearValue) {
		Select yearsDropDown = new Select(yearsSelect);
		yearsDropDown.selectByValue(yearValue);
		
	}
	public void setDateOfBirth(String dayValue, String monthValue, String yearValue) {
		setDay(dayValue);
		setMonth(monthValue);
		setYear(yearValue);
		
	}
	@FindBy(xpath = "//*[text()='Title']")
	WebElement titleLabel;
	public String getTitleLabelText() {
	    WebElement titleLabelWithWait = WaitUtilities.waitForVisibility(driver, 5, titleLabel);
 	    return titleLabelWithWait.getText();
	    
	}
	@FindBy(xpath = "//*[@name='submitAccount']")
	WebElement submitAccountBtn;
	public void clickOnSubmitAccountBtn() {
	    WebElement submitAccountBtnWithWait = WaitUtilities.waitForClickability(driver, 5, submitAccountBtn);
	    submitAccountBtnWithWait.click();
	    
	}

}
