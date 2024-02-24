package clase3.proyInt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Laboratorio3 extends BaseLaboratorio3{

	@Test
	public void registroUsuario() throws InterruptedException{
		WebElement loginBtn = driver.findElement(By.className("login"));
		loginBtn.click();
		
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
	 
	    Wait<WebDriver> passwordWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement passwordInput = passwordWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("passwd"))));
	    passwordInput.sendKeys(faker.name().lastName());		 
		 
	    WebElement day = driver.findElement(By.id("days"));
	    Select dayDropDown = new Select(day);
	    dayDropDown.selectByValue("14");
	    
	    WebElement month = driver.findElement(By.id("months"));
	    Select monthDropDown = new Select(month);
	    monthDropDown.selectByValue("4");
	    
	    WebElement years = driver.findElement(By.id("years"));
	    Select yearsDropDown = new Select(years);
	    yearsDropDown.selectByValue("1994");
	    
	    Wait<WebDriver> titleWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement title = titleWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Title']"))));
	    
	    System.out.println(title.getText());
	    
	    Wait<WebDriver> submitAccountWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement submitAccountBtn = submitAccountWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='submitAccount']"))));
	    submitAccountBtn.click();
    
	    Wait<WebDriver> accountCreatedOkMessageWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement accountCreatedOkMessage = accountCreatedOkMessageWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p.alert.alert-success"))));
	    
	    Assert.assertTrue(accountCreatedOkMessage.isDisplayed(), "el elemento no tiene propiedad display");
	    Assert.assertEquals(accountCreatedOkMessage.getText(), "Your account has been created.", "el mensajes no es el indicado");
	    //para el 3.1 Assert.assertEquals(accountCreatedOkMessage.getText(), "You successfully created an account, Welcome!", "el mensajes no es el indicado");

	}
	
}
