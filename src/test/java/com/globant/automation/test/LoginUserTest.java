package com.globant.automation.test;

import com.globant.automation.config.TestRunner;
import com.globant.automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginUserTest extends TestRunner {

    @Test(testName = "Login user successfully")
    public void loginUserTest() {
        String username = "Madelin";
        String password = "pass123";

        Response response = RequestBuilder.getRequest(
                getBaseUrl(),
                "/user/login?username=" + username + "&password=" + password
        );

        assertEquals(response.getStatusCode(), 200, "Login failed");
        String message = response.jsonPath().getString("message");
        System.out.println("Login Message: " + message);
    }
}
