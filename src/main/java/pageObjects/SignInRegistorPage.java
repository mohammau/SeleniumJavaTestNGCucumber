package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInRegistorPage {
	
	WebDriver driver;
	
	public SignInRegistorPage(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//input[@data-qa=\"signup-name\"]")
	private WebElement nameSignUp ;
	
	@FindBy(xpath="//input[@data-qa=\"signup-email\"]")
	private WebElement emailSignUp ;
	
	@FindBy(xpath ="//button[@data-qa=\"signup-button\"]")
	private WebElement signUpCTA ;
	
	@FindBy(xpath="//h2[text()='New User Signup!']")
	private WebElement registrationHeader;
	
	@FindBy(xpath="//h2[text()='Login to your account']")
	private WebElement signinHeader ;
	
	@FindBy(xpath="//input[@data-qa=\"login-email\"]")
	private WebElement emailLogin;
	
	@FindBy(xpath="//input[@data-qa=\"login-password\"]")
	private WebElement passwordLogin;
	
	@FindBy(xpath="//button[@data-qa=\"login-button\"]")
	private WebElement loginCTA;
	
	
	public WebElement nameSignUp() {
			
			return nameSignUp;
		}
	
	
	public WebElement emailSignUp() {
		
		return emailSignUp;
	}
	
	public WebElement signUpCTA() {
		
		return signUpCTA ;
	}
	
	public WebElement registrationHeader() {
		
		return registrationHeader ;
	}
	
	public WebElement signinHeader() {
		
		return signinHeader ;
	}
	
	public WebElement emailLogin() {
		
		return emailLogin ;
	}
	
	public WebElement passwordLogin() {
		
		return passwordLogin ;
	}
	
	public WebElement loginCTA() {
			
			return loginCTA ;
	}

	
}
