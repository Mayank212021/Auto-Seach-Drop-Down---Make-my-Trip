package com.myproject1.utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readExcelFile { 

	public static FileInputStream inputstream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo) 
	{

		// File open in read mode
		try {
			inputstream = new FileInputStream(fileName);
			// Create XSSWorkBook Class object for excel manipulation
			workBook = new XSSFWorkbook(inputstream);
			// Now we will access sheet in this work book
			excelSheet = workBook.getSheet(sheetName);

			// Get total number of cells which have values
			cell = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			workBook.close();
			return cell.getStringCellValue();

		} catch (Exception e) {

			return(" Nothing in the sheet");
		}
	}
	public static int getRowCount( String fileName,String sheetName) 
	{
		try {
			inputstream = new FileInputStream(fileName);
			// Create XSSWorkBook Class object for excel manipulation
			workBook = new XSSFWorkbook(inputstream);
			// Now we will access sheet in this work book
			excelSheet = workBook.getSheet(sheetName);
			// Get total number of rows
			int ttlRows = excelSheet.getLastRowNum()+1;
			workBook.close();
			return ttlRows;

		} catch (Exception e) {

			return 0;
		}

	}

	public static int getColCount( String fileName , String sheetName) {

		try {
			inputstream = new FileInputStream(fileName);
			// Create XSSWorkBook Class object for excel manipulation
			workBook = new XSSFWorkbook(inputstream);
			// Now we will access sheet in this work book
			excelSheet = workBook.getSheet(sheetName);
			// Get total number of columns
			int ttlCols = excelSheet.getRow(0).getLastCellNum(); 
			workBook.close();
			return ttlCols;

		} catch (Exception e) {

			return 0;
		}

	}

}
