package genericlibrary;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListernersImplementation  implements ITestListener, ISuiteListener{

	@Override
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ts = (TakesScreenshot)BaseTest.listernersDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(FrameworkConstants.screenshot_Path+result.getName()+".png");
		try {
			FileHandler.copy(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}