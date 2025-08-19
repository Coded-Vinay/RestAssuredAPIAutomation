package someCommonFunctionality;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class pathAndQueryParameters {

    @Test
    void pathAndQueryParam (){

        given().pathParam("mypath","users").queryParam("page", "2")
                .when().get("https://reqres.in/api/{mypath}")
                .then().log().all();
    }
}

