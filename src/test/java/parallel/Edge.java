package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Edge {

	
	WebDriver driver;

	@BeforeTest
	public void setUp() {
//	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void testTitle() {
	System.out.println("The thread ID for testTitle Edge is "+ Thread.currentThread().getId());
	Assert.assertEquals(driver.getTitle(), "Google");
	}

	@Test(priority = 2)
	public void clickOffers() throws InterruptedException {
	System.out.println("The thread ID for clickOffers Edge is "+ Thread.currentThread().getId());
	}
	//WebElement offers=driver.findElement(By.cssSelector("a#offers"));
	/*offers.click();
	Thread.sleep(2000);
	WebElement loginBtn=driver.findElement(By.cssSelector("button#login-btn"));
	Assert.assertTrue(loginBtn.isDisplayed())*/
	
	@AfterTest
	public void tearDown() {
	driver.close();
	}
}
	
