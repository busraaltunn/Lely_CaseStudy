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


        Response response= given().accept(ContentType.JSON)
                .when().get("/public/v1/users");
                //.then()
                //.statusCode(200)


        assertThat(response.jsonPath().getList("data.id",String.class), everyItem(hasLength(4)));
        assertThat(response.jsonPath().getList("data.id"),everyItem(notNullValue()));









  }


}
