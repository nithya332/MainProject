package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendMessagePage {
WebDriver driver;
@FindBy(xpath="//a[@class='list-group-item'][1]")
WebElement compose;
@FindBy(xpath="//input[@class='form-control']")
WebElement subject;
@FindBy(id="s2id_to_user_id")
WebElement tobutton;
@FindBy(xpath="//div[@id='select2-drop']//input")
WebElement tosearch;
@FindBy(xpath="//div[@class='select2-result-label']")
WebElement tonamesearch;
@FindBy(xpath="//textarea[@class='form-control']")
WebElement sendmessage;
@FindBy(xpath="//span[@class='fa fa-send']")
WebElement sendbutton;
@FindBy(xpath="//a[text()='Sent items']")
WebElement sentitems;
@FindBy(xpath="//div[@class='media-body']")
WebElement sentmessages;
@FindBy(xpath="(//div[@id='message-details-section']//p)[2]")
WebElement sentmessagedetail;

public QaLegendMessagePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


public void addMessages(String namesearch, String subuser,String descriptionmessage)
{
	PageUtilities.clickOnElement(compose);
	PageUtilities.clickOnElement(tobutton);
	/* PageUtilities.clickOnElement(tosearch); */
	PageUtilities.enterText(tosearch, namesearch);
	PageUtilities.clickOnElement(tonamesearch);
	PageUtilities.enterText(subject, subuser);

	  PageUtilities.enterText(sendmessage, descriptionmessage);
	  PageUtilities.clickOnElement(sendbutton);
	 
}

public void sentitems() throws InterruptedException
{
	Thread.sleep(5000);
	PageUtilities.clickOnElement(sentitems);
}

public String getMessageAddStatus() {
	PageUtilities.clickOnElement(sentmessages);
String getmessage=PageUtilities.getElementText(sentmessagedetail);
return getmessage;
}
}

