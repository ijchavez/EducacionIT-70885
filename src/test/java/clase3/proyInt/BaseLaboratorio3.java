package clase3.proyInt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;

public class BaseLaboratorio3 {
	String url = "http://www.automationpractice.pl/";
	Faker faker;
	WebDriver driver;
	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		faker = new Faker();
	}
	@BeforeTest
	public void irUrl() {
		driver.get(url);
	}
	@BeforeClass
	public void maxVentana() {
		driver.manage().window().maximize();
	}
	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de Prueba");
	}
	@AfterTest
	public void finTest() {
		driver.close();
	}
	@AfterSuite
	public void finSuite() {
		System.out.println("Finalizo la suite de Prueba");
	}
}
