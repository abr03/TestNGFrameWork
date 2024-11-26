package DDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class AllDataProvider {
	
@DataProvider (name="validdata")
	
	public static Object[][] testdata() {
		Object [][]arr= new Object[2][2];
		arr[0][0]="admin@email.com";
		arr[0][1]="admin@123";
		arr[1][0]="admin@email.com";
		arr[1][1]="admin@email.com";
		
		return arr;

	}
	
@DataProvider (name="Invaliddata")
	
	public static Object[][] testdatainvalid() {
	Object [][]arr= new Object[1][2];
		arr[0][0]="admin1@email.com";
		arr[0][1]="admin@123";

		return arr;
	}

@DataProvider (name="appdatafromExcel")

public static Object[][] getdatafromExcel(){
    Object[][] data = null;

	try {
		
		FileInputStream fis= new FileInputStream(new File(".\\TestData\\TestUsers.xlsx"));
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		
		Sheet sheet=wb.getSheet("Sheet2");
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println("number of rows:"+rows);
		int column=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("number of column:"+column);

		
        data = new Object[rows][column]; 

		
		for(int i=0; i<rows; i ++) {
			
		Row row=sheet.getRow(i);
		
		for (int j=0; j <column; j++) {
			Cell cell=row.getCell(j);
			data[i][j]=cell.getStringCellValue();
			
            
		}
		}
		wb.close();
		fis.close();

		
		/*int totalsheet=wb.getNumberOfSheets();
		System.out.println("Total sheets in Excel: "+ totalsheet);*/
		
		/*
		 * XSSFSheet sh1=wb.getSheet("Sheet2").getRow(0)
		 * 
		 * XSSFRow row=sh1.getRow(0); XSSFCell cell=row.getCell(0);
		 * 
		 * String finalvalue=cell.getStringCellValue();
		 * 
		 * System.out.println("Data cell from final cell: "+finalvalue);
		 */
		
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("unable to find file :"+e.getMessage());
	}
	catch(IOException e) {
		System.out.println("Unable to read file: "+e.getMessage());
	}
	return data;

}



@DataProvider (name="datafromExcel")

public static Object[][] getdata(){

	Object arr[][]= null;
	try {
		
		XSSFWorkbook wb= new XSSFWorkbook(new FileInputStream(new File(".\\TestData\\TestUsers.xlsx")));
		int rows=wb.getSheet("Sheet2").getPhysicalNumberOfRows();
		
		int column=wb.getSheet("Sheet2").getRow(0).getPhysicalNumberOfCells();
		
       arr = new Object[rows][column]; 
		
		for(int i=0; i<rows; i ++) {
		
		for (int j=0; j <column; j++) {
			
		arr[i][j]=	wb.getSheet("Sheet2").getRow(i).getCell(j);
            
		}
		
	}
		wb.close();
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("unable to find file :"+e.getMessage());
	}
	catch(IOException e) {
		System.out.println("Unable to read file: "+e.getMessage());
	}
	return arr;

}

}

	
