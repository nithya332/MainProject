package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendAddAndSearchClientPage {

WebDriver driver;
@FindBy(xpath="//a[@class='btn btn-default']")
WebElement addclientbutton;
@FindBy(id="company_name")
WebElement companynamefield;
@FindBy(id="address")
WebElement addressfield;
@FindBy(xpath="//button[@class='btn btn-primary']")
WebElement savebutton;
@FindBy(xpath="//div[@id='client-table_filter']//input")
WebElement searchbutton;
@FindBy(xpath="//a[@class='edit'][1]")
WebElement clientnamesearch;
public QaLegendAddAndSearchClientPage(WebDriver driver) {
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
public String searchclient(String clientsearch)

{
PageUtilities.clickOnElement(searchbutton);
PageUtilities.enterText(clientnamesearch, clientsearch);
return clientsearch;

}

public String getClient() {
	  
	  String gettitle=PageUtilities.getElementText(clientnamesearch); return gettitle; }
	 
	}
