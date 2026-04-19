package com.api.utils;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.pojo.CreateJobPayload;

public class DataProviderUtils {
	
	
	
	
	@DataProvider(name = "CreateJobAPIFakerDataProvider", parallel = true)
	public static Iterator<CreateJobPayload> createJobFakeDataProvider() {
	   Iterator <CreateJobPayload> payloadIterator = FakerDataGenerator.generateFakeCreateJobData(1);
	    return payloadIterator;
	}


}
