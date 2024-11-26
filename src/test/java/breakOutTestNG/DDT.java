package breakOutTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DDT {

	@DataProvider(name = "createUser")
	public static Object CreateUsers() {

		Object arr[][] = new Object[3][7];
		arr[0][0] = "BhaskarRao1";
		arr[0][1] = "Bhr@emai67.com";

		arr[0][2] = "Bhkar125&!@";
		arr[0][3] = "Cypress";

		arr[0][4] = "Male";

		arr[0][5] = "Kerala";

		arr[0][6] = "Dancing";

		
		  arr[1][0]="Bhaskar"; 
		  arr[1][1]="Bh@e446.com";
		  
		  arr[1][2]="Bhaskar125&!@";
		  arr[1][3]="Cypress";
		  
		  arr[1][4]="Male";
		  
		  arr[1][5]="Kerala";
		  
		  arr[1][6]="Dancing";
		  
		  arr[2][0]="Bhaskar"; 
		  arr[2][1]="askr@email09.com";
		  
		  arr[2][2]="Bhkar125&!@"; 
		  arr[2][3]="Cypress";
		  
		  arr[2][4]="Male";
		  
		  arr[2][5]="Kerala";
		  
		  arr[2][6]="Dancing";
		 

		return arr;
	}
	
	@DataProvider (name="createUsersUsingExcel")
	public static Object[][] createUsersFromExcel() {
		
	Object[][]arr=	ExcelReader.excelReader();
	return arr;
		/*
		 * Object arr[][]=null; File src= new
		 * File(".\\TestngUsingSelenium\\TestData\\TestUsers.xlsx"); try {
		 * //FileInputStream fis= new FileInputStream(src);
		 * 
		 * XSSFWorkbook wb= new XSSFWorkbook(new FileInputStream(src));
		 * 
		 * XSSFSheet sheet= wb.getSheet("CreateUsers");
		 * 
		 * int rows=sheet.getPhysicalNumberOfRows()-1;
		 * 
		 * 
		 * int col= sheet.getRow(rows).getPhysicalNumberOfCells(); arr=new
		 * Object[rows][col];
		 * 
		 * 
		 * for (int i=1; i <=rows; i++) {
		 * 
		 * for(int j=0; j<col; j++) {
		 * 
		 * arr[i-1][j]= sheet.getRow(i).getCell(j).getStringCellValue(); } } wb.close();
		 * 
		 * 
		 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 * 
		 * return arr;
		 */

		
	}

}
