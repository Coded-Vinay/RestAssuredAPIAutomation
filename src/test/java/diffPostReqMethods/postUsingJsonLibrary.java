package diffPostReqMethods;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class postUsingJsonLibrary {

    @Test(priority=1)
    void usingJsonLibrary() {

    JSONObject data2 = new JSONObject();
    String[] courseArr = {"testing", "development"};
    data2.put("Courses",courseArr);
    data2.put("name","vinay");
    data2.put("age","28");
    data2.put("contact","9876543210");

        given().contentType("application/json").body(data2.toString()).header("x-api-key", "reqres-free-v1")
                .when().post("https://reqres.in/api/users")
                .then().log().all()
                .body("name", equalTo("vinay"));
}
}
