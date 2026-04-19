package com.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.pojo.CreateJobPayload;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.Problem;

import net.datafaker.Faker;

public class FakerDemo {
	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("en-IND"));
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String mobileNumber = faker.numerify("70########");
		String alternateMobileNumber = faker.numerify("70########");
		String customerEmailAddress = faker.internet().emailAddress();
		String alternateEmailAddress =  faker.internet().emailAddress();
		
		Customer customer = new Customer(firstName, lastName, mobileNumber, alternateMobileNumber, customerEmailAddress, alternateEmailAddress);
		System.out.println(customer);
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
		
		System.out.println(customerAddress);
		
		String dop = DateTimeUtil.getTimeWithDate(10);
		String imeiSerialNumber = faker.numerify("##############");
		String popUrl = faker.internet().url();
		CustomerProduct customerProduct = new CustomerProduct(dop, imeiSerialNumber, imeiSerialNumber, imeiSerialNumber, popUrl, 1, 2);
		
		System.out.println(customerProduct);
		
		
		
		
		
		String fakeRemake = faker.lorem().sentence(10);
		Random random = new Random();
		int problemID = (random.nextInt(26)+1);
		Problem problem = new Problem(0, fakeRemake);
		List<Problem> problemList = new ArrayList<>();
		problemList.add(problem);
		
		
		CreateJobPayload payload = new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct, problemList);
	}

}
