package DDT_DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import DDT.AllDataProvider;

public class LogintoApp {

	
	@Test (dataProvider ="loginUsingExcel", dataProviderClass = Data_Supplier.class,enabled = false)
	public void login(String username, String password)
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("value is :"+ username + " "+ password);
		driver.get("https://freelance-learn-automation.vercel.app/login");

		driver.findElement(By.id("email1")).sendKeys(username);
		driver.findElement(By.id("password1")).sendKeys(password);

		
	}
	
	@Test (dataProvider = "readExcelUsingHeaders",  dataProviderClass = Data_Supplier.class )
	public void readExcel(String arg1, String arg2) {
		
		
		System.out.println(arg1 + " "+ arg2);
	}
	
}



		
