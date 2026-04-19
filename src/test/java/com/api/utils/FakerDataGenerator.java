package com.api.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.pojo.CreateJobPayload;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.Problem;

import net.datafaker.Faker;

public class FakerDataGenerator {
	
	
	private final static Faker faker = new Faker(new Locale("en-IND"));
	private final static int MST_SERVICE_LOCATION_ID =0;
	private final static int MST_PLATORM_ID =2;
	private final static int MST_SWARRANTY_STATUS_ID =1;
	private final static int MST_OEM_ID =1;
	
	public FakerDataGenerator() {
		
	}
	public static CreateJobPayload generateFakeCreateJobData() {
		Customer customer = generateFakeCustomerData();
		CustomerAddress customerAddress = generateFakeCustomerAddress();
		CustomerProduct customerProduct = generateFakeCustomerProduct();
		List<Problem> problemList = generateFakeProblemList();
		
		CreateJobPayload payload = new CreateJobPayload(MST_SERVICE_LOCATION_ID, MST_PLATORM_ID, MST_SWARRANTY_STATUS_ID, MST_OEM_ID, customer, customerAddress, customerProduct, problemList);
		 return payload;
	}
	public static Iterator<CreateJobPayload> generateFakeCreateJobData(int count) {
		List<CreateJobPayload> payloadJob = new ArrayList<>();
		for(int i=1; i<=count; i++) {
			Customer customer = generateFakeCustomerData();
			CustomerAddress customerAddress = generateFakeCustomerAddress();
			CustomerProduct customerProduct = generateFakeCustomerProduct();
			List<Problem> problemList = generateFakeProblemList();
			
			CreateJobPayload payload = new CreateJobPayload(MST_SERVICE_LOCATION_ID, MST_PLATORM_ID, MST_SWARRANTY_STATUS_ID, MST_OEM_ID, customer, customerAddress, customerProduct, problemList);
			payloadJob.add(payload);
			
		}
		return payloadJob.iterator();
	}
	private static List<Problem> generateFakeProblemList() {

		String fakeRemake = faker.lorem().sentence(5);
		Random random = new Random();
		int problemID = (random.nextInt(26)+1);
		Problem problem = new Problem(problemID, fakeRemake);
		List<Problem> problemList = new ArrayList<>();
		problemList.add(problem);
		 return problemList;
	}
	private static CustomerProduct generateFakeCustomerProduct() {

		String dop = DateTimeUtil.getTimeWithDate(10);
		String imeiSerialNumber = faker.numerify("##############");
		String popUrl = faker.internet().url();
		CustomerProduct customerProduct = new CustomerProduct(dop, imeiSerialNumber, imeiSerialNumber, imeiSerialNumber, popUrl, 1, 2);
		return customerProduct;
	}
	private static CustomerAddress generateFakeCustomerAddress() {
		String flatNumber = faker.numerify("###");
		String apartmentName = faker.address().streetAddress();
		String streetName = faker.address().streetAddress();
		String landMake = faker.address().streetAddress();
		String area = faker.address().streetAddress();
		String pinCode = faker.numerify("####");
		String country = faker.address().country();
		String state = faker.address().state();
		CustomerAddress customerAddress = new CustomerAddress(flatNumber, apartmentName, streetName,
				landMake, area, pinCode, country, state);
		return customerAddress;
	}
	private static Customer generateFakeCustomerData() {
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String mobileNumber = faker.numerify("70########");
		String alternateMobileNumber = faker.numerify("70########");
		String customerEmailAddress = faker.internet().emailAddress();
		String alternateEmailAddress =  faker.internet().emailAddress();
		Customer customer = new Customer(firstName, lastName, mobileNumber, alternateMobileNumber, customerEmailAddress, alternateEmailAddress);
        return customer;
	}

}
