package genericlibrary;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
@Listeners(genericlibrary.ListernersImplementation.class)
public class BaseTest {
	
	public WebDriver driver;
	public static WebDriver listernersDriver;
	public DataUtility data_Utility = new DataUtility();
	public UtilityMethods utility_Methods = new UtilityMethods();
	
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite()
	{
		
	}
	
	@BeforeTest(alwaysRun = true)
	public void beforeTest()
	{
		
	}
	
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("Chrome")String browser) throws Exception
	{
		
		if(browser.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else 
			System.out.println("Please enter a valid browser name");
		
		listernersDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(data_Utility.getDataFromProperties("url"));
	}
	
	@BeforeMethod(alwaysRun = true)
	public void performLogin() throws Exception
	{
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(data_Utility.getDataFromProperties("email"));
		driver.findElement(By.id("Password")).sendKeys(data_Utility.getDataFromProperties("password"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod(alwaysRun = true)
	public void performLogout()
	{
		driver.findElement(By.linkText("Log out")).click();
		
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	}
	
	@AfterTest(alwaysRun = true)
	public void afterTest()
	{
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite()
	{
		
	}
}