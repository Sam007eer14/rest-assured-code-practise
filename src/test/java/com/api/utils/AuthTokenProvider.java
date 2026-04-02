package com.api.utils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import com.api.constant.Roles;
import com.api.pojo.UserCredentials;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class AuthTokenProvider {
	public static String getToken(Roles role){
		
		
		UserCredentials userCredentials = null;
		
		if (role == Roles.FD) {
	        userCredentials = new UserCredentials("iamfd", "password");

	    } else if (role == Roles.SUP) {
	        userCredentials = new UserCredentials("iamsup", "password");

	    } else if (role == Roles.ENG) {
	        userCredentials = new UserCredentials("iameng", "password");

	    } else if (role == Roles.QC) {
	        userCredentials = new UserCredentials("iamqc", "password");

	    } else {
	        throw new RuntimeException("Invalid role passed: " + role);
	    }
		
		String token = given().baseUri(ConfigManager2.getProperty("BASE_URI"))
		.and().contentType(ContentType.JSON)
		.and().accept(ContentType.JSON)
		.and().body(userCredentials)
		.when().post("login")
		.then().log().all()
		.extract().body().jsonPath().getString("data.token");
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println(token);
		return token;
	}

}
