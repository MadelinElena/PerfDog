package com.globant.automation.test;

import com.globant.automation.config.TestRunner;
import com.globant.automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GetPetByIdTest extends TestRunner {

    @Test(testName = "Get pet by ID")
    public void getPetByIdTest() {
        long petId = 1; // Cambia este ID si quieres usar otro que hayas visto

        Response response = RequestBuilder.getRequest(getBaseUrl(), "/pet/" + petId);

        assertEquals(response.getStatusCode(), 200, "Pet not found");
        assertNotNull(response.jsonPath().getString("name"), "Pet name should not be null");
    }
}
