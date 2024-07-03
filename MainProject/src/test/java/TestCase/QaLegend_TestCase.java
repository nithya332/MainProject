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
import PageClasses.QaLegendAddClientPage;
import PageClasses.QaLegendDashboard;
import PageClasses.QaLegendEditNotes;
import PageClasses.QaLegendForgotPassword;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendMessagePage;
import PageClasses.QaLegendNotesPage;

public class QaLegend_TestCase extends BaseClass{
	public WebDriver driver;
	Properties props;
	FileReader reader;
	QaLegendLoginPage loginpage;
	QaLegendDashboard dashboardpage;
	QaLegendNotesPage notespage;
	QaLegendMessagePage messagepage;
	QaLegendAddClientPage addclient;
	QaLegendForgotPassword forgotPasswordPage;
	QaLegendEditNotes editnotesdetails;
	String path="";
	Random rand;
@BeforeMethod
	
	public void initialization() throws Exception {
	driver=browserInitialisation("chrome");
	loginpage=new QaLegendLoginPage(driver);
	dashboardpage=new QaLegendDashboard(driver);
	notespage=new QaLegendNotesPage(driver);
	messagepage=new QaLegendMessagePage(driver);
	addclient=new QaLegendAddClientPage(driver);
	forgotPasswordPage=new QaLegendForgotPassword(driver);
	editnotesdetails=new QaLegendEditNotes(driver);
	rand = new Random();
	driver.manage().window().maximize();
	props=new Properties();
	 path=System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\TestData.properties";
	//reader= new FileReader("C:\\Users\\nithy\\eclipse-workspace\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
	reader=new FileReader(path);
	 props.load(reader);
	driver.get(props.getProperty("url"));
	}
@Test
public void loginToQaLegendApp()
{
	System.out.println("Testcase1");
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.clickonnotesoption();
	String notetitle=props.getProperty("NoteTitle")+ rand.nextInt(10000);
	notespage.addNotes(notetitle,props.getProperty("Description"));
	notespage.searchNotes(notetitle);
	org.testng.Assert.assertEquals(notespage.getNoteTitle(), notetitle);
	//System.out.println(System.getProperty("user.dir"));
	//System.out.println(path);
}
@Test
public void sendmessage()
{
	System.out.println("Testcase2");
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.messagemenuoption();
	messagepage.addMessages(props.getProperty("To"),props.getProperty("Subject"),props.getProperty("Message"));
	/*
	 * messagepage.addMessages(props.getProperty("Subject"),props.getProperty(
	 * "Message"));
	 */
}
@Test
public void addclientdetails()
{
	System.out.println("Testcase2");
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.addclientoption();
	addclient.AddClient(props.getProperty("CompanyName"),props.getProperty("AddressField"));
}
@Test
public void forgotPasswordLink() {
	forgotPasswordPage.forgotPasswordVerification(props.getProperty("username"));
	String emailSentNotification = props.getProperty("emailSentNotification");
	/*Assert.assertEquals(forgotPasswordPage.getForgotPasswordStatus(), emailSentNotification);*/
	org.testng.Assert.assertEquals(forgotPasswordPage.getForgotPasswordStatus(),true);
	
}
@Test
public void editdetailsnote()
{
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
	dashboardpage.clickonnotesoption();
	editnotesdetails.editnotes(props.getProperty("Title"),props.getProperty("NoteDescription"));
}
}
