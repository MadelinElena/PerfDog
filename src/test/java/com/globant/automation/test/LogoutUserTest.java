package com.globant.automation.test;

import com.globant.automation.config.TestRunner;
import com.globant.automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogoutUserTest extends TestRunner {

    @Test(testName = "Logout user")
    public void logoutUserTest() {
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/user/logout");

        assertEquals(response.getStatusCode(), 200, "Logout failed");
        assertEquals(response.jsonPath().getString("message"), "ok", "Logout message mismatch");
    }
}
