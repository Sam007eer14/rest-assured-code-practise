	package com.dataprovider;
	
	import java.util.Iterator;
	
	import org.testng.annotations.DataProvider;

import com.api.pojo.CreateJobPayload;
import com.api.utils.CSVReaderUtil;
import com.api.utils.CreateJobBeanMapper;
import com.dataprovider.api.bean.CreateJobBean;
import com.dataprovider.api.bean.UserPojo;
import java.util.*;
	public class DataProvidersUtil {
		
		@DataProvider(name = "loginAPIDataProvider", parallel = true)
		public static Iterator<CreateJobBean> loginAPIDataProvider() {
//			return CSVReaderUtil.loadCSV("testData/LoginCreds.csv");
			return CSVReaderUtil.loadCSV("LoginCreds.csv", CreateJobBean.class);
		}
		public static void createJobDataProvider() {
			Iterator<CreateJobBean> createJobBeanIterator = CSVReaderUtil.loadCSV("testData/CreateJobData.csv", CreateJobBean.class);
		}
		
		@DataProvider(name = "createJobPayload")
		public static Iterator<CreateJobPayload> createJobPayload(){
			Iterator<CreateJobBean> iterator =  CSVReaderUtil.loadCSV("testData/CreateJobData.csv", CreateJobBean.class);
			List<CreateJobPayload> payloadList = new ArrayList<CreateJobPayload>();
			CreateJobBean tempBean;
			CreateJobPayload tempPlayload;
			
			while(iterator.hasNext()) {
				tempBean = iterator.next();
				tempPlayload  = CreateJobBeanMapper.mapper(tempBean);
				payloadList.add(tempPlayload);
		}
			return payloadList.iterator();
	
	}
	}
