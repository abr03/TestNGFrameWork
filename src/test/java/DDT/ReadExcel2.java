package DDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel2 {
	
	
	@Test
	public void Readfile() throws IOException {
		
		
		//TestngUsingSelenium/TestData/TestUsers.xlsx
		
			File src= new File(".\\TestData\\TestUsers.xlsx");
			FileInputStream fis= new FileInputStream(src);
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			
			int totalsheet=wb.getNumberOfSheets();
			System.out.println("Total sheets in Excel: "+ totalsheet);
			wb.close();
		
		
	}

}
