package DDT_DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public  class Data_Supplier {
	
	
	@DataProvider (name="login")
	public static Object[][] getData() {
		Object arr[][]= new Object[2][2];
		arr[0][0]="admin@email.com";
		arr[0][1]="admin@123";

		arr[1][0]="admin@email1.com";

		arr[1][1]="admin@1234";

		
		
		return arr;
		
	}
	@DataProvider(name="readexcel")
	public static Object[][] readExcel() throws IOException {
		
		File src= new File(".\\TestData\\TestUsers.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb= new XSSFWorkbook();
	XSSFSheet sheet=	wb.getSheet("Sheet2");
	System.out.println(sheet);
	int rows=sheet.getPhysicalNumberOfRows();
	int columns=sheet.getRow(0).getPhysicalNumberOfCells();
	Object arr [][]= new Object[rows][columns];
	
	for (int i=1; i <rows; i++) {
		
		for(int j=0; j<columns; j++) {
			
			arr[i-1][j]=wb.getSheet("Sheet2").getRow(i).getCell(j);
			System.out.println(arr[i][j]);
			
            System.out.println("Data at [" + i + "][" + j + "]: " + arr[i][j]);
          //  System.out.println("Data at ["+ i + "]["+ j + "]:"+ arr[i][j]);
            wb.close();
            fis.close();
            

		}
	}
	return arr;
		
	}
	
	
	@DataProvider(name="loginUsingExcel")
	public static  Object[][] readdata() throws IOException{
		File src= new File(".\\TestData\\TestUsers.xlsx");
		//src.getAbsoluteFile();
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheet("Sheet2");
	int rows=sheet.getPhysicalNumberOfRows();
//int column=	sheet.getRow(0).getPhysicalNumberOfCells();
int column=wb.getSheet("Sheet2").getRow(0).getPhysicalNumberOfCells();
System.out.println("rows :"+ rows +" "+ "columns: "+ column);

Object arr[][]= new Object[rows][column];

 for (int i=0; i <rows; i ++) {
	 
	 for (int j=0; j<column; j++) {
		arr[i][j]= wb.getSheet("Sheet2").getRow(i).getCell(j).getStringCellValue();
		
		System.out.println("Data ["+i + "]["+j+ "]"+ arr[i][j]);
		wb.close();
		 
	 }
	 
 }
 
            

 return arr;


	}
	
	@DataProvider(name="readExcel")
	public static Object[][] readExcelData() {
		
		File src= new File(".\\TestData\\TestUsers.xlsx");
		Object arr[][]= null;
		try {
			FileInputStream fis= new FileInputStream(src);
			
			XSSFWorkbook wb= new XSSFWorkbook(src);
			XSSFSheet sheet=wb.getSheet("Sheet2");
			int rows=wb.getSheet("Sheet2").getPhysicalNumberOfRows();
			int column=sheet.getRow(0).getPhysicalNumberOfCells();
			
			arr= new Object [rows][column];
			
			for( int i=0; i<rows; i++) {
				
				for (int j=0; j<column; j++) {
					
				arr[i][j]	=sheet.getRow(i).getCell(j).getStringCellValue();
				
				System.out.println("Data ["+i + "]["+j+ "]"+ arr[i][j]);
				
				}
				
				
			}
			wb.close();
			fis.close();
			
		
	}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arr;
		
		}
	
	@DataProvider(name="readExcelUsingHeaders")

	public static Object[][] getDataUsingHeaders() {
			Object arr[][]= null;
			try {
				
				XSSFWorkbook wb= new XSSFWorkbook(new FileInputStream(new File(".\\TestData\\TestUsers.xlsx")));
				XSSFSheet sheet=wb.getSheet("Sheet3");
				int rows=wb.getSheet("Sheet3").getPhysicalNumberOfRows()-1;// to exclude headers
				int column=sheet.getRow(0).getPhysicalNumberOfCells();
				arr= new Object [rows][column];
				for( int i=1; i<rows; i++) { // to exclude headers
					for (int j=0; j<column; j++) {
						
					arr[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue(); //to have correct mapping excel and object array
					System.out.println("Data" + arr[i-1][j]);
					
					}
				}
				wb.close();
				
			
		}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return arr;
			
			}

	}


