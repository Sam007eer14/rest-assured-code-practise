package com.api.tests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import com.api.constant.Roles;
import com.api.pojo.CreateJobPayload;
import com.api.utils.AuthTokenProvider;
import com.api.utils.SpecUtils;

import static io.restassured.RestAssured.*;

public class CreateJobAPIFakeDataDrivenTest {

    @Test(
        description = "Verifying if create job api is able to create Inwarranty job",
        groups = {"api", "regression"},
        dataProviderClass = com.api.utils.DataProviderUtils.class,
        dataProvider = "CreateJobAPIFakerDataProvider"
    )
    public void createJobAPITest(CreateJobPayload createJobPayload) {

        given()
            .spec(SpecUtils.requestSpecBody(createJobPayload))
            .header("Authorization", AuthTokenProvider.getToken(Roles.FD))

        .when()
            .post("/job/create")

        .then()
            .spec(SpecUtils.reponseSpec())
            .body("message", equalToIgnoringWhiteSpace("Job created successfully."))
            .body("data.mst_service_location_id", equalTo(1))
            .body("data.job_number", startsWith("JOB_"));
    }
}