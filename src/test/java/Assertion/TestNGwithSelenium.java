package Assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGwithSelenium extends BaseClass{
	
	
	@Test (priority = 1)
	public void loginApp() {
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		driver.findElement(By.id("password1")).sendKeys("admin@123");
		driver.findElement(By.className("submit-btn")).click();
		
		WebElement header=driver.findElement(By.xpath("//h1[(normalize-space()='Learn Automation Courses')]"));
		
		String WelcomeMessage=header.getText();
		
		Assert.assertEquals(WelcomeMessage, "Learn Automation Courses","Test passed");
		
	}
	
	
	@Test (priority = 2)
	public void LogoutApp() {
		
		//driver.findElement(By.xpath("nav-menu-item-manage")).click();
		/*
		 * driver.findElement(By.xpath("//img[@alt='menu']")).click();
		 * driver.findElement(By.xpath("//button[(normalize-space()='Sign out')]")).
		 * click(); String url=driver.getCurrentUrl(); Assert.assertEquals(url,
		 * "https://freelance-learn-automation.vercel.app/login","Test Passed");
		 */
        if (!driver.findElements(By.xpath("//img[@alt='menu']")).isEmpty()) {
            // Perform logout steps
            driver.findElement(By.xpath("//img[@alt='menu']")).click();
            driver.findElement(By.xpath("//button[(normalize-space()='Sign out')]")).click();
            System.out.println("LoggedOut Sucessfull.");

            // Validate that the logout was successful
            WebElement Newuser = driver.findElement(By.xpath("//a[(normalize-space()='New user? Signup')]"));
           String  signup= Newuser.getText();
            Assert.assertTrue(Newuser.isDisplayed(), signup);
        } 
    }

		
	}
	
	

	
	


