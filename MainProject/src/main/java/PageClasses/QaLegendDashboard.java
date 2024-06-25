package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendDashboard {
	
	

	
	WebDriver driver;
	@FindBy(xpath ="//span[text()='Dashboard']")
	WebElement Dashboardmenu;
	@FindBy(xpath="//span[text()='Events']")
	WebElement Eventmenu;
	@FindBy(xpath="//span[text()='Notes']")
	WebElement Notesmenu;
	@FindBy(xpath="//span[text()='Messages']")
	WebElement Messagemenu;
	@FindBy(xpath="//span[text()='Clients']")
	WebElement Clientmenu;
	
	public QaLegendDashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickonnotesoption()
	{
	PageUtilities.clickOnElement(Notesmenu);		
}
}
