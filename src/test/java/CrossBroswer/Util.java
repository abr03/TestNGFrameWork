package CrossBroswer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Util {

	public static void main(String[] args) {
	
		launchBrowser("Chrome","");
		
				

	}
	
	public static WebDriver launchBrowser(String browser,String url) {
		
		WebDriver driver=null;

		if(browser.equals("Chrome")) {
			driver= new ChromeDriver();
			
		}
		else if (browser.contentEquals("Firefox")) {
			driver= new FirefoxDriver();

		}
		
		else if (browser.contentEquals("Edge")) {
			driver= new EdgeDriver();

		}
		driver.get(url);
		return driver;
	}

}
