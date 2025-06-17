package com.globant.automation.test;

import com.globant.automation.config.TestRunner;
import com.globant.automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ListAvailablePetsTest extends TestRunner {

    @Test(testName = "List all available pets")
    public void listAvailablePetsTest() {
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/pet/findByStatus?status=available");

        assertEquals(response.getStatusCode(), 200, "Failed to retrieve pets");

        assertTrue(response.jsonPath().getList("id").size() > 0, "No available pets found");
    }
}
