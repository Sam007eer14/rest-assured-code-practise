package com.api.utils;

import javax.management.relation.Role;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.api.constant.Roles;
import com.api.pojo.UserCredentials;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecUtils {
	
	public static RequestSpecification requestSpec() {
		
		RequestSpecification request = new RequestSpecBuilder().
		setBaseUri(ConfigManager2.getProperty("BASE_URI"))
		.setContentType(ContentType.JSON) 
		.setAccept(ContentType.JSON)
		.log(LogDetail.URI)
		.log(LogDetail.METHOD)
		.log(LogDetail.HEADERS)
		.build();
		return request;
	}
public static RequestSpecification requestSpec(Object param) {
		
		RequestSpecification request = new RequestSpecBuilder().
		setBaseUri(ConfigManager2.getProperty("BASE_URI"))
		.setBody(param)
		.setContentType(ContentType.JSON) 
		.setAccept(ContentType.JSON)
		.log(LogDetail.URI)
		.log(LogDetail.METHOD)
		.log(LogDetail.HEADERS)
		.log(LogDetail.BODY)
		.build();
		return request;
	}
public static RequestSpecification requestSpecAuthAndBody(Object param, Roles role) {
	
	RequestSpecification request = new RequestSpecBuilder().
	setBaseUri(ConfigManager2.getProperty("BASE_URI"))
	.addHeader("Authorization", "Bearer " + AuthTokenProvider.getToken(role))
	.setContentType(ContentType.JSON) 
	.setBody(param)
	.setAccept(ContentType.JSON)
	.log(LogDetail.URI)
	.log(LogDetail.METHOD)
	.log(LogDetail.HEADERS)
	.build();
	return request;
}
public static ResponseSpecification reponseSpec() {
	
	ResponseSpecification response = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
	.expectStatusCode(200).expectResponseTime(Matchers.lessThan(2000L)).log(LogDetail.ALL)
	.build();
	return response;
}
public static RequestSpecification requestSpec(Roles role) {
	
	RequestSpecification request = new RequestSpecBuilder().
	setBaseUri(ConfigManager2.getProperty("BASE_URI"))
	.addHeader("Authorization", AuthTokenProvider.getToken(role))
	.setContentType(ContentType.JSON) 
	.setAccept(ContentType.JSON)
	.log(LogDetail.URI)
	.log(LogDetail.METHOD)
	.log(LogDetail.HEADERS)
	.build();
	return request;
}


}
