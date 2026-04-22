package com.api.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.api.pojo.UserCredentials;
import com.api.utils.SpecUtils;

public class LoginAPIJsonDataDrivenTest {
	
	 @Test(
		        description = "Verification if login is working",
		        groups = {"api","regression","datadriven"},
		        dataProviderClass = com.api.utils.DataProviderUtils.class,
		        dataProvider = "LoginAPIExcelDataProvider"
		    )
		    public void loginAPI__Test(UserCredentials userCredentials) {

		        given()
		            .spec(SpecUtils.requestSpec(userCredentials))
		        .when()
		            .post("login")
		        .then()
		            .log().all()
		            .statusCode(200);
		    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//    @Test(
//        description = "Verification if login is working",
//        groups = {"api","regression","datadriven"},
//        dataProviderClass = com.api.utils.DataProviderUtils.class,
//        dataProvider = "LoginAPIJsonProvider"
//    )
//    public void loginAPI__Test(UserCredentials userCredentials) {
//
//        given()
//            .spec(SpecUtils.requestSpec(userCredentials))
//        .when()
//            .post("login")
//        .then()
//            .log().all()
//            .statusCode(200);
//    }
	
	
}