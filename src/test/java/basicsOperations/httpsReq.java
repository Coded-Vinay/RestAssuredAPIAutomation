package basicsOperations;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class httpsReq {
    int id;

    @Test(priority = 1)
    void getUser() {
        given().when().get("https://reqres.in/api/users/2").then().log().all();

    }

    @Test(priority = 2)
    void addUser() {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("name", "test");
        data.put("Salary", "1234");
        data.put("age", "23");

        given().contentType("application/json").body(data).header("x-api-key", "reqres-free-v1").when().post("https://reqres.in/api/users").then().log().all();
    }

    @Test(priority = 3)
    void addUsersaveID() {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("name", "test");
        data.put("Salary", "1234");
        data.put("age", "23");
        id = given().contentType("application/json").body(data).header("x-api-key", "reqres-free-v1").when().post("https://reqres.in/api/users").jsonPath().getInt("id");
    }

    @Test(priority = 4, dependsOnMethods = "addUsersaveID")
    void updateUser() {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("name", "updated name");
        data.put("Salary", "12321");
        data.put("age", "52");


        given().contentType("application/json").body(data).header("x-api-key", "reqres-free-v1").when().put("https://reqres.in/api/users/" + id).then().log().all();
    }

    @Test(dependsOnMethods = "addUsersaveID")
    void deleteUser(){

        given().header("x-api-key", "reqres-free-v1").
        when().delete("https://reqres.in/api/users/"+ id). then().statusCode(204).log().all();
    }
}
