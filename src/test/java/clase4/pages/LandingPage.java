package clase4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import clase4.proyInt2.BaseLaboratorio4Alt;

public class LandingPage extends BaseLaboratorio4Alt{
	public LandingPage(WebDriver driver){
		 this.driver = driver;
		 PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	
	}

	@FindBy(className = "login")
	WebElement loginLink;
	public LoginPage clickOnLoginLink() {
		loginLink.click();
		
		LoginPage lp = new LoginPage(driver);
		return lp;
		
	}
}
