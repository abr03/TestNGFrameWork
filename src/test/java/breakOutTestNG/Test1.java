package breakOutTestNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DDT.AllDataProvider;

public class Test1 {

	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeClass

	public void Setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://freelance-learn-automation.vercel.app/signup");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	/*
	 * //* Open https://freelance-learn-automation.vercel.app/signup and verify
	 * signup is present in URL 2. Create 3 users with all valid details Verify each
	 * user created successfully Create testng.xml file and share the html report.
	 */

	@Test(priority = 1)
	public void verifySignUp() {

		String url = driver.getCurrentUrl();
		System.out.println("url" + url);
		Assert.assertTrue(url.contains("signup"), "Test Failed");

	}

	@Test(priority = 2, dataProvider = "createUsersUsingExcel", dataProviderClass = DDT.class)
	public void createUser(String Name, String Email, String Password, String Interests, String Gender, String State,
	                       String Hobbies) {

	    WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
	    name.clear();  // Clear the field before entering new data
	    name.sendKeys(Name);

	    WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	    email.clear();  // Clear the field before entering new data
	    email.sendKeys(Email);

	    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	    password.clear();  // Clear the field before entering new data
	    password.sendKeys(Password);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+ Interests +"']"))).click();

	    WebElement gender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='"+ Gender +"']")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gender);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", gender);

	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("state")));
	    Select state = new Select(element);
	    state.selectByVisibleText(State);
	                
	    WebElement hobbies = wait.until(ExpectedConditions.elementToBeClickable(By.id("hobbies")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbies);
	    Select hobby = new Select(hobbies);
	    hobby.selectByVisibleText(Hobbies);

	    WebElement click = driver.findElement(By.xpath("//button[text()='Sign up']"));
	  //  wait.until(ExpectedConditions.elementToBeClickable(click)).click();
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", click);


	    WebElement alert = wait.until(ExpectedConditions
	            .visibilityOf(driver.findElement(By.xpath("//div[text()='Signup successfully, Please login!']"))));
	    String message = alert.getText();

	    System.out.println("message: " + message);

	    Assert.assertEquals(message, "Signup successfully, Please login!");
	    
	    driver.navigate().to("https://freelance-learn-automation.vercel.app/signup");

	    
	    wait.until(ExpectedConditions.urlContains("https://freelance-learn-automation.vercel.app/signup"));
	    
		Assert.assertTrue(driver.getCurrentUrl().contains("signup"));

	    
	//   WebElement  url= driver.findElement(By.xpath("//a[normalize-space()='New user? Signup']"));
	//   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='New user? Signup']")));

	   
	//   wait.until(ExpectedConditions.elementToBeClickable(url)).click();
	    
	  
	}



	@AfterClass
	public void TearDown() {

		// driver.close();
	}
}
