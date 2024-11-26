package CrossBroswer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
	
	WebDriver driver;
	@Parameters({"username","password"})
	@Test 
	public void test(String username, String password) {
		driver= new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.findElement(By.id("email1")).sendKeys(username);
		driver.findElement(By.id("password1")).sendKeys(password);
	}

	@Parameters({"browser","version"})
	@Test
	public void test1(String browser, String Version) {
		System.out.println("Test1: "+browser + " Version:" + Version);
	}
}
