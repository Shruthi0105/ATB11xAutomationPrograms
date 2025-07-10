package com.TestingAcademy.TestNg_concepts;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab06_TestNG {

    @Test
    public void test_GET_POSITIVE_TC1() {
        String pincode = "110048";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void test_Get_Negative_TC2() {
        String pincode = "@";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(404); // Expected for invalid pincode
    }

    @Test
    public void test_Get_Negative_TC3() {
        String pincode = " ";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/USA/" + pincode)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(404); // Expected for blank pincode
    }
}
