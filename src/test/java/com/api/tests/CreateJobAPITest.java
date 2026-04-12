package com.api.tests;

import org.testng.annotations.Test;

import com.api.constant.Roles;
import com.api.pojo.CreateJobPayload;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.Problem;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager2;
import com.api.utils.SpecUtils;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class CreateJobAPITest {
	
	@Test
	public void createJobAPITest() {
		

	
		Customer customer = new Customer("Cordell", "Abernathy", "373-935-3572", "", "marianna7@gmail.com", "");
		CustomerAddress customer_address = new CustomerAddress("C 304", "Jupiter", "MG road", "Bangur Nagar", "Goregaon West", "411039", "India", "Maharashtra");
		CustomerProduct customer_product = new CustomerProduct("2025-04-06T18:30:00.000Z", "15365925749731", "15365029009731", "153692870997371", "2025-04-06T18:30:00.000Z", 1, 1);
		Problem problemArray [] = new Problem[1];
		Problem problem = new Problem(1, "Battery Issue");
		problemArray[0] = problem;
		CreateJobPayload createJobPayLoad = new CreateJobPayload(0, 2, 1, 1, customer, customer_address, customer_product,  problemArray);
		

		
		
	  given().
	  given()
	  .and().spec(
	      SpecUtils.requestSpecAuthAndBody(createJobPayLoad, Roles.FD)
	  )
	  .when().post("/job/create")
	  .then().log().all().and().
	  statusCode(200);
	}

}
