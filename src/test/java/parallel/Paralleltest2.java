package parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Paralleltest2 {


		WebDriver driver;

		@Test(priority = 1)
		public void testChrome() throws InterruptedException {
		System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
		
		System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getName());

	//	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(), "Google","TestPassed");
		}

		@Test(priority = 2)
		public void testEdge() throws InterruptedException {
		System.out.println("The thread ID for Edge is "+ Thread.currentThread().getId());
		
		
		System.out.println("The thread ID for Edge is "+ Thread.currentThread().getName());

		//WebDriverManager.firefoxdriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(), "Google"); 
		}

		@AfterClass
		public void close() {
		driver.quit();
		} 
		
}
