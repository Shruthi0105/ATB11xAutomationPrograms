package com.TestingAcademy.TestAnnotations;

import org.testng.annotations.AfterTest; // <-- Added this import
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Removed: import java.sql.SQLOutput; (It was unused)

public class Before_Test {

    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods)
    // 4. closeAllThings

    @BeforeTest
    public void gettoken(){ // <-- Opening brace for gettoken()
        System.out.println("first");
        // Logic to get token goes here
    } // <-- Closing brace for gettoken()

    @AfterTest// You can have multiple @BeforeTest methods, they will run before any @Test methods in this test tag
    public void getbookingid(){ // <-- Opening brace for getbookingid()
        System.out.println("2nd execution");
        // Logic to get booking ID goes here
    } // <-- Closing brace for getbookingid()

    @Test
    public void test_PUT(){ // <-- Opening brace for test_PUT()
        // token and BookingID should be available from @BeforeTest methods
        System.out.println("PUT REQUEST executed");
        // Logic for your PUT request goes here
    } // <-- Closing brace for test_PUT()

    @AfterTest
    public void closeAllThings(){ // <-- Opening brace for closeAllThings()
        System.out.println("Close all resources");
        // Logic to close connections or clean up goes here
    } // <-- Closing brace for closeAllThings()

} // <-- Closing brace for the class Before_Test