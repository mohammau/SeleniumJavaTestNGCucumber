package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInUserPage {
	
	WebDriver driver ;
	
	public LoggedInUserPage(WebDriver driver) {
		
		this.driver = driver ;
		
		PageFactory.initElements(driver, this);
		
		
		
	}

	
	@FindBy(xpath="//li/a[contains(text(),'Logged in as')]")
	private WebElement LoggedInUserText ;
	
	@FindBy(xpath="//a[@href=\"/delete_account\"]")
	private WebElement DeleteAccountCTA ;
	
	public WebElement LoggedInUserText() {
		
		return LoggedInUserText ;
	}
	
	public WebElement DeleteAccountCTA() {
		
		return DeleteAccountCTA;
	}
	
}

