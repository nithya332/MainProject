package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendLoginPage {
WebDriver driver;
	@FindBy(id="email")
WebElement usernamefield;
	@FindBy(id="password")
WebElement passwordfield;
	@FindBy(xpath="//button[text()='Sign in']")
WebElement SignInButton;
	
	
	
	public QaLegendLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}






	public void LoginQALegendPage(String username,String Password) {
		PageUtilities.enterText(usernamefield, username);
		PageUtilities.enterText(passwordfield, Password);
		PageUtilities.clickOnElement(SignInButton);
	}
	
	
	
	
	
}
