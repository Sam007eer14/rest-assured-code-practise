package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.dataprovider.api.bean.UserPojo;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReaderUtil {

    private CSVReaderUtil() {
    	
    }
	public static void loadCSV(String pathCSVFile) throws Exception {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathCSVFile);

		InputStreamReader reader = new InputStreamReader(inputStream);

		CSVReader csvReader = new CSVReader(reader);
       
		CsvToBean<UserPojo> csvToBean = new CsvToBeanBuilder(csvReader).withType(UserPojo.class).withIgnoreEmptyLine(true).build();		
		
		List<UserPojo> userList = csvToBean.parse();
		System.out.println(userList);
	}
}
