package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.pojo.UserCredentials;
import com.api.utils.ConfigManager2;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginAPITest {
	@Test
	public void loginAPI_Test() throws IOException {
		//Read the property value which is going to be passed from the terminal 
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("LoginAPITest is getting executed");
		System.out.println(System.getProperty("env"));
		
		
		UserCredentials userCreds = new UserCredentials("iamfd", "password");
	
		given().baseUri(ConfigManager2.getProperty("BASE_URI"))
		.and().contentType(ContentType.JSON)
		.and().accept(ContentType.JSON)
		.and().body(userCreds)
		.log().method()
		.and().when().post("login")
		.then()
		.log().body()
		.statusCode(200).time(lessThan(2000L))
		.and().body("message", equalTo("Success"))
		.and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschemaValidator/LoginResponseValidation.json"));
		
		
		
		
	}

}
