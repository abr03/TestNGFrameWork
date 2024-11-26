package DDT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day53_DDT {

	
	@Test (dataProvider ="appdata")
	public void test1(String arg1, String arg2) {
		System.out.println("Executed test 1: "+ arg1 +" "+ arg2);
	}
	
	
	@DataProvider(name="appdata")
	public Object[][] getdata() {
		Object arr[][]=new Object[2][2];
		
		arr[0][0]="admin@email.com";
		arr[0][1]="admin@123";
		arr[1][0]="admin@2email1.com";
		arr[1][1]="admin@123";
		
		return arr;
	}
	
	
	
	
}
