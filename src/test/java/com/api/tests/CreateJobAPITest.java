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
import static com.api.utils.DateTimeUtil.*;
import com.api.utils.SpecUtils;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;


public class CreateJobAPITest {
	
	@Test
	public void createJobAPITest() {
		

		Customer customer = new Customer("Cordell", "Abernathy", "373-935-3572", "", "marianna7@gmail.com", "");
		CustomerAddress customer_address = new CustomerAddress("C 304", "Jupiter", "MG road", "Bangur Nagar", "Goregaon West", "411039", "India", "Maharashtra");
		CustomerProduct customer_product = new CustomerProduct(getTimeWithDate(10), "15365925749631", "15369290067312", "1536928709973471", getTimeWithDate(10), 1, 1);
		List<Problem> problemList = new ArrayList<Problem>();
		Problem problem = new Problem(1, "Battery Issue");
		problemList.add(problem);

		
		CreateJobPayload createJobPayLoad = new CreateJobPayload(0, 2, 1, 1, customer, customer_address, customer_product,  problemList);
		

		
		
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
