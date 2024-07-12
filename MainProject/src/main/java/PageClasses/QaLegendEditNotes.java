package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendEditNotes {

WebDriver driver;
@FindBy(xpath="//div[@id='note-table_filter']//input")
WebElement search;
@FindBy(xpath="//a[@class='edit']//i[1]")
WebElement editbutton;
@FindBy(xpath="//input[@id='title']")
WebElement edittitle;
/* @FindBy(xpath="//textarea[@id='description']") */
@FindBy(xpath="//textarea[@id='description']")
WebElement editdescription;
@FindBy(xpath="//span[@class='fa fa-check-circle']")
WebElement saveeditbutton;
@FindBy(xpath="//strong[text()='Obsqura72999']")
WebElement editedtitle;
public QaLegendEditNotes(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public void editnotes(String title,String description)
{
	PageUtilities.clickOnElement(search);
	 PageUtilities.clickOnElement(editbutton); 
		/*
		 * PageUtilities.enterText(editbutton, editnamesearch);
		 */
	 PageUtilities.clickOnElement(edittitle);
	 PageUtilities.clearText(edittitle);
	PageUtilities.enterText(edittitle, title);
	PageUtilities.clickOnElement(editdescription);
	PageUtilities.clearText(editdescription);
	PageUtilities.enterText(editdescription, description);
	PageUtilities.clickOnElement(saveeditbutton);
}

public String getEditNoteStatus() {
	PageUtilities.clickOnElement(editbutton);
	String geteditnote=PageUtilities.getElementText(editedtitle);
	return geteditnote;
}
}

