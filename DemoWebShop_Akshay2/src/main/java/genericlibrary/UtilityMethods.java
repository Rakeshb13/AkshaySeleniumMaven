package genericlibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class UtilityMethods {
	
	Select select;
	
	public int getRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(1000);
	}
	
	
	public void selectDropDownByValue(WebElement dropdown, String value) {
		select = new Select(dropdown);
		select.selectByValue(value);
	}

	public void selectDropDownByVisibleText(WebElement dropdown, String visibleText) {
		select = new Select(dropdown);
		select.selectByVisibleText(visibleText);
	}

	public boolean verifyIsDropDownIsMultiSelect(WebElement dropDown) {
		select = new Select(dropDown);
		return select.isMultiple();
	}

	public void deselectAllOptionsFromDropDown(WebElement dropDown) {
		if (verifyIsDropDownIsMultiSelect(dropDown)) {
			select = new Select(dropDown);
			select.deselectAll();
		} else
			System.out.println("Can't Deselect Options from Single Select Dropdown");
	}

	public void deselectDropDownByValue(WebElement dropdown, String value) {
		select = new Select(dropdown);
		select.deselectByValue(value);
	}

	public void deselectDropDownByVisibleText(WebElement dropdown, String visibleText) {
		select = new Select(dropdown);
		select.deselectByVisibleText(visibleText);
	}
	
	public  void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void passValueToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	public void switchToWindow(WebDriver driver, String pageTitle) {
		
		Set<String> all_Session_Ids = driver.getWindowHandles();

		for (String session_Id : all_Session_Ids) {
			driver.switchTo().window(session_Id);
			if (driver.getTitle().equals(pageTitle)) {
				break;
			}
		}
	}
	
	public String getCurrentTime()
	{
		LocalDateTime l = LocalDateTime.now();
		return l.toString().replace("-", "/");
	}
	
	
	public void takeScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(FrameworkConstants.screenshot_Path+getCurrentTime()+".png");
		FileHandler.copy(src, trg);
	}
}