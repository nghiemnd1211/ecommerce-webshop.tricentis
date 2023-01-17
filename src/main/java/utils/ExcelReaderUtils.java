package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;

public class ExcelReaderUtils {
    File excelFileLocation;
    private String sheet_name;
    private int startRow;
    private int startCol;
    private int totalRow;
    private int totalCol;
    private Sheet sheet;
    FileInputStream fis = null;

    public ExcelReaderUtils(File excelFileLocation, String sheet_name, int startRow, int startCol) {
        this.excelFileLocation = excelFileLocation;
        this.sheet_name = sheet_name;
        this.startRow = startRow;
        this.startCol = startCol;

        try {
            fis = new FileInputStream(excelFileLocation);
            Workbook workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(this.sheet_name);
            totalRow = sheet.getPhysicalNumberOfRows();
            totalCol = sheet.getRow(0).getPhysicalNumberOfCells();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellValues(int rowNo,int colNo){
        Row row = sheet.getRow(rowNo);
        Cell cell = row.getCell(colNo);
        String cellValue =null;

        if(cell.getCellType().equals(CellType.STRING)){
            cellValue = cell.getStringCellValue();
        }
        if (cell.getCellType().equals(CellType.NUMERIC)) {
            cellValue = String.valueOf(cell.getNumericCellValue());
        }
        return cellValue;
    }
    public int getTotalRow(){
        return this.totalRow;
    }
    public int getTotalCol(){
        return this.totalCol;
    }
}

