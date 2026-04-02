package com.api.tests;

import org.testng.annotations.Test;

import com.api.utils.ConfigManager2;

import static io.restassured.RestAssured.*;

public class MasterAPITest {
	
	@Test
	public void masterAPITest() {
		given().baseUri(ConfigManager2.getProperty(DEFAULT_BODY_ROOT_PATH));
	}

}
