package clase3;

import org.testng.annotations.*;

public class Anotaciones {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BEFORE SUITE");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("BEFORE TEST");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("BEFORE CLASS");
	}
	int beforeMethodI = 0;
	@BeforeMethod
	public void beforeMethod() {
		beforeMethodI++;
		System.out.println("BEFORE METHOD " + beforeMethodI);
	}
	//dependsOnMethods ejecutara este test si y solo si los tests que se encuentra en este parametro son exitosos.
	@Test(priority = 2, description = "TEST NUMERO UNO", dependsOnMethods="testTres")
	public void testUno() {
		System.out.println("TEST UNO");
	}
	@Test(priority = 3, description = "TEST NUMERO DOS")
	public void testDos() {
		System.out.println("TEST DOS");
	}
	@Test(description = "TEST NUMERO TRES")
	public void testTres() {
		System.out.println("TEST TRES");
	}
	int afterMethodI = 0;
	@AfterMethod
	public void afterMethod() {
		afterMethodI++;
		System.out.println("AFTER METHOD " + afterMethodI);
	}
	@AfterClass
	public void afterClass() {
		System.out.println("AFTER CLASS");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("AFTER TEST");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("AFTER SUITE");
	}
}
