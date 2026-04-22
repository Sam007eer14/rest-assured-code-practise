package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.api.pojo.UserCredentials;

public class ExcelReaderUtil {
	public ExcelReaderUtil() {	}
	public static Iterator<UserCredentials> loadExcelData() {
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("testData/TestData-Practise.xlsx");
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet mySheet = myWorkBook.getSheet("LoginTestData");
		XSSFRow myRow = mySheet.getRow(0);
		XSSFCell myCell = myRow.getCell(0);

		XSSFRow headerRows = mySheet.getRow(0); // HeaderRows

		int userNameIndex = -1;
		int passwordIndex = -1;

		for (Cell cell : headerRows) {
			if (cell.getStringCellValue().trim().equalsIgnoreCase("username")) {
				userNameIndex = cell.getColumnIndex();
			}

			if (cell.getStringCellValue().trim().equalsIgnoreCase("password")) {
				passwordIndex = cell.getColumnIndex();
			}
		}
		System.out.println(userNameIndex + " " + passwordIndex);
		int lastRowIndex = mySheet.getLastRowNum();
		XSSFRow rowData;
		UserCredentials userCredentials;
		ArrayList<UserCredentials> userList = new ArrayList<>();
		for(int rowIndex =1; rowIndex<=lastRowIndex; rowIndex++) {
			rowData = mySheet.getRow(rowIndex);
			userCredentials = new UserCredentials(rowData.getCell(userNameIndex).toString(), rowData.getCell(passwordIndex).toString());
			userList.add(userCredentials);
		}
		return userList.iterator();


	}

}
