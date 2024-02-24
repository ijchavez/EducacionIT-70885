package clase2.proyInt;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;


public class Laboratorio2 {
	String url = "http://www.automationpractice.pl/";
	Faker faker;
	
	@Test
	public void lab2_dosPuntoUno() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement searchInput = driver.findElement(By.xpath("//*[@id='search_query_top']"));
		searchInput.sendKeys("dress");
		searchInput.sendKeys(Keys.ENTER);
		
	    Thread.sleep(3000);
		
		driver.close();
	}
	@Test
	public void lab2_E1() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		faker = new Faker();
		
		driver.get(url);
		driver.manage().window().maximize();
		
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
	    
	    //<option value="4">April&nbsp;</option>
	    //-------ByValue----ByVisibleText------
	    
	    WebElement years = driver.findElement(By.id("years"));
	    Select yearsDropDown = new Select(years);
	    yearsDropDown.selectByValue("1994");
	    
	    Wait<WebDriver> titleWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement title = titleWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Title']"))));
	    
	    System.out.println(title.getText());
	    
	    Wait<WebDriver> submitAccountWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement submitAccountBtn = submitAccountWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@name='submitAccount']"))));
	    submitAccountBtn.click();
	    
	    Thread.sleep(3000);
	    
		driver.close();
	}
}
