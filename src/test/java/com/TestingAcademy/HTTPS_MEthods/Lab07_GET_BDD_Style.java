package com.TestingAcademy.HTTPS_MEthods;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab07_GET_BDD_Style {

    @Test
    public void test_positive() {
        String pin_code = "388620";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .log().all()
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }
}
