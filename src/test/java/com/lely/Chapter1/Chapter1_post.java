package com.lely.Chapter1;

import com.lely.Utilities.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class Chapter1_post extends TestBase {

    @Test
    public void postMethod1(){

        String accessToken= "Bearer 1db9c9b6c959682be7c96f74ca532c3cb0bd331f46b86a92602f8d319481b6f5";


        String requestJsonBody= "{\\\"email\\\":\\\"umut@gmail.com\\\",\\n\" +\n" +
                "                \"\\\"name\\\":\\\"test\\\",\\n\" +\n" +
                "                \"\\\"gender\\\":\\\"male\\\",\\n\" +\n" +
                "                 \"\\\"status\\\":active}";


/*
        Map<String, Object> requestJsonMap= new LinkedHashMap<>();
        requestJsonMap.put("email", "umut@gmail.com");
        requestJsonMap.put("name", "test");
        requestJsonMap.put("gender","male");
        requestJsonMap.put("status","active");

 */

        Response response = given().accept(ContentType.JSON)
                .and().header("Authorization","Bearer"+ accessToken)
                .and().contentType(ContentType.JSON)
                .body(requestJsonBody).log().all()
                .when().post("/public/v1/users");

        //verify
        assertThat(response.statusCode(), is(201));
        assertThat(response.contentType(), is("application/json"));
        assertThat(response.path("data.email"),is("umut@gmail.com"));
        assertThat(response.path("data.name"),is("test"));
        assertThat(response.path("data.gender"),is("male"));
        assertThat(response.path("data.status"),is("active"));

        response.prettyPrint();


    }


}
