package testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import genericlibrary.BaseTest;

public class RegisterTestCase extends BaseTest {

	@Test(groups = "system",dataProvider = "registerData")
	public void registerTestCase(String firstName,String lastName,String email,String password,String confirmPassword) throws Exception {
		
		driver.findElement(By.linkText("Log out")).click();
		
		// Step 1: Navigating to Register Page
		driver.findElement(By.partialLinkText("Regis")).click();

		// Step 2: Validate Register page is Displayed or not
		if (driver.getTitle().equals(data_Utility.getSingleDataFromExcel("PageTitles", 1, 1))) {
			System.out.println("Register Page Displayed..");
		} else
			System.out.println("Register Page not Displayed..");

		// Step 3: entering all the inputs and clickin on Register button
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.name("FirstName")).sendKeys(firstName);
		driver.findElement(By.name("LastName")).sendKeys(lastName);
		driver.findElement(By.name("Email")).sendKeys(utility_Methods.getRandomNumber()+email);
		driver.findElement(By.name("Password")).sendKeys(password);
		driver.findElement(By.name("ConfirmPassword")).sendKeys(confirmPassword);
		driver.findElement(By.name("register-button")).click();

		// Step 4: fetching the register sucessfull message
		String expText = driver.findElement(By.xpath("//div[@class='result']")).getText();

		// Step 5: Validating Register sucessfull or not
		if (expText.equals("Your registration completed")) {
			System.out.println("Register Test Case Pass");
		} else
			System.out.println("Register Test Case Fail");
	}
	
	@DataProvider(name = "registerData")
	public Object[][] dataSupply() throws EncryptedDocumentException, IOException
	{
		return data_Utility.getAllDataFromExcel("RegisterTestCase");
	}
	
}