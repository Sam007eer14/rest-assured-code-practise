package com.api.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constant.Roles;
import com.api.enu.Product;
import com.api.pojo.CreateJobPayload;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.Problem;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager2;
import com.api.utils.DateTimeUtil;
import com.api.utils.FakerDataGenerator;

import static com.api.utils.DateTimeUtil.*;
import com.api.utils.SpecUtils;

import io.restassured.http.ContentType;
import net.datafaker.Faker;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;



public class CreateJobAPITest2 {
	CreateJobPayload createJobPayLoad;
	
	@BeforeMethod(description = "SetpUp for the class")
	public void setUP() {
//		Faker faker = new Faker(new Locale("en-IND"));
//		String firstName = faker.name().firstName();
//		String lastName = faker.name().lastName();
//		String mobileNumber = faker.numerify("70########");
//		String alternateMobileNumber = faker.numerify("70########");
//		String customerEmailAddress = faker.internet().emailAddress();
//		String alternateEmailAddress =  faker.internet().emailAddress();
//		
//		Customer customer = new Customer(firstName, lastName, mobileNumber, alternateMobileNumber, customerEmailAddress, alternateEmailAddress);
//		System.out.println(customer);
//		String flatNumber = faker.numerify("###");
//		String apartmentName = faker.address().streetAddress();
//		String streetName = faker.address().streetAddress();
//		String landMake = faker.address().streetAddress();
//		String area = faker.address().streetAddress();
//		String pinCode = faker.numerify("####");
//		String country = faker.address().country();
//		String state = faker.address().state();
//		CustomerAddress customerAddress = new CustomerAddress(flatNumber, apartmentName, streetName,
//				landMake, area, pinCode, country, state);
//		
//		System.out.println(customerAddress);
//		
//		String dop = DateTimeUtil.getTimeWithDate(10);
//		String imeiSerialNumber = faker.numerify("##############");
//		String popUrl = faker.internet().url();
//		CustomerProduct customerProduct = new CustomerProduct(dop, imeiSerialNumber, imeiSerialNumber, imeiSerialNumber, popUrl, 1, 2);
//		
//		System.out.println(customerProduct);
//		
//		
//		
//		
//		
//		String fakeRemake = faker.lorem().sentence(5);
//		Random random = new Random();
//		int problemID = (random.nextInt(26)+1);
//		Problem problem = new Problem(problemID, fakeRemake);
//		List<Problem> problemList = new ArrayList<>();
//		problemList.add(problem);
//		
		createJobPayLoad = FakerDataGenerator.generateFakeCreateJobData();

	}
	
	
	@Test()
	public void createJobAPITest() {
		

		

		
		
//	  given().
//	  given()
//	  .and().spec(
//	      SpecUtils.requestSpecAuthAndBody(createJobPayLoad, Roles.FD)
//	  )
//	  .when().post("/job/create")
//	  .then().log().all().and().
//	  statusCode(200);
//	}

	
	  given().
	  given()
	  .and().spec(
	      SpecUtils.requestSpec(createJobPayLoad)
	  ).and().header("Authorization", AuthTokenProvider.getToken(Roles.FD))
	  .when().post("/job/create")
	  .then().log().all().and().
	  statusCode(200);
	}

}
