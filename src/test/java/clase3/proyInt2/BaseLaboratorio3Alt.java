package clase3.proyInt2;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.github.javafaker.Faker;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;


public class BaseLaboratorio3Alt {
	String url = "http://www.automationpractice.pl/";
	Faker faker;
	WebDriver driver;
	@BeforeSuite
	public void inicioSuite() {
		System.out.println("Inicio de la suite de pruebas");
	}
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		faker = new Faker();
		
		driver.get(url);
		driver.manage().window().maximize();	
	}
	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de Prueba");
	}
	@AfterMethod
	public void finTest(ITestContext context) throws IOException {
		takeScreenshot(driver, context);
		driver.close();
		
	}
	@AfterSuite
	public void finSuite() {
		System.out.println("Finalizo la suite de Prueba");
		
	}
	
	public void takeScreenshot(WebDriver driver, ITestContext context) throws IOException {
		LocalDateTime datetime = LocalDateTime.now();
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File ("..\\ProyectoIntegrador\\Evidencias\\" + datetime.getNano() + "_" + context.getName() + "_image.png"));
	
	}
}
