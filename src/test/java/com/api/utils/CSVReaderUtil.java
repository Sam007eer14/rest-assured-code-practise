package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.dataprovider.api.bean.UserPojo;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReaderUtil {

	private CSVReaderUtil() {
		// Prevent object creation
	}

	public static <T> Iterator<T> loadCSV(String pathOfCSVFile, Class<T> bean) {

		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCSVFile);

			if (is == null) {
				throw new RuntimeException("CSV File Not Found: " + pathOfCSVFile);
			}

			InputStreamReader isr = new InputStreamReader(is);
			CSVReader csvReader = new CSVReader(isr);

			CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(csvReader).withType(bean).withIgnoreEmptyLine(true)
					.build();

			List<T> list = csvToBean.parse();

			return list.iterator();

		} catch (Exception e) {
			throw new RuntimeException("Failed to load CSV: " + pathOfCSVFile, e);

		}
	}
}
