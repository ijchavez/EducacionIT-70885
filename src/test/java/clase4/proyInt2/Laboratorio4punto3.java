package clase4.proyInt2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Laboratorio4punto3 {
	String url = "http://www.automationpractice.pl/";
	
	@Test
	public void laboratorio1Ej1(){
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}
	
}
