package clase6;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import clase4.utilities.WaitUtilities;

public class Laboratio6punto1 {
	WebDriver driver;
	String url = "http://www.automationpractice.pl";
	
	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized", "incognito");		

		driver = new ChromeDriver(options);
		driver.get(url);
		
	}
	@Test
	public void searchItem() throws InterruptedException {
		WebElement searchItemInput = driver.findElement((By.id("search_query_top")));
		searchItemInput.sendKeys("t-shirts");

		WebElement searchButton = driver.findElement(By.name("submit_search"));
		searchButton.click();
		
		WebElement searchResult = WaitUtilities.waitForVisibility(driver, 10, driver.findElement(By.tagName("h1")));
		System.out.println(searchResult.getText());
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
}
