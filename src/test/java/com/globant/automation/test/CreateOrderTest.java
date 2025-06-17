package com.globant.automation.test;

import com.globant.automation.config.TestRunner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreateOrderTest extends TestRunner {

    @Test(testName = "Create order for a pet")
    public void createOrderTest() {
        String requestBody = """
        {
            "id": 1,
            "petId": 9223372036854020000,
            "quantity": 1,
            "shipDate": "2025-06-17T10:00:00.000Z",
            "status": "placed",
            "complete": true
        }
        """;

        Response response = given()
                .baseUri(getBaseUrl())
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/store/order");

        assertEquals(response.statusCode(), 200, "Order creation failed");
        assertEquals(response.jsonPath().getInt("quantity"), 1);
        assertEquals(response.jsonPath().getString("status"), "placed");
    }
}
