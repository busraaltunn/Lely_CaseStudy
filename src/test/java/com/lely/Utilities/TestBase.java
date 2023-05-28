package com.lely.Utilities;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestBase {


    @BeforeAll
    public static void init(){
        baseURI = ConfigurationReader.getProperty("api_url");

    }


    @AfterAll
    public static void teardown(){
        reset();
    }
}