package diffPostReqMethods;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class postUsingHasmap {

    @Test(priority = 1)
    void usingHasmap() {
        HashMap<Object, Object> data = new HashMap<>();
        data.put("name", "vinay");
        data.put("age", "28");
        data.put("contact", "9876543210");

        String[] courseArr = {"testing", "development"};
        data.put("Courses", courseArr);


        given().contentType("application/json").body(data).header("x-api-key", "reqres-free-v1")
                .when().post("https://reqres.in/api/users")
                .then().log().all()
                .body("name", equalTo("vinay"));

        System.out.println("Printing response Now");

        String response = given().contentType("application/json").body(data).header("x-api-key", "reqres-free-v1")
                .when().post("https://reqres.in/api/users")
                .then().extract().body().asString();
        System.out.println(response);

    }

}
