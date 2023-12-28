package testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;

public class EmptyCartTestCase extends BaseTest {

	@Test(groups = "smoke")
	public void emptyCartTestCase() {

		// Step 6: To navigate to shopping cart
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

		// Step 7: Locating all the remove check box
		List<WebElement> allRemoveCheckBox = driver
				.findElements(By.xpath("//tr[@class='cart-item-row']//input[@type='checkbox']"));

		// Step 8: Locating all the remove check box
		if (allRemoveCheckBox.size() > 0) {
			for (WebElement removeCheckBox : allRemoveCheckBox) {
				removeCheckBox.click();
			}
			driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
			allRemoveCheckBox = driver.findElements(By.xpath("//tr[@class='cart-item-row']//input[@type='checkbox']"));

			if (allRemoveCheckBox.size() == 0) {
				System.out.println("Empty Cart Test Case Pass..");
			} else
				System.out.println("Empty Cart Test Case Fail..");
		} else
			System.out.println("Empty Cart Test Case Pass..");
	}
}
