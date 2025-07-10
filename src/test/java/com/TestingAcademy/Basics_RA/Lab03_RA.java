package com.TestingAcademy.Basics_RA;

import io.restassured.RestAssured;

public class Lab03_RA {
    public static void main(String[] args) {
        RestAssured
                .given()
                .baseUri("https://api.postalpincode.in/pincode/110001")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
}
