package com.lely.Chapter1;

import com.lely.Utilities.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class Chapter1_postAgain extends TestBase {


    @Test
    public void postMethod1() {
        String accessToken = "1db9c9b6c959682be7c96f74ca532c3cb0bd331f46b86a92602f8d319481b6f5";

        String requestBody = "{\"name\": \"John Doe\", \"gender\": \"Male\", \"email\": \"johndoe@example.com\"}";

        Response response = given()
                .header("Bearer", accessToken)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/public/v1/users");

        response.then().statusCode(422);

        response.then().body("message", equalTo("has already been taken"));

        String errorMessage = response.jsonPath().getString("message");
        System.out.println("Error message: " + errorMessage);
    }

}
