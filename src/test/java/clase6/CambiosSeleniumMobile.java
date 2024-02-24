package clase6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import clase6.utilities.Utilities;

import java.util.*;

public class CambiosSeleniumMobile {
	WebDriver driver;
	String url = "https://seleniumjavalocators.neocities.org/";
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		
		Utilities.devToolsCreateSession(driver);
		Utilities.setMobileMetrics(driver, 768, 858);
        
		driver.get(url);
		
	}

	@Test
	public void loginTest() {
		WebElement dropDown = driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']"));
		dropDown.click();
		
		WebElement loginLink = driver.findElement(By.id("loginLink"));
		loginLink.click();
		
		WebElement usernameInput = driver.findElement(By.name("username"));
		usernameInput.sendKeys("NombreCompleto");
		
		WebElement passwordInput = driver.findElement(By.name("passwd"));
		passwordInput.sendKeys("321Password123");
		
		WebElement mostrarMensajeBtn = driver.findElement(By.id("iniciarSesionBtn"));
		mostrarMensajeBtn.click();
		
		WebElement mensajeInicioSesion = driver.findElement(By.className("mensaje"));
		System.out.println(mensajeInicioSesion.getText());
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
}
