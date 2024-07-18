package TestCase;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QaLegendAddAndSearchClientPage;

import PageClasses.QaLegendAddTask;
import PageClasses.QaLegendDashboard;
import PageClasses.QaLegendEditNotes;
import PageClasses.QaLegendExcelDownload;

import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendMessagePage;
import PageClasses.QaLegendNotesPage;

import Utilities.ExcelUtility;
import Utilities.MyRetry;
import Utilities.PageUtilities;

public class QaLegend_TestCase extends BaseClass{
	public WebDriver driver;
	Properties props;
	FileReader reader;
	QaLegendLoginPage loginpage;
	QaLegendDashboard dashboardpage;
	QaLegendNotesPage notespage;
	QaLegendMessagePage messagepage;
	QaLegendAddAndSearchClientPage addclient;
	QaLegendEditNotes editnotesdetails;
	QaLegendAddTask addtask;
	String path="";
	Random rand;
@BeforeMethod
@Parameters("browser")
	public void initialization(String browser) throws Exception {
	driver=browserInitialisation(browser);
	loginpage=new QaLegendLoginPage(driver);
	dashboardpage=new QaLegendDashboard(driver);
	notespage=new QaLegendNotesPage(driver);
	messagepage=new QaLegendMessagePage(driver);
	addclient=new QaLegendAddAndSearchClientPage(driver);
	editnotesdetails=new QaLegendEditNotes(driver);
	addtask=new QaLegendAddTask(driver);
	rand = new Random();
	PageUtilities.maximizewindow(driver);
	props=new Properties();
	path=System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\TestData.properties";
	reader=new FileReader(path);
	props.load(reader);
	driver.get(props.getProperty("url"));
	}

@Test(retryAnalyzer = MyRetry.class)

public void AddNote() throws InterruptedException

{
	
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.clickonnotesoption();
	String notetitle=props.getProperty("NoteTitle")+ rand.nextInt(10000);
	notespage.addNotes(notetitle,props.getProperty("Description"));
	notespage.searchNotes(notetitle,driver);
	org.testng.Assert.assertEquals(notespage.getNoteTitle(), notetitle); 
	
}
@Test(retryAnalyzer = MyRetry.class)

public void composemessage() throws InterruptedException, IOException

{
	
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.messagemenuoption();
    messagepage.addMessages(props.getProperty("To"),props.getProperty("Subject"), props.getProperty("Message"));
	messagepage.sentitems();
	org.testng.Assert.assertEquals(messagepage.getMessageAddStatus(),props.getProperty("Message"));
	
	}



@Test(retryAnalyzer = MyRetry.class)
public void addclientdetails() throws IOException, InterruptedException
{
	
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.addclientoption();
	String CompanyName=ExcelUtility.getString(1, 0, props.getProperty("ExcelPath"), "AddClient")+ rand.nextInt(10000);
	String AddressField=ExcelUtility.getString(1, 1, props.getProperty("ExcelPath"), "AddClient")+ rand.nextInt(10000);
	addclient.AddClient(CompanyName,AddressField);
	addclient.searchclient(CompanyName);
	org.testng.Assert.assertEquals(addclient.getClient(),CompanyName);
	 
}



@Test(retryAnalyzer = MyRetry.class)
public void editdetailsnote() throws InterruptedException

{
	
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.clickonnotesoption();
	String notetitle=props.getProperty("NoteTitle")+ rand.nextInt(10000);
	notespage.addNotes(notetitle,props.getProperty("Description"));
    notespage.searchNotes(notetitle,driver);
	String edittitle=props.getProperty("EditTitle")+ rand.nextInt(10000);
	editnotesdetails.editnotes(edittitle,props.getProperty( "NoteDescription"));
	notespage.searchNotes(edittitle,driver);
	org.testng.Assert.assertEquals(notespage.getNoteTitle(),edittitle);
	 
}


@Test(dataProvider = "testData",retryAnalyzer = MyRetry.class)
public void addtask(String tasktitle,String Project) throws InterruptedException
{
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.project();
	addtask.AddTask(tasktitle,Project); 
	addtask.searchtask(tasktitle);
	org.testng.Assert.assertEquals(addtask.getAddTaskStatus(),tasktitle); 
}

@DataProvider(name="testData")
public Object[][] testDataFeed(){
	Object[][] dataSet = new Object[2][2];
	dataSet[0][0] = "Task Project11";
	dataSet[0][1] = "TestProject";
	dataSet[1][0] = "Task Project12";
	dataSet[1][1] = "TestProject";
	return dataSet;


}
/*
 * @AfterMethod public void teardown() { driver.quit();
 * 
 * }
 */



}
