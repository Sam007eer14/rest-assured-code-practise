package com.demo.csv;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.demo.pojo.UserPojo;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ReadCSVFile_MapTOPojo {

	public static void main(String[] args) throws Exception {


		InputStream inputStream = ReadCSVFile_MapTOPojo.class.getClassLoader().getResourceAsStream("testData/LoginCreds.csv");

		InputStreamReader reader = new InputStreamReader(inputStream);

		CSVReader csvReader = new CSVReader(reader);
       
		CsvToBean<UserPojo> csvToBean = new CsvToBeanBuilder(csvReader).withType(UserPojo.class).withIgnoreEmptyLine(true).build();		
		
		List<UserPojo> userList = csvToBean.parse();
		System.out.println(userList);
	}
}