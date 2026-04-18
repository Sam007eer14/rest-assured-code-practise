package com.dataprovider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.pojo.CreateJobPayload;
import com.api.utils.CSVReaderUtil;
import com.api.utils.CreateJobBeanMapper;
import com.dataprovider.api.bean.CreateJobBean;

public class Demp {
  
	public static void main(String[] args) {
		
//		return CSVReaderUtil.loadCSV("testData/LoginCreds.csv");
		Iterator<CreateJobBean> iterator =  CSVReaderUtil.loadCSV("testData/CreateJobData.csv", CreateJobBean.class);
		
		while(iterator.hasNext()) {
			CreateJobBean c = iterator.next();
		CreateJobPayload createJobPayload = CreateJobBeanMapper.mapper(c);
		System.out.println(createJobPayload);
		
	}
	}

}
