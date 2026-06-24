package com.qacart.todo.api;

import com.qacart.todo.Utils.UserUtils;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private static List<Cookie> restAssuresCookies;
    private String accessToken;
    private String userId;

    private String firstName;


    public String getUserId(){
        return this.userId;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getToken(){
        return  this.accessToken;
    }
    public List<Cookie> getCookies(){
        return this.restAssuresCookies;
    }

    public void register(){
        User user = UserUtils.generateRandomUser();

        Response response =
                given()
                    .baseUri("https://todo.qacart.com")
                    .header("Content-Type","application/json")
                    .body(user)
                        .log().all()
                .when()
                    .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                        .log().all()
                    .extract().response();

        if(response.statusCode() !=201){
            throw new RuntimeException("User is not registered successfully");
        }

        restAssuresCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName=response.path("firstName");
    }
}
