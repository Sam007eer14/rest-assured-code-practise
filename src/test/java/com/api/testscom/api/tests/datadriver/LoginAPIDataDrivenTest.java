package com.api.testscom.api.tests.datadriver;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.pojo.UserCredentials;
import com.api.utils.ConfigManager2;
import com.api.utils.SpecUtils;
import com.dataprovider.api.bean.UserPojo;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginAPIDataDrivenTest {
	
	
	
	@Test(description = "Verifying if login api is working for FD user", groups = {"datadriver", "regression"},
			dataProviderClass = com.dataprovider.DataProvidersUtil.class, 
			dataProvider = "loginAPIDataProvider"
			)
	public void loginAPI_Test(UserPojo UserBean) throws IOException {

		given()
		.spec(SpecUtils.requestSpec(UserBean))
		.and().when().post("login")
		.then().spec(SpecUtils.reponseSpec())
		.and().body("message", equalTo("Success"));
//		.and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschemavalidator/LoginResponseValidation.json"));	
		
	}

}
 