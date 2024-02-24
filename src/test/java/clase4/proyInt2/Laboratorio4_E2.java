package clase4.proyInt2;

import org.testng.Assert;
import org.testng.annotations.Test;

import clase4.pages.LandingPage;
import clase4.pages.LoginPage;


public class Laboratorio4_E2 extends BaseLaboratorio4Alt {
	  @Test
	  public void  irRegistroLogin() {
			LandingPage landingPage = new LandingPage(driver);
		    LoginPage loginPage = landingPage.clickOnLoginLink();
		    
		    loginPage.sendKeysToEmailLoginInput("invalid@testmail.com");
		    loginPage.sendKeysToPasswordLoginInput("invalidPassword");
		    
		    loginPage.clickOnSubmitLoginBtn();
		    
		    Assert.assertEquals(loginPage.getTitleTextFormText(), "AUTHENTICATION");
		    
	  }
	  
}
