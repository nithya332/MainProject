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
	@FindBy(xpath="//div[@class='widget-details']//h1[1]")
	WebElement opentask;
	
	@FindBy(xpath="//div[@id='income-expense']//canvas[2]")
	WebElement expense;
	@FindBy(xpath="//span[text()='Events']")
	WebElement Eventmenu;
	@FindBy(xpath="//span[text()='Notes']")
	WebElement Notesmenu;
	@FindBy(xpath="//span[text()='Messages']")
	WebElement Messagemenu;
	@FindBy(xpath="//span[text()='Clients']")
	WebElement Clientmenu;
	@FindBy(xpath="//span[text()='Team members']")
	WebElement Teammember;
	@FindBy(xpath="//span[text()='Projects']")
	WebElement Projects;
	@FindBy(xpath="//span[text()='Tasks']")
	WebElement taskmenu;
	
	public QaLegendDashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickondashboard()
	{
		PageUtilities.clickOnElement(Dashboardmenu);
		PageUtilities.clickOnElement(opentask);
		
	}
	public void clickonnotesoption()
	{
	PageUtilities.clickOnElement(Notesmenu);		
}
	public void messagemenuoption()
	{
		PageUtilities.clickOnElement(Messagemenu);
	}
	public void addclientoption()
	{
		PageUtilities.clickOnElement(Clientmenu);
	}
	
	public void teammembersoption() throws InterruptedException
	{
		Thread.sleep(5000);
		PageUtilities.clickOnElement(Teammember);
	}
	
	public void eventoption()
	{
		PageUtilities.clickOnElement(Eventmenu);
	}
	
	public void project()
	{
		PageUtilities.clickOnElement(Projects);
		PageUtilities.clickOnElement(taskmenu);
	}
	
	public Boolean getViewStatus() {
		boolean successmessage = PageUtilities.isElementDisplayed(opentask);
		return successmessage;
	}
}

