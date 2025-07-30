package com.TestingAcademy.HTTPS_MEthods; // Ensure this matches your project structure

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Delete_NonBDD {
    // IMPORTANT:
    // 1. You MUST replace "abc123" with a valid authentication token.
    //    You typically get this token by making a POST request to /auth with admin/password123.
    // 2. You MUST replace 1 with an actual, existing booking ID that you want to delete.
    //    If the ID doesn't exist, you'll likely get a 404 or 405 error from the API.
    private String validAuthToken = "5f57f3b0f486061";
    private int bookingIdToDelete = 2856;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @Test
    public void deleteBookingUsingCurlEquivalent() {
        System.out.println("Attempting to delete booking with ID: " + bookingIdToDelete);

        Response response = RestAssured.given()
                // Corresponds to -H 'Content-Type: application/json' (though often optional for DELETE without a body)
                .contentType(io.restassured.http.ContentType.JSON)
                // Corresponds to -H 'Cookie: token=abc123'
                .cookie("token", validAuthToken)
                .log().all() // Logs the request details to the console (headers, method, URL)
                .when()
                // Corresponds to -X DELETE and the URL /booking/1
                .delete("/booking/" + bookingIdToDelete);

        ValidatableResponse validatableResponse = response.then();

        validatableResponse.log().all(); // Logs the response details to the console (status, headers, body)

        // As noted before, the restful-booker API often returns 201 Created for a successful DELETE.
        // Be aware that other APIs might return 200 OK or 204 No Content for a successful deletion.
        validatableResponse.statusCode(404);

        System.out.println("Booking " + bookingIdToDelete + " delete request sent. Check the console logs for the API response and status code.");
    }
}