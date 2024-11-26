package CrossBroswer;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class CrossBrowser {

	@Parameters ("browser")
    @Test(groups = {"firefox"})
	public void Test(@Optional("safari") String browser) {
	
		System.out.println("Current Thread ID "+Thread.currentThread().getId());
		
		System.out.println("Current Thread Name "+Thread.currentThread().getName());
		
		System.out.println("Current Thread Priority "+Thread.currentThread().getPriority());
		
		WebDriver driver=Util.launchBrowser(browser, "https://testng.org/#_parameters");
		
		Assert.assertTrue(driver.getTitle().contains("TestNG"),"Title mismatch");

		driver.quit();

	}
}
