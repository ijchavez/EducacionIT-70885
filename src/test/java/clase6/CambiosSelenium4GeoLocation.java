package clase6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import clase6.utilities.Utilities;

public class CambiosSelenium4GeoLocation {
	WebDriver driver;
	String url = "https://my-location.org/";
	
	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");		

		driver = new ChromeDriver(options);
		
		Utilities.setCoordinates(driver, -32.889458, -68.84584);
		driver.get(url);
		
	}
	@Test
	public void geoLocationTest() throws InterruptedException {
		WebElement location = driver.findElement(By.xpath("//td[@valign='top']//tr"));
		System.out.println(location.getText());
		
		WebElement address = driver.findElement(By.id("address"));
		WebElement latitude = driver.findElement(By.id("latitude"));
		WebElement longitude = driver.findElement(By.id("longitude"));
		
		Assert.assertTrue(address.getText().contains("Mendoza, Argentina"));
		
		Assert.assertEquals(latitude.getText(), "-32.889458");
		Assert.assertEquals(longitude.getText(), "-68.84584");	
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
}
