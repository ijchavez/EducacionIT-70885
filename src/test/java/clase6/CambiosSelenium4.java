package clase6;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.IOException;

public class CambiosSelenium4 {
	WebDriver driver;
	String url = "https://seleniumjavalocators.neocities.org/";
	
	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");		

		driver = new ChromeDriver(options);
		driver.get(url);
		
	}
	@Test
	public void locatorRelativo() {
		WebElement h2SubTitle = driver.findElement(By.id("article-subtitle"));
		WebElement parrafoSuperior = driver.findElement(with(By.tagName("p")).above(h2SubTitle));
		WebElement parrafoDebajo = driver.findElement(with(By.tagName("p")).below(h2SubTitle));

		System.out.println(parrafoSuperior.getText());
		System.out.println(h2SubTitle.getText());
		System.out.println(parrafoDebajo.getText());
		
	}
	@Test
	public void tabTest() throws InterruptedException {
		System.out.println(driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url + "/pages/registro");
		
		System.out.println(driver.getTitle());
		
	}
	@Test
	public void windowTest() throws InterruptedException {
		System.out.println(driver.getTitle());
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get(url + "/pages/scroll-page");

		System.out.println(driver.getTitle());
		
	}
	@Test
	public void screenshotFromElementTest() throws IOException {
		WebElement city = driver.findElement(By.xpath("//*[@alt='second']"));
		
		File file=city.getScreenshotAs(OutputType.FILE);
		File destFile = new File("city.png");
		FileUtils.copyFile(file,destFile);
	
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
}
