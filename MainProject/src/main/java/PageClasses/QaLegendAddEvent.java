package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendAddEvent {
	
	WebDriver driver;
	@FindBy(xpath="//span[text()='Events']")
	WebElement eventmenu;
	@FindBy(xpath="//div[@class='title-button-group']//a[1]")
	WebElement addeventbutton;
	@FindBy(xpath="//input[@id='title']")
	WebElement eventtitle;
	@FindBy(xpath="//textarea[@id='description']")
	WebElement eventdesc;
	@FindBy(xpath="//input[@id='start_date']")
	WebElement startdate;
	@FindBy(xpath="//input[@id='start_time']")
	WebElement starttime;
	@FindBy(xpath="//input[@id='end_date']")
	WebElement enddate;
	@FindBy(xpath="//input[@id='end_time']")
	WebElement endtime;
	@FindBy(xpath="//button[text()=' Save']")
	WebElement saveevent;
	public QaLegendAddEvent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void eventaddoption(String title,String descr,String datestr,String timestr,String dateend ,String timend)
	{
	
		PageUtilities.clickOnElement(addeventbutton);
		PageUtilities.enterText(eventtitle, title);
		PageUtilities.enterText(eventdesc, descr);
		PageUtilities.enterText(startdate, datestr);
		PageUtilities.enterText(starttime, timestr);
		PageUtilities.enterText(enddate, dateend);
		PageUtilities.enterText(endtime, timend);
		PageUtilities.clickOnElement(saveevent);
	}
}

