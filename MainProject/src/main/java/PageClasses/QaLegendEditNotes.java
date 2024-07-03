package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendEditNotes {

WebDriver driver;
@FindBy(xpath="//a[@class='edit']//i[1]")
WebElement editbutton;
@FindBy(xpath="//input[@id='title']")
WebElement edittitle;
/* @FindBy(xpath="//textarea[@id='description']") */
@FindBy(xpath="//textarea[@id='description']")
WebElement editdescription;
@FindBy(xpath="//span[@class='fa fa-check-circle']")
WebElement saveeditbutton;

public QaLegendEditNotes(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public void editnotes(String title,String description)
{
	PageUtilities.clickOnElement(editbutton);
	PageUtilities.clickOnElement(edittitle);
	PageUtilities.enterText(edittitle, title);
	PageUtilities.clickOnElement(editdescription);
	PageUtilities.enterText(editdescription, description);
	PageUtilities.clickOnElement(saveeditbutton);
}
}
