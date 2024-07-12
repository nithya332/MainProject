package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendOpenTaskListDashboard {
	
	WebDriver driver;
	@FindBy(xpath="//div[@id='upcoming-event-container']//div[1]")
	WebElement opentask;
	
public QaLegendOpenTaskListDashboard(WebDriver driver) {
		
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
	}

}
