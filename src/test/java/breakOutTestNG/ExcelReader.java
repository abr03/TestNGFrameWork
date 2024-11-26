package breakOutTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public  static Object[][] excelReader() {
		Object arr[][]=null;
		
			try {
				System.out.println("Working Directory = " + System.getProperty("user.dir"));

				/*
				 * String filePath = System.getProperty("user.dir") +
				 * ".\\TestData\\TestUsers.xlsx"; XSSFWorkbook wb = new XSSFWorkbook(new
				 * FileInputStream(new File(filePath)));
				 */

	XSSFWorkbook wb= new XSSFWorkbook(new FileInputStream(new File("C://Users//akbhaska//Desktop//TestUsers.xlsx")));
	//XSSFWorkbook wb= new XSSFWorkbook(new FileInputStream(new File(".\\TestData\\TestUsers.xlsx")));
	
	//XSSFWorkbook wb= new XSSFWorkbook(new FileInputStream(src));
				
			XSSFSheet sheet=wb.getSheetAt(3);
			
			if(sheet==null) {
				throw new java.lang.NullPointerException(("Sheet 'CreateUsers' not found in Excel file."));
			}
			
			int rows=sheet.getPhysicalNumberOfRows()-1;
			
			
		int col=	sheet.getRow(0).getPhysicalNumberOfCells();
		 arr=new Object[rows][col];

		
		for (int i=1; i <=rows; i++) {
			
			for(int j=0; j<col; j++) {
				
			arr[i-1][j]=	sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		wb.close();
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return arr;

	}
}
