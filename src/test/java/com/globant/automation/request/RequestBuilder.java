package com.globant.automation.request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.http.HttpHeaders;

public class RequestBuilder {

    public static Response getRequest(String baseUri, String path) {
        RequestSpecification requestSpecification = RestAssured.given()
            .baseUri(baseUri)
            .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON.toString())
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter());

        return requestSpecification.get(path);
    }

    public static Response getRequestWithApiKey(String baseUri, String path, String apiKey) {
        RequestSpecification requestSpecification = RestAssured.given()
            .baseUri(baseUri)
            .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON.toString())
            .header("api_key", apiKey)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter());

        return requestSpecification.get(path);
    }
    public static Response postRequest(String baseUri, String path, Object body) {
    return RestAssured.given()
            .baseUri(baseUri)
            .contentType(ContentType.JSON)
            .body(body)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .post(path);
}

    public static Response putRequest(String baseUri, String path, Object body) {
        return RestAssured.given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(body)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .put(path);
    }

    public static Response deleteRequest(String baseUri, String path) {
        return RestAssured.given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .delete(path);
    }
}
