package stepDefinitions;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import pageObjects.AccountDeletedPage;
import pageObjects.LandingPage;
import pageObjects.LoggedInUserPage;
import pageObjects.SignInRegistorPage;
import resources.Base;

public class LoginUser extends Base {
	
	
	WebDriver driver ;
	
	
	@BeforeMethod
	@BeforeMethod
	public void setUp() throws IOException {
		
		 driver = initializeDriver();
		 driver.get(prop.getProperty("URL"));
	}
	
	public void Login() {
		
		LandingPage lp12 = new LandingPage(driver);
		lp12.loginSignUP().click();
		
		SignInRegistorPage sr1 = new SignInRegistorPage(driver);
		AssertJUnit.assertTrue(sr1.signinHeader().isDisplayed());
		sr1.emailLogin().sendKeys(prop.getProperty("LoginEmail"));
		sr1.passwordLogin().sendKeys(prop.getProperty("LoginPassword"));
		sr1.loginCTA().click();
		
		LoggedInUserPage lup = new LoggedInUserPage(driver);
		String loggedInText = lup.LoggedInUserText().getText();
		AssertJUnit.assertEquals(loggedInText, "Logged in as Mohammad Ummar");
		
		lup.DeleteAccountCTA().click();
		
		AccountDeletedPage adp = new AccountDeletedPage(driver);
		adp.accountDeletedText().isDisplayed();
		
	}
	
	

}
