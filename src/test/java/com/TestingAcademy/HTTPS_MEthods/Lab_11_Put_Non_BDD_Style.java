package com.TestingAcademy.HTTPS_MEthods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab_11_Put_Non_BDD_Style {
    // PUT

    // token, booking id - A

//    public void get_token(){ } // These are comments, not part of the executable code
//    public void get_booking_id(){} // These are comments, not part of the executable code

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_put_non_bdd() {

        // Hardcoded values for demonstration; in a real scenario, these would be dynamic
        String token = "b74d48040a41a11"; // Make sure this token is valid and active
        String bookingid = "1837";       // Make sure this booking ID exists

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Duttaaaaa\",\n" +
                "    \"totalprice\" : 222,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        // 1. Build the Request (Non-BDD Style)
        r = RestAssured.given(); // Get a new RequestSpecification instance
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingid);
        r.contentType(ContentType.JSON);
        // r.auth().oauth... // This was commented out, which is fine
        r.cookie("token", token); // Add the token as a cookie
        r.body(payloadPUT);     // Set the request body
        r.log().all();          // Log the entire request before sending

        // 2. Execute the Request
        // .when() here acts as a clear separator for when the request is sent.
        // It's still part of the fluent API but conceptually separates setup from action.
        response = r.when().put(); // Perform the PUT request

        // 3. Log and Validate the Response
        vr = response.then();       // Get a ValidatableResponse from the Response
        vr.log().all();             // Log the entire response
        vr.statusCode(200);         // Assert the status code
    }
}