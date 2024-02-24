package clase4.proyInt2;

import org.testng.Assert;
import org.testng.annotations.Test;

import clase4.pages.LandingPage;
import clase4.pages.LoginPage;
import clase5.proyInt2.BaseLaboratorio5Alt;


public class Laboratorio4_E1 extends BaseLaboratorio5Alt {
	  @Test
	  public void  irRegistroLogin() {
			///---LANDING
			LandingPage landingPage = new LandingPage(driver);
		    LoginPage loginPage = landingPage.clickOnLoginLink();
		    
		    Assert.assertEquals(loginPage.getTitleTextFormText(), "AUTHENTICATION");
		    
	  }
	  @Test
	  public void  crearCuentaInvalida() {
			String invalidEmail = "*asda@asd";
		  
		    LandingPage landingPage = new LandingPage(driver);
		    LoginPage loginPage = landingPage.clickOnLoginLink();
		    
	        loginPage.sendKeysToEmailInput(invalidEmail);
	        loginPage.clickOnCreateAnAccountBtn();
		    
		    Assert.assertEquals(loginPage.getTitleTextFormText(), "AUTHENTICATION");
		    
	  }
}
