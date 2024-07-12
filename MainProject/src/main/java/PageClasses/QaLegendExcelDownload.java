package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendExcelDownload {

	
WebDriver driver;
@FindBy(xpath ="//span[text()='Dashboard']")
WebElement Dashboard;	
@FindBy(xpath="//span[text()='Items']")
WebElement ItemMenu;
@FindBy(xpath="//span[text()='Excel']")
WebElement ExcelButton;


public QaLegendExcelDownload(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void ExcelDownload()
{
	PageUtilities.clickOnElement(Dashboard);
	PageUtilities.clickOnElement(ItemMenu);
	PageUtilities.clickOnElement(ExcelButton);
}
}
