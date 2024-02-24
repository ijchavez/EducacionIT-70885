package clase5.proyInt2;

import org.testng.Assert;
import org.testng.annotations.Test;

import clase4.pages.LandingPage;
import clase4.pages.LoginPage;


public class Laboratorio5 extends BaseLaboratorio5Alt {
	  @Test(dataProvider="usuariosInvalidos", dataProviderClass = clase5.dataProvider.DataProviderExample.class)
	  public void inicioSesionInvalido(String email, String password) {
			LandingPage landingPage = new LandingPage(driver);
		    LoginPage loginPage = landingPage.clickOnLoginLink();
		    
		    loginPage.sendKeysToEmailLoginInput(email);
		    loginPage.sendKeysToPasswordLoginInput(password);
		    
		    loginPage.clickOnSubmitLoginBtn();
		    
		    Assert.assertEquals(loginPage.getTitleTextFormText(), "AUTHENTICATION");
		    
	  }
	  @Test(dataProvider="usuariosInvalidosExcel", dataProviderClass = clase5.dataProvider.DataProviderExample.class)
	  public void inicioSesionInvalidoExcel(String email, String password) {
			LandingPage landingPage = new LandingPage(driver);
		    LoginPage loginPage = landingPage.clickOnLoginLink();
		    
		    loginPage.sendKeysToEmailLoginInput(email);
		    loginPage.sendKeysToPasswordLoginInput(password);
		    
		    loginPage.clickOnSubmitLoginBtn();
		    
		    Assert.assertEquals(loginPage.getTitleTextFormText(), "AUTHENTICATION");
		    
	  }
}
