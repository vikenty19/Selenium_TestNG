package tutorial.tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadingExcel {
    public static void main(String[] args) throws IOException {
        String excelFilePath = System.getProperty("user.dir") + "/Files/employee.xlsx";
        File excelFile = new File(excelFilePath);
        FileInputStream fis = new FileInputStream(excelFile);//Java
        XSSFWorkbook workbook = new XSSFWorkbook(fis);//create object of pre-defined class of Apache POI
        //searching for the sheet in Excel workbook
        XSSFSheet sheet = workbook.getSheet("one");//name


        System.out.println(sheet.getLastRowNum());//Return index !! not fact number of row
        int rows = sheet.getPhysicalNumberOfRows();//physical number of rows
        int columns = sheet.getRow(0).getLastCellNum();//physical number of columns

            // 1 way -using for loops
       for (int r = 0; r < rows ; r++) {
            XSSFRow row = sheet.getRow(r);

            for (int c = 0; c <columns ; c++) {
                XSSFCell cell = row.getCell(c);
                // define what cell type of data we have in this cell
                CellType cellType = cell.getCellType();
                //switch to exact type of data in cell
                switch (cellType){
                    case STRING :
                        System.out.print(cell.getStringCellValue()+"     | ");//to print as a table
                    break;
                    case NUMERIC :
                        System.out.print(cell.getNumericCellValue()+"         | ");
                    break;
                    case BOOLEAN :
                        System.out.print(cell.getBooleanCellValue()+"        | ");
                        break;
                }
            }
            System.out.print("  \n");//to print as a table
        }
            workbook.close();//Not compulsory but preferable
        }
    }
