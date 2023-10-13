package com.api.serviceBuilder;

import com.api.endpoints.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class tasks {
    // this class will contain CRUD operations of Tasks
    public static Response get_todos_details(int user_id){
        return given().log().all().queryParam("userId",user_id).contentType(ContentType.JSON).
                when().get(Routes.todos_url);

    }
}
