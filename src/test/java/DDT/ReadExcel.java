package DDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
	
	@Test
	public void Readfile() {
		
		
		//TestngUsingSelenium/TestData/TestUsers.xlsx
		try {
			
			//FileInputStream fis= new FileInputStream(new File(".\\TestData\\TestUsers.xlsx"));
			XSSFWorkbook wb= new XSSFWorkbook(new FileInputStream(new File(".\\TestData\\TestUsers.xlsx")));
			
			int totalsheet=wb.getNumberOfSheets();
			System.out.println("Total sheets in Excel: "+ totalsheet);
			
			XSSFSheet sh1=wb.getSheet("Sheet2");
			
			XSSFRow row=sh1.getRow(0);
			XSSFCell cell=row.getCell(0);
			
			String finalvalue=cell.getStringCellValue();
			
			System.out.println("Data cell from final cell: "+finalvalue);
			
			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("unable to find file :"+e.getMessage());
		}
		catch(IOException e) {
			System.out.println("Unable to read file: "+e.getMessage());
		}
		
	}

}
