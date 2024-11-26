package DDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "Datafromexcel")
    public static Object[][] getData() {
        Object[][] arr = null;

        try (XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(".\\TestData\\TestUsers.xlsx")))) {
            int rows = wb.getSheet("Sheet2").getPhysicalNumberOfRows();
            int columns = wb.getSheet("Sheet2").getRow(0).getPhysicalNumberOfCells();

            arr = new Object[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    arr[i][j] = wb.getSheet("Sheet2").getRow(i).getCell(j).toString();
                    System.out.println("Data at [" + i + "][" + j + "]: " + arr[i][j]);

                }
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        return arr;
    }
}
