package com.api.tests;

import org.checkerframework.checker.index.qual.LessThan;
import org.testng.annotations.Test;

import com.api.constant.Roles;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager2;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class MasterAPITest {
	
	@Test
	public void masterAPITest() {
		given().baseUri(ConfigManager2.getProperty("BASE_URI"))
		.and().header("Authorization", AuthTokenProvider.getToken(Roles.ENG))
		.and().contentType("")
		.log().all().and().when()
		.post("master").then()
		.log().all()
		 .log().all()
         .statusCode(200)
         .time(lessThan(1000L))
         .body("message", equalTo("Success"))
         .body("data", notNullValue())
         .body("data", hasKey("mst_oem"))
         .body("data", hasKey("mst_model"))
         .body("$", hasKey("message"))
         .body("$", hasKey("data"))
         .body("data.mst_oem.size()", equalTo(2)) // Check size of JSON Array
         .body("data.mst_model.size()", greaterThan(0))
         .body("data.mst_oem.id", everyItem(notNullValue()))
         .body("data.mst_oem.name", everyItem(notNullValue()));
 }

}
