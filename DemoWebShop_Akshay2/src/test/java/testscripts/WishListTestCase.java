package testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;

public class WishListTestCase extends BaseTest {

	//@Parameters("asdfgh")
	@Test(groups = "integration")
	public void wishListTestCase() {
		
		// Step 1: Books page is displayed
		driver.findElement(By.partialLinkText("Books")).click();

		// Step 2 : Validate books page is displayed or not
		if (driver.getTitle().equals("Demo Web Shop. Books")) {
			System.out.println("Books page is displayed");
		} else
			System.out.println("Books downloads page is not displayed");

		// Step 3: Clicking on Fiction EX product and adding the product to wishlist
		WebElement product = driver.findElement(By.linkText("Fiction EX"));
		String productName = product.getText();
		product.click();
		driver.findElement(By.xpath("//input[@value='Add to wishlist']")).click();

		// Step 4: Navigating Wish List Product
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();

		// Step 5 : Locating the product present in the Wish list page
		WebElement wishListProduct = driver.findElement(By.xpath("//a[text()='Fiction EX']"));

		// Step 6 : Validating the product added to wish list or not
		if (wishListProduct.getText().equals(productName)) {
			System.out.println("Wish List Test Case Pass..");
		} else
			System.out.println("Wish List Test Case Fail..");

		// Step 7: Removing the product from the wish list
		List<WebElement> allRemoveCheckBox = driver.findElements(By.xpath("//td[@class='remove-from-cart']/input"));

		for (WebElement checkBox : allRemoveCheckBox) {
			checkBox.click();
		}
		driver.findElement(By.xpath("//input[@value='Update wishlist']")).click();

	}
}