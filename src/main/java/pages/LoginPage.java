package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	WebDriver driver;
	
	public  LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	 private By Username= By.id("email1");
	 private By password= By.id("password1");
	 private   By loginButton=By.className("submit-btn");


	 
	 public void Login(String Uname, String Pass) {
		 
		 driver.findElement(Username).sendKeys(Uname);
		 driver.findElement(password).sendKeys(Pass);
		 driver.findElement(loginButton).click();
		 
	 }
}
