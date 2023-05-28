package com.lely.Chapter1;

import com.lely.Utilities.TestBase;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class Chapter1_postAgain extends TestBase {


    @Test
    public void postMethod1() {
        String accessToken = "Bearer 1db9c9b6c959682be7c96f74ca532c3cb0bd331f46b86a92602f8d319481b6f5";

       // String requestBody = "{\"email\": \"umut@gmail.com\", \"name\": \"test\", \"gender\": \"male\", \"status\":"active"}";

        Map<String, Object> requestJsonMap= new LinkedHashMap<>();
        requestJsonMap.put("email", "umut@gmail.com");
        requestJsonMap.put("name", "test");
        requestJsonMap.put("gender","male");
        requestJsonMap.put("status","active");

        Response response = given()
                .header("Authorization", accessToken)
                .contentType(ContentType.JSON)
                .body(requestJsonMap)
                .post("/public/v1/users");

        Assertions.assertEquals(422, response.statusCode());
        //Assertions.assertEquals("has already been taken",response.path("message"));


        String message = response.getBody().asString();
        System.out.println("message: " + message);

        // Check the response status code
        int statusCode = response.getStatusCode();
        if (statusCode == 201) {
            System.out.println("User is created");
        } else {
            System.out.println("has already been taken");
        }


/*
        response.then().body("message", equalTo("has already been taken"));

        String errorMessage = response.jsonPath().getString("message");
        System.out.println("Error message: " + errorMessage);

 */


    }

}
