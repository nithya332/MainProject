package TestCase;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;
import PageClasses.QaLegendLoginPage;

public class QaLegend_TestCase extends BaseClass{
	public WebDriver driver;
	Properties props;
	FileReader reader;
	QaLegendLoginPage loginpage;
@BeforeMethod
	
	public void initialization() throws Exception {
	driver=browserInitialisation("chrome");
	loginpage=new QaLegendLoginPage(driver);
	driver.manage().window().maximize();
	props=new Properties();
	reader= new FileReader("C:\\Users\\nithy\\eclipse-workspace\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
	props.load(reader);
	driver.get(props.getProperty("url"));
	}
@Test
public void loginToQaLegendApp()
{
	System.out.println("Testcase1");
	loginpage.LoginQALegendPage(props.getProperty("username"),props.getProperty("password"));
}
}
