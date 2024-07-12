package TestCase;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QaLegendAddAndSearchClientPage;
import PageClasses.QaLegendAddEvent;
import PageClasses.QaLegendDashboard;
import PageClasses.QaLegendEditNotes;
import PageClasses.QaLegendExcelDownload;
import PageClasses.QaLegendForgotPassword;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendMessagePage;
import PageClasses.QaLegendNotesPage;
import PageClasses.QaLegendOpenTaskListDashboard;
import Utilities.MyRetry;

public class QaLegend_TestCase extends BaseClass{
	public WebDriver driver;
	Properties props;
	FileReader reader;
	QaLegendLoginPage loginpage;
	QaLegendDashboard dashboardpage;
	QaLegendNotesPage notespage;
	QaLegendMessagePage messagepage;
	QaLegendAddAndSearchClientPage addclient;
	QaLegendForgotPassword forgotPasswordPage;
	QaLegendEditNotes editnotesdetails;
	QaLegendOpenTaskListDashboard viewopentask;
	QaLegendExcelDownload DownloadTask;
	QaLegendAddEvent eventadd;
	String path="";
	Random rand;
@BeforeMethod
	
	public void initialization() throws Exception {
	driver=browserInitialisation("chrome");
	loginpage=new QaLegendLoginPage(driver);
	dashboardpage=new QaLegendDashboard(driver);
	notespage=new QaLegendNotesPage(driver);
	messagepage=new QaLegendMessagePage(driver);
	addclient=new QaLegendAddAndSearchClientPage(driver);
	forgotPasswordPage=new QaLegendForgotPassword(driver);
	editnotesdetails=new QaLegendEditNotes(driver);
	viewopentask=new QaLegendOpenTaskListDashboard(driver);
	DownloadTask=new QaLegendExcelDownload(driver);
	eventadd=new QaLegendAddEvent(driver);
	rand = new Random();
	driver.manage().window().maximize();
	props=new Properties();
	 path=System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\TestData.properties";
	//reader= new FileReader("C:\\Users\\nithy\\eclipse-workspace\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
	reader=new FileReader(path);
	 props.load(reader);
	driver.get(props.getProperty("url"));
	}
@Test(retryAnalyzer = MyRetry.class)

public void loginToQaLegendApp()
{
	System.out.println("Testcase1");
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.clickonnotesoption();
	String notetitle=props.getProperty("NoteTitle")+ rand.nextInt(10000);
	notespage.addNotes(notetitle,props.getProperty("Description"));
	notespage.searchNotes(notetitle);
	/* org.testng.Assert.assertEquals(notespage.getNoteTitle(), notetitle); */
	//System.out.println(System.getProperty("user.dir"));
	//System.out.println(path);
}
@Test(retryAnalyzer = MyRetry.class)

public void sendmessage() throws InterruptedException
{
	System.out.println("Testcase2");
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.messagemenuoption();
	messagepage.addMessages(props.getProperty("To"),props.getProperty("Subject"),props.getProperty("Message"));
	messagepage.sentitems();
	 org.testng.Assert.assertEquals(messagepage.getMessageAddStatus(),props.getProperty("Message"));
	
	
}
@Test(retryAnalyzer = MyRetry.class)

public void addclientdetails()
{
	System.out.println("Testcase2");
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.addclientoption();
	addclient.AddClient(props.getProperty("CompanyName"),props.getProperty("AddressField"));
    String clientname=addclient.searchclient(props.getProperty("SearchClientName"));
   org.testng.Assert.assertEquals(addclient.getClient(),clientname);
}
@Test(retryAnalyzer = MyRetry.class)

public void forgotPasswordLink() {
	forgotPasswordPage.forgotPasswordVerification(props.getProperty("username"));
	String emailSentNotification = props.getProperty("emailSentNotification");
	/*Assert.assertEquals(forgotPasswordPage.getForgotPasswordStatus(), emailSentNotification);*/
	org.testng.Assert.assertEquals(forgotPasswordPage.getForgotPasswordStatus(),true);
	
}
@Test(retryAnalyzer = MyRetry.class)

public void editdetailsnote()
{
	System.out.println("Testcase2");
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.clickonnotesoption();
	editnotesdetails.editnotes(props.getProperty("EditTitle"),props.getProperty("NoteDescription"));
    org.testng.Assert.assertEquals(editnotesdetails.getEditNoteStatus(), props.getProperty("EditTitle"));
}

@Test(retryAnalyzer = MyRetry.class)

public void opentasklist()
{
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.clickondashboard();
	
}
@Test(retryAnalyzer = MyRetry.class)

public void teammemberslist() throws InterruptedException
{
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.teammembersoption();
}
@Test(retryAnalyzer = MyRetry.class)

public void downloadexceloption()
{
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	DownloadTask.ExcelDownload();
}
@Test(retryAnalyzer = MyRetry.class)


public void viewsentitems() throws InterruptedException
{
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.messagemenuoption();
	messagepage.sentitems();
}

@Test(retryAnalyzer = MyRetry.class)

public void eventaddoption()
{
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.eventoption();
	eventadd.eventaddoption(props.getProperty("EventTitle"),props.getProperty("EventDesc"),props.getProperty("StartDate"),props.getProperty("StartTime"),props.getProperty("EndDate"),props.getProperty("EndTime"));
}
}
