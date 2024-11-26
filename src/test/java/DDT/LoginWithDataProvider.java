package DDT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDataProvider {
	WebDriver driver;
	@BeforeTest
	public void launch() {
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
	}
	@Test(dataProvider = "appdatafromExcel", dataProviderClass = DataProvider.class)

	public void loginWithExcel(String username, String password) {
		
		driver.findElement(By.id("email1")).sendKeys(username);
		driver.findElement(By.id("password1")).sendKeys(password);
		
	}
	
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
}
