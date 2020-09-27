package com.mercurytoursflights.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author M1049131 
 * Purpose: Methods to read excel data
 *         
 */

public class ReadExcel {

	public static XSSFSheet excelSheet;
	public static XSSFWorkbook workBook;
	public static XSSFCell cell;
	public static FileInputStream file;
	public static XSSFRow row;
	public static FileOutputStream output;
	
	public ReadExcel() {
		super();
	}

	public static int getRowCount(String path, String sheetName) throws Exception {
		System.out.println(path);
		file = new FileInputStream(path);
		workBook = new XSSFWorkbook(file);
		excelSheet = workBook.getSheetAt(0);
		int rowCount = excelSheet.getLastRowNum();
		workBook.close();
		file.close();

		return rowCount;
	}

	public static int getCellCount(String path, String sheetName, int rownum) throws Exception {
		file = new FileInputStream(path);
		workBook = new XSSFWorkbook(file);
		excelSheet = workBook.getSheet(sheetName);
		row = excelSheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		workBook.close();
		file.close();
		return cellCount;
	}

	public static String getCellData(String path, String sheetName, int rowNum, int colNum) throws IOException {
		file = new FileInputStream(path);
		workBook = new XSSFWorkbook(file);
		excelSheet = workBook.getSheet(sheetName);
		row = excelSheet.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			data = "";
		}
		workBook.close();
		file.close();
		return data;

	}

}
