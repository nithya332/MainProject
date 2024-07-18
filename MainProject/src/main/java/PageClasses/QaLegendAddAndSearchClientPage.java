package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtilities;

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
@FindBy(xpath="(//tr[@class='odd']//a)[1]")
WebElement clientnamesearch;
public QaLegendAddAndSearchClientPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void AddClient(String companyname,String address ) throws InterruptedException
{
	PageUtilities.clickOnElement(addclientbutton);
	PageUtilities.enterText(companynamefield, companyname);
	PageUtilities.enterText(addressfield, address);
	PageUtilities.clickOnElement(savebutton);
}
public void searchclient(String name) throws InterruptedException

{
	Thread.sleep(3000);
	/* WaitUtilities.waitForAnElementToBeVisible(driver, searchbutton); */
PageUtilities.clickOnElement(searchbutton);
PageUtilities.enterText(searchbutton, name);
 }

public String getClient() {
	  
	  String gettitle=PageUtilities.getElementText(clientnamesearch); 
	  return gettitle; }
	 
	}
