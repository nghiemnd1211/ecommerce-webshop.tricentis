package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelHelper {
    File excelFileLocation;
    private String sheet_name;
    private Sheet sheet;
    FileInputStream fis = null;

    private Cell cell;
    private Map<String, Integer> columns = new HashMap<>();

    public ExcelHelper(File excelFileLocation, String sheet_name) {
        this.excelFileLocation = excelFileLocation;
        this.sheet_name = sheet_name;
        try {
            fis = new FileInputStream(excelFileLocation);
            Workbook workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(this.sheet_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //ADD all columns header to the hashmap
        sheet.getRow(0).forEach(cell->{columns.put(cell.getStringCellValue(), cell.getColumnIndex());
        });
    }
    public String getCellData(int rownum, int colnum) throws Exception{
        try{
            cell = sheet.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()){
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell))
                    {
                        CellData = String.valueOf(cell.getDateCellValue());
                    }
                    else
                    {
                        CellData = String.valueOf((long)cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        }catch (Exception e){
            return"";
        }
    }
    // re-assign
    public String getCellData(String columnName, int rownum) throws Exception {
        return getCellData(columnName,rownum);
    }
}
