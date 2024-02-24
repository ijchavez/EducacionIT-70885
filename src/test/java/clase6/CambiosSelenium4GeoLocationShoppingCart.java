package clase6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import clase6.utilities.LocatorType;
import clase6.utilities.Utilities;
import clase6.utilities.WaitUtilities;

import java.util.*;

public class CambiosSelenium4GeoLocationShoppingCart {
	WebDriver driver;
	String url = "https://oldnavy.gap.com/stores";
	
	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");		

		driver = new ChromeDriver(options);
		
		Utilities.setCoordinates(driver, 30.307982, -97.893803);
		driver.get(url);
		
	}
	@Test
	public void geoLocationTest() throws InterruptedException {
		List<WebElement> addressList = WaitUtilities.waitForListVisibilityByLocator(driver, 10, LocatorType.XPATH, "//div[@class='address']");
		Assert.assertTrue(addressList.size() > 0);
		
		for(WebElement address : addressList) {
			System.out.println(address.getText());
			System.out.println("================");
			
			Assert.assertTrue(address.getText().contains(", TX"));
			
		}
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
}
