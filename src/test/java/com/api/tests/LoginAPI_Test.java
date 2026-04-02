package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import com.api.pojo.UserCredentials;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginAPI_Test {
	
	@Test
	public void loginAPI_Test() {
		UserCredentials userCreds = new UserCredentials("iamfd", "password");

		given().baseUri("http://64.227.160.186:9000/v1")
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
