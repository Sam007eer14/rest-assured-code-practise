package com.api.testscom.api.tests.datadriver;

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
import static com.api.utils.DateTimeUtil.*;
import com.api.utils.SpecUtils;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;



public class CreateJobAPIDataDrivenTest {
	CreateJobPayload createJobPayLoad;
	

	
	@Test(description = "Verify if create job api is able to create Inwarrnty job", groups = {"regression", "datadriven"}, 
			dataProviderClass = com.dataprovider.DataProvidersUtil.class,
			dataProvider = "createJobPayload")
	public void createJobAPITest(CreateJobPayload createJobPay) {
		
	
	  given().
	  given()
	  .and().spec(
	      SpecUtils.requestSpec(createJobPay)
	  ).and().header("Authorization", AuthTokenProvider.getToken(Roles.FD))
	  .when().post("/job/create")
	  .then().log().all().and().
	  statusCode(200);
	}
}

	
