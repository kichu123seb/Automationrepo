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

}
