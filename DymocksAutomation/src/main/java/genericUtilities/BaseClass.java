package genericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.DymocksLoginPage_Repo;
import objectRepository.signoutPage;

public class BaseClass {
	
	public WebDriver driver;
	@BeforeSuite
	public void BS()
	{
		System.out.println("BeforeSuite events");
	}
	@BeforeTest
	public void BT()
	{
		System.out.println("BeforeTest events");
	}
	@BeforeClass
	public void BC() throws Throwable
	{
		PropertyFile plib = new PropertyFile();
		String Browser = plib.getPropertydata("browser");
		
		if(Browser.equalsIgnoreCase("chrome"))
    	{
 		  WebDriverManager.chromedriver().setup();
 		  driver=new ChromeDriver();
 	  }
 	  else if(Browser.equalsIgnoreCase("firefox"))
 	  {
 		 WebDriverManager.firefoxdriver().setup();
 		 driver=new FirefoxDriver(); 
 	  }
 	  else if(Browser.equalsIgnoreCase("edge"))
 	  {
 		  WebDriverManager.edgedriver().setup();
 		  driver=new EdgeDriver(); 
 	  }
 	  else
 	  {
 		 driver=new ChromeDriver();
 	  }
		driver.manage().window().maximize();
    System.out.println("Browser Launch event done");
	}
	@BeforeMethod
	public void BM() throws Throwable
	{
		PropertyFile plib = new PropertyFile();
		String URL = plib.getPropertydata("url");
		String username = plib.getPropertydata("username");
		String passowrd = plib.getPropertydata("password");	
		driver.get(URL);
		WebUtilityFile wlib = new WebUtilityFile();
		wlib.waitPageToLoad(driver);
		DymocksLoginPage_Repo loginObj = new DymocksLoginPage_Repo(driver);		
		loginObj.DymocksLogin(username, passowrd);
		
		System.out.println("Login into the dymocks successful");
	}
	
	@AfterMethod	
	public void AM(ITestResult res) throws IOException
	{
		int status = res.getStatus();
		if(status==2)
		{
			String Filename = res.getMethod().getMethodName();

			TakesScreenshot ts  =  (TakesScreenshot)this.driver;
			File srcFile =  ts.getScreenshotAs(OutputType.FILE);
			//String scrFilename = srcFile.toString();

			File destFile = new File("./Screenshot/"+Filename+".jpg");
			//String destFilename = destFile.toString();

			FileUtils.copyFile(srcFile, destFile);				
			System.out.println("Screenshot captured for"+Filename);
		}
		
		//Creating reference variable of Signout page
		signoutPage signOut = new signoutPage(driver);
		signOut.signoutDymocks(driver);
		System.out.println("Logging out of Dymocks page");
	}
	
	@AfterClass
	public void AC()
	{
		driver.quit();
		System.out.println("Closing the browser");
	}
	@AfterTest
	public void AT()
	{
		
	}	
	@AfterSuite
	public void AS()
	{
		
	}	
}
