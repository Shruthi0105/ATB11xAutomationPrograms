package com.TestingAcademy;

import io.restassured.RestAssured;

public class Lab04_RA {
    public static void main(String[] args) {
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560017")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
}
