package com.globant.automation.test;

import com.globant.automation.config.TestRunner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class CreateUserTest extends TestRunner {

    @Test(testName = "Create user with POST")
    public void createUserTest() {
        String requestBody = """
        {
            "id": 1234,
            "username": "Madelin",
            "firstName": "Madelin",
            "lastName": "QA",
            "email": "madelin@gmail.com",
            "password": "pass123",
            "phone": "3214244589",
            "userStatus": 1
        }
        """;

        RestAssured
            .given()
                .baseUri(getBaseUrl())
                .contentType(ContentType.JSON)
                .body(requestBody)
            .when()
                .post("/user")
            .then()
                .statusCode(200);
    }
}
