package diffPostReqMethods.UsingPOJOClass;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postUsingPOJO {

    @Test
    void usingPOJO(){

    customPOJOClass data = new customPOJOClass();
    data.setName("vinay");
    data.setLocation("india");
    data.setPhone("1234567890");
    data.setCourse("testing");


        given().contentType("application/json").body(data).header("x-api-key", "reqres-free-v1")
                .when().post("https://reqres.in/api/users")
                .then().log().all()
                .body("name", equalTo("vinay"));

    }
}
