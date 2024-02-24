package clase4.proyInt2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.github.javafaker.Faker;

import clase4.utilities.Utilities;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class BaseLaboratorio4Alt {
	String url = "http://www.automationpractice.pl/";
	Faker faker;
	public WebDriver driver;
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
	public void finTest(ITestContext context) throws IOException, InvalidFormatException {
		LocalDateTime datetime = LocalDateTime.now();
		String dateTestName = datetime.getNano() + "_" + context.getName();
		String imgPath = "..\\ProyectoIntegrador\\Evidencias\\png\\" + dateTestName + "_image.png";
		
		Utilities.takeScreenshot(driver, imgPath);
		Utilities.createDocxFile(driver, "Documento_de_evidencias" + dateTestName + ".docx", imgPath);
		
		driver.close();
		
	}
	@AfterSuite
	public void finSuite() {
		System.out.println("Finalizo la suite de Prueba");
		
	}
	
}
