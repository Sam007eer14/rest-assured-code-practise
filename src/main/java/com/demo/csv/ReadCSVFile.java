package com.demo.csv;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadCSVFile {

	public static void main(String[] args) throws Exception {

//        String filePath = "src/main/resources/testData/LoginCreds.csv";
//
//        File csvFile = new File(filePath);
//
//        System.out.println(csvFile.getAbsolutePath());
//
//        FileReader fileReader = new FileReader(csvFile);

		InputStream inputStream = ReadCSVFile.class.getClassLoader().getResourceAsStream("testData/LoginCreds.csv");

		InputStreamReader reader = new InputStreamReader(inputStream);

		CSVReader csvReader = new CSVReader(reader);

		List<String[]> dataList = csvReader.readAll();

		for (String[] dataArray : dataList) {
			for (String data : dataArray) {
				System.out.print(data + " ");
			}
			System.out.println();
		}

		csvReader.close();
	}
}