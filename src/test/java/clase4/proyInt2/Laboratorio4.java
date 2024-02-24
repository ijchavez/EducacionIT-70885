package clase4.proyInt2;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import clase4.pages.*;


public class Laboratorio4 extends BaseLaboratorio4Alt{

	@Test(description = "Registro de usuario")
	public void registroUsuario() throws InterruptedException{
		///---LANDING
		LandingPage landingPage = new LandingPage(driver);
		//---LOGIN
        String emailAddress = faker.internet().emailAddress();
	    System.out.println(emailAddress);

	    LoginPage loginPage = landingPage.clickOnLoginLink();
        loginPage.sendKeysToEmailInput(emailAddress);
        
		loginPage.clickOnCreateAnAccountBtn();
	  
	    //--REGISTRO
		RegistrationPage registrationPage = new RegistrationPage(driver);
		
		registrationPage.clickOnMrsRadioButton();

		registrationPage.sendKeysToCustomerFirstNameInput(faker.name().firstName());
		registrationPage.sendKeysToCustomerLastNameInput(faker.name().lastName());
		
		Random rand = new Random(); 
		registrationPage.sendKeysToPasswordInput(faker.animal().name() + rand.nextInt(1000000));	 
 		 
	    //registrationPage.setDay("14");
	    //registrationPage.setMonth("4");
	    //registrationPage.setYear("1994");
	    
	    registrationPage.setDateOfBirth("14", "4", "1994");
	    	    
	    Assert.assertEquals(registrationPage.getTitleLabelText(), "Title");
	    
	    registrationPage.clickOnSubmitAccountBtn();
        
	    //AccountPage
	    AccountPage accountPage = new AccountPage(driver);
	    
	    Assert.assertTrue(accountPage.accountCreateOkMessageIsDisplayed(), "el elemento no tiene propiedad display");
	    Assert.assertEquals(accountPage.getAccountCreateOkMessageText(), "Your account has been created.", "el mensajes no es el indicado");
	    
	}
	@Test
	public void registroFallidoPassword() throws InterruptedException{
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickOnLoginLink();
		
	    Wait<WebDriver> emailCreateWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement emailCreateInput = emailCreateWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_create"))));
	    String emailAddress = faker.internet().emailAddress();
	    
	    System.out.println(emailAddress);
	    
	    emailCreateInput.sendKeys(emailAddress);
		
	    Wait<WebDriver> createAnAccountWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement createAnAccountBtn = createAnAccountWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("SubmitCreate"))));
	    createAnAccountBtn.click();
	  
	    Wait<WebDriver> mrsGenderWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement mrsRadioButton = mrsGenderWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'uniform-id_gender2')]")));
		mrsRadioButton.click();
	    
	    Wait<WebDriver> customerFirstNameWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement customerFirstNameInput = customerFirstNameWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("customer_firstname"))));
	    customerFirstNameInput.sendKeys(faker.name().firstName());
	 
	    Wait<WebDriver> customerLastNameWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement customerLastNameInput = customerLastNameWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("customer_lastname"))));
	    customerLastNameInput.sendKeys(faker.name().lastName());
	 		 
	    WebElement day = driver.findElement(By.id("days"));
	    Select dayDropDown = new Select(day);
	    dayDropDown.selectByValue("14");
	    
	    WebElement month = driver.findElement(By.id("months"));
	    Select monthDropDown = new Select(month);
	    monthDropDown.selectByValue("4");
	    
	    WebElement years = driver.findElement(By.id("years"));
	    Select yearsDropDown = new Select(years);
	    yearsDropDown.selectByValue("1994");
	    	    
	    Wait<WebDriver> submitAccountWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement submitAccountBtn = submitAccountWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='submitAccount']"))));
	    submitAccountBtn.click();
	    
	    //WebElement registerErrorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']//ol"));
	    WebElement registerErrorMessageDiv = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
	    WebElement registerErrorMessage = registerErrorMessageDiv.findElement(By.tagName("ol"));
	    
	    System.out.println(registerErrorMessage.getText());
	    Assert.assertEquals(registerErrorMessage.getText(), "passwd is required.", "El mensaje de error no es el esperado" );

	    Assert.assertTrue(true);
	    
	}
	@Test
	public void registroFallidoApellidoPassword() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickOnLoginLink();
		
	    Wait<WebDriver> emailCreateWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement emailCreateInput = emailCreateWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_create"))));
	    String emailAddress = faker.internet().emailAddress();
	    
	    System.out.println(emailAddress);
	    
	    emailCreateInput.sendKeys(emailAddress);
		
	    Wait<WebDriver> createAnAccountWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement createAnAccountBtn = createAnAccountWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("SubmitCreate"))));
	    createAnAccountBtn.click();
	  
	    Wait<WebDriver> mrsGenderWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement mrsRadioButton = mrsGenderWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'uniform-id_gender2')]")));
		mrsRadioButton.click();
	    
	    Wait<WebDriver> customerFirstNameWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement customerFirstNameInput = customerFirstNameWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("customer_firstname"))));
	    customerFirstNameInput.sendKeys(faker.name().firstName());
	 
	    WebElement day = driver.findElement(By.id("days"));
	    Select dayDropDown = new Select(day);
	    dayDropDown.selectByValue("14");
	    
	    WebElement month = driver.findElement(By.id("months"));
	    Select monthDropDown = new Select(month);
	    monthDropDown.selectByValue("4");
	    
	    WebElement years = driver.findElement(By.id("years"));
	    Select yearsDropDown = new Select(years);
	    yearsDropDown.selectByValue("1994");
	    	    
	    Wait<WebDriver> submitAccountWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement submitAccountBtn = submitAccountWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='submitAccount']"))));
	    submitAccountBtn.click();
	    
	    //WebElement registerErrorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']//ol"));
	    WebElement registerErrorMessageDiv = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
	    WebElement registerErrorMessage = registerErrorMessageDiv.findElement(By.tagName("ol"));
	    List<WebElement> registerErrorMessageList = registerErrorMessageDiv.findElements(By.tagName("li"));
	    
	    System.out.println(registerErrorMessage.getText());
	    Assert.assertEquals(registerErrorMessageList.get(0).getText(), "the lastname is required.", "El mensaje de error no es el esperado" );
	    Assert.assertEquals(registerErrorMessageList.get(1).getText(), "passwd is required.", "El mensaje de error no es el esperado" );
	    Assert.assertTrue(true);
	    
	    
	}
	
}
