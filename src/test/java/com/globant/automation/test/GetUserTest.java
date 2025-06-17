package com.globant.automation.test;

import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import com.globant.automation.config.TestRunner;
import com.globant.automation.request.RequestBuilder;
import com.globant.automation.model.users.UserDTO;

public class GetUserTest extends TestRunner {


    @Test(testName = "Validate user found by username using JsonPath")
    public void userFoundAssertion2() {
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/user/Madelin");

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


    @Test(testName = "Validate user found by username with DTO")
    public void userFoundAssertion() {
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/user/Madelin");

        // Deserializa el JSON directamente al modelo UserDTO
        UserDTO userDTO = response.as(UserDTO.class);

        assertEquals(response.getStatusCode(), 200, "Unexpected status code");
        assertEquals(userDTO.getId(), 1234, "Expected ID does not match actual value");
        assertEquals(userDTO.getFirstName(), "Madelin", "First name does not match");
        assertEquals(userDTO.getLastName(), "QA", "Last name does not match");
        assertEquals(userDTO.getUsername(), "Madelin", "Username does not match");
        assertEquals(userDTO.getEmail(), "madelin@gmail.com", "Email does not match");
    }
}
