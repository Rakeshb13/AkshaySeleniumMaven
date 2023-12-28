package genericlibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
	
	JavascriptExecutor java_Script;
	
	public void scrollTillWebElement(WebDriver driver, WebElement element)
	{
		java_Script = (JavascriptExecutor) driver;
		java_Script.executeScript("arguments[0].scrollIntoView(false);", element);
	}
	
	public void click(WebDriver driver, WebElement element)
	{
		java_Script = (JavascriptExecutor) driver;
		java_Script.executeScript("arguments[0].click();", element);
	}
	
	public void scrollDown(WebDriver driver)
	{
		java_Script = (JavascriptExecutor) driver;
		java_Script.executeScript("window.scrollBy(0,500);");
	}
	
	public void scrollUp(WebDriver driver)
	{
		java_Script = (JavascriptExecutor) driver;
		java_Script.executeScript("window.scrollBy(0,-500);");
	}

	public void passValue(WebDriver driver, WebElement element, String value)
	{
		java_Script = (JavascriptExecutor) driver;
		java_Script.executeScript("arguments[0].value='"+value+"'", element);
	}

}
