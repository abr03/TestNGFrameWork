package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import CrossBroswer.Util;

public class Test1 {
	
	
	
	WebDriver driver;
	@Test
	public void test() {
		
		 driver=Util.launchBrowser("Chrome", "https://www.programiz.com/java-programming/online-compiler/");
		 
		WebElement share=driver.findElement(By.xpath("//button[@title='Share code' and @class='share-button']"));
		System.out.println(share.getText());
		Assert.assertTrue(share.isEnabled()," Test failed");
	}

}
