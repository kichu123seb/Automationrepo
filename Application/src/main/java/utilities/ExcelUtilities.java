package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtilities {

	public static String getStringData(int rowIndex, int colIndex, String sheetName) throws IOException {
		String filepath = Constant.TESTDATAFILE;

		try (FileInputStream fis = new FileInputStream(filepath); XSSFWorkbook wb = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = wb.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowIndex);
			XSSFCell cell = row.getCell(colIndex);

			return cell.getStringCellValue();
		}
	}

	public static String getIntData(int rowIndex, int colIndex, String sheetName) throws IOException {
		String filepath = Constant.TESTDATAFILE;

		try (FileInputStream fis = new FileInputStream(filepath); XSSFWorkbook wb = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = wb.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowIndex);
			XSSFCell cell = row.getCell(colIndex);

			int value = (int) cell.getNumericCellValue();
			return String.valueOf(value);
		}
	}
	
	public static String getStringDataFromFile(String filePath, String sheetName, int rowIndex, int colIndex) throws IOException {

	    try (FileInputStream fis = new FileInputStream(filePath);
	         XSSFWorkbook wb = new XSSFWorkbook(fis)) {

	        XSSFSheet sheet = wb.getSheet(sheetName);
	        XSSFRow row = sheet.getRow(rowIndex);
	        XSSFCell cell = row.getCell(colIndex);

	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue();

	            case NUMERIC:
	                double numericValue = cell.getNumericCellValue();
	                if (numericValue == (int) numericValue) {
	                    return String.valueOf((int) numericValue);
	                } else {
	                    return String.valueOf(numericValue);
	                }

	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());

	            case FORMULA:
	                return cell.getRawValue();

	            case BLANK:
	                return "";

	            default:
	                return "";
	        }
	    }
	}



	public static int getIntDataFromFile(String filePath, String sheetName, int rowIndex, int colIndex) throws IOException {

	    try (FileInputStream fis = new FileInputStream(filePath);
	         XSSFWorkbook wb = new XSSFWorkbook(fis)) {

	        XSSFSheet sheet = wb.getSheet(sheetName);
	        XSSFRow row = sheet.getRow(rowIndex);
	        XSSFCell cell = row.getCell(colIndex);

	        switch (cell.getCellType()) {
	            case NUMERIC:
	                return (int) cell.getNumericCellValue();

	            case STRING:
	                // Convert string to int safely
	                return Integer.parseInt(cell.getStringCellValue().trim());

	            case FORMULA:
	                return Integer.parseInt(cell.getRawValue());

	            default:
	                throw new IllegalStateException("Cell type not supported for integer conversion");
	        }
	    }
	}



}
