package com.globant.automation.test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import com.globant.automation.config.TestRunner;

public class GetUserTest extends TestRunner {

    @Test(testName = "Validate user found by username")
    public void userFoundAssertion() {
        String username = "Madelin";

        Response response = RestAssured
            .given()
                .baseUri(getBaseUrl())
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
            .when()
                .get("/user/" + username);

        JsonPath jsonPath = response.jsonPath();

        int id = jsonPath.getInt("id");
        String firstName = jsonPath.getString("firstName");
        String lastName = jsonPath.getString("lastName");
        String responseUsername = jsonPath.getString("username");
        String email = jsonPath.getString("email");

        assertEquals(response.getStatusCode(), 200, "Unexpected status code");
        assertEquals(id, 1234, "Expected ID does not match actual value");
        assertEquals(firstName, "Madelin", "First name does not match");
        assertEquals(lastName, "QA", "Last name does not match");
        assertEquals(responseUsername, "Madelin", "Username does not match");
        assertEquals(email, "madelin@gmail.com", "Email does not match");
    }
}
