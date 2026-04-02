package com.api.tests;

import org.testng.annotations.Test;

import com.api.constant.Roles;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager2;

import io.restassured.module.jsv.JsonSchemaValidator;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class CountAPITest {
	
	
	@Test
	public void verifyCountAPIResponse() {
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("CountAPITest is getting executed");
		given().baseUri(ConfigManager2.getProperty("BASE_URI"))
		.and().header("Authorization", AuthTokenProvider.getToken(Roles.ENG))
		.and().when().get("/dashboard/count").then()
		.log().all().and()
		.statusCode(200)
		.and()
		.body("message", equalTo("Success"))
		.time(lessThan(7000L))
		.and().body("data", notNullValue()).and()
		.body("data.size()", equalTo(2)).and()
		.body("data.count", everyItem(greaterThanOrEqualTo(0)))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschemavalidator/CountAPIResponseSchema.json"));
		
	}

}
