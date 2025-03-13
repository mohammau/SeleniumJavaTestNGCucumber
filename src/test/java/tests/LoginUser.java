package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AccountDeletedPage;
import pageObjects.LandingPage;
import pageObjects.LoggedInUserPage;
import pageObjects.PopUpMessages;
import pageObjects.SignInRegistorPage;
import resources.Base;

public class LoginUser extends Base {
	
	
	WebDriver driver ;
	
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		 driver = initializeDriver();
		 driver.get(prop.getProperty("URL"));
	}
	
	@Test(dataProvider="loginData")
	public void Login(String UN, String Password, String Expected) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		PopUpMessages pum = new PopUpMessages(driver);
		
		pum.popUpMessage().click();
		
		LandingPage lp12 = new LandingPage(driver);
		lp12.loginSignUP().click();
		
		SignInRegistorPage sr1 = new SignInRegistorPage(driver);
		AssertJUnit.assertTrue(sr1.signinHeader().isDisplayed());
		sr1.emailLogin().sendKeys(UN);
		sr1.passwordLogin().sendKeys(Password);
		
		sr1.loginCTA().click();
			
		
		
		LoggedInUserPage lup = new LoggedInUserPage(driver);
		String actual = null;
		
		try {
			
			if(lup.LoggedInUserText().isDisplayed()) {
				
				actual = "Success";
				String loggedInText = lup.LoggedInUserText().getText();
				System.out.println("Text" + loggedInText);
				
				AssertJUnit.assertEquals(loggedInText, "Logged in as Mohammad Ummar");
				
				lup.DeleteAccountCTA().click();
				
				AccountDeletedPage adp = new AccountDeletedPage(driver);
				adp.accountDeletedText().isDisplayed();
				
			} }catch (Exception e) {
				
				actual = "Failure";
			}
		
		AssertJUnit.assertEquals(Expected, actual);
		
	
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] loginData() {
		
		Object [][] data = {{"test77@9690.com","Ummar@1234", "Success"}, {"test77@9690.com", "Umar123", "Failure"}};
		return data;
		
			
		}
	}
	
	


