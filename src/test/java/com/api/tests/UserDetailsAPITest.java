package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.constant.Roles;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserDetailsAPITest {
	
	@Test
	public void userDetailsAPITest() throws IOException {
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("userDetailsAPITest is getting executed");
	    ConfigManager config = new ConfigManager();
		Header authHeader = new Header("Authorization", AuthTokenProvider.getToken(Roles.ENG));
		System.out.println("The Auth Code is " + AuthTokenProvider.getToken(Roles.ENG));
		given().baseUri(config.getProperty("BASE_URI"))
		.and().header(authHeader)
		.and().accept(ContentType.JSON)
		.and().when().get("userdetails")
		.then().log().ifValidationFails()
		.statusCode(200)
		.and().time(lessThan(2000L))
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschemaValidator/UserDetails.json"));
	}

}
