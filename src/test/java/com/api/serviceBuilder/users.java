package com.api.serviceBuilder;

import com.api.endpoints.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class users {

    // this class will contains CRUD operation of users
   public static Response get_users_details(){
       return given().log().all().contentType(ContentType.JSON).
                    when().get(Routes.get_users_url);

   }
}
