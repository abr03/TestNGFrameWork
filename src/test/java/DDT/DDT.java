package DDT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT {
	
	@Test(dataProvider ="Invaliddata", dataProviderClass = AllDataProvider.class)
	public void enterdata(String user,String pass) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("email1")).sendKeys(user);
		driver.findElement(By.id("password1")).sendKeys(pass);

	}
	
	

}
