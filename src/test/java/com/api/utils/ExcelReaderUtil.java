package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.api.pojo.UserCredentials;
import com.poiji.bind.Poiji;

public class ExcelReaderUtil {
	public ExcelReaderUtil() {	}
	public static <T>Iterator<T> loadExcelData(String sheetName, Class<T> clazz) {
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

		List<T> dataList = Poiji.fromExcel(mySheet, clazz);
		return dataList.iterator();


	}

}
