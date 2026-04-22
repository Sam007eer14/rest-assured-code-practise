package com.api.utils;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.pojo.CreateJobPayload;
import com.api.pojo.UserCredentials;

public class DataProviderUtils {

	@DataProvider(name = "CreateJobAPIFakerDataProvider", parallel = true)
	public static Iterator<CreateJobPayload> createJobFakeDataProvider() {
		Iterator<CreateJobPayload> payloadIterator = FakerDataGenerator.generateFakeCreateJobData(1);
		return payloadIterator;
	}

	@DataProvider(name = "LoginAPIJsonProvider", parallel = true)
	public static Iterator<UserCredentials> LoginAPIJsonProvider() {
		return JsonReaderUtility.loadJson("testData/demo.json", UserCredentials[].class);
	}
	@DataProvider(name = "LoginAPIExcelDataProvider", parallel = true)
	public static Iterator<UserCredentials> LoginAPIExcelDataProvider() {
		return ExcelReaderUtil.loadExcelData();
	}

}
