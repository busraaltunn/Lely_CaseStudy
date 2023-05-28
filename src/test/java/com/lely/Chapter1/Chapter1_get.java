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


    @Test
    public void test1(){

       // String accessToken= "Bearer 1db9c9b6c959682be7c96f74ca532c3cb0bd331f46b86a92602f8d319481b6f5";

        Response response= given().accept(ContentType.JSON)
                .when().get("/public/v1/users");
                //.then()
                //.statusCode(200)
               // .and().body("data.id", everyItem(matchesPattern("\\d{4}")))
                //.and().body("data.id", everyItem(notNullValue()));

        assertThat(response.jsonPath().getList("data.id",String.class), everyItem(hasLength(4)));
        assertThat(response.jsonPath().getList("data.id"),everyItem(notNullValue()));









  }


}
