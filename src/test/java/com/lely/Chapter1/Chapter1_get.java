package com.lely.Chapter1;

import com.lely.Utilities.TestBase;
import com.lely.pojo.chapter1;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import io.restassured.response.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class Chapter1_get extends TestBase {

    String accessToken= "Bearer 1db9c9b6c959682be7c96f74ca532c3cb0bd331f46b86a92602f8d319481b6f5";
    @Test
    public void test1(){

        chapter1 chapter1=new chapter1();

        given().accept(ContentType.JSON)
                .and().header("Bearer",accessToken)
                .and().body("{}")
                .when().get("/public/v1/users")
                .then()
                .statusCode(200)
                .and().body("data.id", everyItem(matchesPattern("\\d{4}")))
                .and().body("data.id", everyItem(notNullValue()));

        //response.prettyPrint();
        //System.out.println(chapter1.getId());

        /*
        given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON)
                .when().get("/public/v1/users")
                .then().statusCode(200)
                .contentType(ContentType.JSON).log().all();
         */




/*
        int idFromJson= given().header("Authorization", accessToken)
                .and().accept(ContentType.JSON).and()
                .contentType(ContentType.JSON)
                .body(chapter1).log().all()
                .when().get("/public/v1/users")
                .then()
                .statusCode(200)
                .contentType("application/json")
                        .extract().jsonPath().get();

        System.out.println("id"+ idFromJson);

*/

  }


}
