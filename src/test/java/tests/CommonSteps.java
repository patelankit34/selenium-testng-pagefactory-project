package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.*;


public class CommonSteps {
	
	protected WebDriver driver;
	protected String baseUrl;
	
	@BeforeTest
	@Parameters({"browser", "baseUrl"})
	protected void beforeTest(String browserName, String baseUrl)
	{
		this.baseUrl = baseUrl;
		launchBrowser(browserName);
		Reporter.log("Browser (" + browserName + ") launched", true);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Reporter.log("Implicit wait implemented", true);
	}
	
	@AfterTest
	protected void afterTest()
	{
		driver.quit();
		Reporter.log("Browser and session quit", true);
	}
	
	@BeforeMethod
	protected void beforeMethod() {
		driver.manage().deleteAllCookies();
		Reporter.log("Cookies deleted", true);
	}
	
	private void launchBrowser(String browserName) {
		if(browserName.toLowerCase().contains("firefox")) {
			if(System.getProperty("webdriver.gecko.driver") == null){
	        	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/browser drivers/geckodriver.exe");	
	        	driver = new FirefoxDriver();
	        }
		}
		else if(browserName.toLowerCase().contains("chrome")) {
			if(System.getProperty("webdriver.chrome.driver") == null){
	        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browser drivers/chromedriver.exe");
	        	driver = new ChromeDriver();
	        }
		}
		else if(browserName.toLowerCase().contains("ie")) {
			if(System.getProperty("webdriver.ie.driver") == null){
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
	        	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/browser drivers/IEDriverServer.exe");
	        	driver = new InternetExplorerDriver(capabilities);
	        }
		}
		else if(browserName.toLowerCase().contains("edge")) {
			if(System.getProperty("webdriver.edge.driver") == null){
	        	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/browser drivers/MicrosoftWebDriver.exe");
	        	driver = new EdgeDriver();
	        }
		}
	}
	@AfterSuite
	public void AfterSuit(){
		System.out.println("This should run After Suit");
	}
	@BeforeSuite
	public void BeforeSuit(){
		System.out.println("This should run Before Suit");
	}
}
