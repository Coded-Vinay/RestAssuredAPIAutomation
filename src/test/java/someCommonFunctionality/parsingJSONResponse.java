package someCommonFunctionality;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class parsingJSONResponse {

    @Test
    void usingJSONObject() {
        Response response = given().contentType(ContentType.JSON).when().get("https://reqres.in/api/users?page=2");
        JSONObject jo = new JSONObject(response.asString());
        for (int i = 0; i < jo.getJSONArray("data").length(); i++) {
            String Lastname = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
            System.out.println(Lastname);
        }
    }

    @Test
    void usingJSONPath() {
        Response response = given().contentType(ContentType.JSON).when().get("https://reqres.in/api/users?page=2");
        String lastname = response.jsonPath().get("data[2].last_name").toString();
        System.out.println(lastname);
        Assert.assertEquals(lastname, "Funke");


    }
}
