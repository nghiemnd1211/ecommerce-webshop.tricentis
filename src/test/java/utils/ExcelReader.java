package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;

public class ExcelReader {

    public static void main(String[] args) {
        File excelFileLocation = new File("src/test/data/TestData.xlsx");

        try {
            FileInputStream fis = new FileInputStream(excelFileLocation);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet("Sheet1");
            for(Row row : sheet) {
                for(Cell cell : row) {
                    System.out.println(cell);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}