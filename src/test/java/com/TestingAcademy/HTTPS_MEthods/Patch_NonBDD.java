package com.TestingAcademy.HTTPS_MEthods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test; // Make sure this import is correct for TestNG

public class Patch_NonBDD {

    // These variables can remain as class members
    String token = "5f57f3b0f486061"; // IMPORTANT: Tokens are usually short-lived. This one might expire.
    String bookingid = "2856";       // IMPORTANT: This booking ID might not exist or be editable.

    String payloadPatch = "{\n" +
            "    \"firstname\" : \"Lucky\",\n" +
            "    \"lastname\" : \"Brown\"\n" +
            "}";

    // All your executable API logic must be inside a method, typically a @Test method
    @Test // This annotation marks the method as a TestNG test
    public void testPatchBooking() {
        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token); // Ensure this token is valid and has permissions

        requestSpecification.body(payloadPatch).log().all();

        Response response = requestSpecification.when().patch();

        ValidatableResponse validatableResponse = response.then().log().all();

        // Assertions
        validatableResponse.statusCode(200);

        // Optional: Further assertions on the response body
        // validatableResponse.body("firstname", equalTo("Lucky"));
        // validatableResponse.body("lastname", equalTo("Brown"));
    }
}