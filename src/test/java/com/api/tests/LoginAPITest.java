package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.pojo.UserCredentials;
import com.api.utils.ConfigManager2;
import com.api.utils.SpecUtils;

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
		given()
		.spec(SpecUtils.requestSpec(userCreds))
		.and().when().post("login")
		.then().spec(SpecUtils.reponseSpec())
		.and().body("message", equalTo("Success"))
		.and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschemavalidator/LoginResponseValidation.json"));	
		
	}

}
