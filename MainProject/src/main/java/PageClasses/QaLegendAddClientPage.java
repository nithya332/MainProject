package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendAddClientPage {

WebDriver driver;
@FindBy(xpath="//a[@class='btn btn-default']")
WebElement addclientbutton;
@FindBy(id="company_name")
WebElement companynamefield;
@FindBy(id="address")
WebElement addressfield;
@FindBy(xpath="//button[@class='btn btn-primary']")
WebElement savebutton;

public QaLegendAddClientPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void AddClient(String companyname,String address )
{
	PageUtilities.clickOnElement(addclientbutton);
	PageUtilities.enterText(companynamefield, companyname);
	PageUtilities.enterText(addressfield, address);
	PageUtilities.clickOnElement(savebutton);
}
}
