package TestCase;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QaLegendDashboard;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendNotesPage;

public class QaLegend_TestCase extends BaseClass{
	public WebDriver driver;
	Properties props;
	FileReader reader;
	QaLegendLoginPage loginpage;
	QaLegendDashboard dashboardpage;
	QaLegendNotesPage notespage;
	String path="";
@BeforeMethod
	
	public void initialization() throws Exception {
	driver=browserInitialisation("chrome");
	loginpage=new QaLegendLoginPage(driver);
	dashboardpage=new QaLegendDashboard(driver);
	notespage=new QaLegendNotesPage(driver);
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
	notespage.addNotes(props.getProperty("NoteTitle"),props.getProperty("Description"));
	//System.out.println(System.getProperty("user.dir"));
	//System.out.println(path);
}
}
