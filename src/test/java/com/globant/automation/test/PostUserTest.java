package com.globant.automation.test;

import com.globant.automation.config.TestRunner;
import com.globant.automation.model.users.UserDTO;
import com.globant.automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PostUserTest extends TestRunner {

    @Test(testName = "Create a new user successfully")
    public void createUserTest() {
        // Creamos un usuario usando nuestro DTO
        UserDTO newUser = new UserDTO(
                1234,
                "Madelin",
                "Madelin",
                "QA",
                "madelin@gmail.com",
                "pass123",
                "3214244589",
                1
        );

        // Enviamos el request usando el método post
        Response response = RequestBuilder.postRequest(
                getBaseUrl(),
                "/user",
                newUser
        );

        // Verificaciones
        assertEquals(response.getStatusCode(), 200, "Failed to create user");
        assertEquals(response.jsonPath().getString("message"), "1234", "User ID does not match in response");
    }
}
