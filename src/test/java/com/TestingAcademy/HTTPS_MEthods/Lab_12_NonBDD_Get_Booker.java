package com.TestingAcademy.HTTPS_MEthods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

public class Lab_12_NonBDD_Get_Booker {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @Test
    public void getBookingById() {
        int bookingId = 1837; // You can change this ID to test with different bookings

        Response response = RestAssured.given()
                .when()
                .get("/booking/" + bookingId);

        // Print the status code
        System.out.println("Status Code: " + response.getStatusCode());

        // Print the response body
        System.out.println("Response Body:\n" + response.asString());

        // You can also add assertions here, for example:
        // Assert.assertEquals(200, response.getStatusCode());
        // Assert.assertTrue(response.asString().contains("firstname"));
    }
}
