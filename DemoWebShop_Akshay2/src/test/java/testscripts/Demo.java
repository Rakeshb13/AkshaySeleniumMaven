package testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
//		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
//		Date date=cal.getTime();
//		System.out.println(date);
//		SimpleDateFormat formate = new SimpleDateFormat("YYYY-MM-dd");
//		String modData=formate.format(date);
//		System.out.println(modData);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/shadow/closed?sublist=1");
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.moveByOffset(720, 251).click().perform();
		
		act.sendKeys("Rakesh").perform();
		
		
	}
}
