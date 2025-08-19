package someCommonFunctionality;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.keyStore;

public class cookiesAndHeaders {


    @Test(priority = 1)
    void getCookies() {

        Response res = given().when().get("https://www.google.com/");

        // get single cookies info
        String cookieValue = res.getCookie("AEC");
        System.out.println("Cookie  Value for  AEC = " + cookieValue);

        Map<String, String> cookies = res.getCookies();
        System.out.println(cookies.keySet());


        for (String K : cookies.keySet()) {
            String cookiesVal = res.getCookie(K);
            System.out.println(K + "  " + cookiesVal);

        }

    }

    @Test(priority = 2)
    void getHeaders() {


        // validation for specific header value
        given().when().get("https://www.google.com/").then().header("Server", "gws").log().all();

        // get single cookies info

        Response res = given().when().get("https://www.google.com/");

        String headerValue = res.getHeader("Server");
        System.out.println("Header  Value for Server = " + headerValue);

        Headers headers = res.getHeaders();

        for (Header K : headers) {
            System.out.println(K.getName() + "   " + K.getValue());
        }


    }
}
