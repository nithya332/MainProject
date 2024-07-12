package AutomationCore;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class BaseClass {
	public WebDriver driver;
	public WebDriver browserInitialisation(String BrowserName) throws Exception
	{
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid Name exception");
		}
	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
}
	public String getScreenshotPath(String testcasename, WebDriver driver) throws IOException {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String destinationfile=System.getProperty("user.dir")+"\\test-output\\"+testcasename+".png";
        Files.copy(source, new File(destinationfile));
        return destinationfile;
    }

}