package com.TestingAcademy.HTTPS_MEthods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab_10_Post_Non_BDD_Style {

    @Test
    public void test_POST_Auth_NonBDD() {

        // Base URI and Path
        String baseUri = "https://restful-booker.herokuapp.com";
        String basePath = "/auth";

        // Request Payload
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        // Create a new RequestSpecification object for this test
        // This is the key change: RestAssured.given() provides a fresh RequestSpecification
        RequestSpecification request = RestAssured.given();

        // Set base URI and path
        request.baseUri(baseUri);
        request.basePath(basePath);

        // Set content type and body
        request.contentType(ContentType.JSON);
        request.body(payload);

        // Log all request details
        request.log().all();

        // Perform the POST request and get the response
        Response response = request.post();

        // Log all response details and assert the status code
        // It's still common and idiomatic to use .then() for response assertions and logging
        response.then()
                .log().all() // Log all response details
                .statusCode(200); // Assert the status code
    }
}