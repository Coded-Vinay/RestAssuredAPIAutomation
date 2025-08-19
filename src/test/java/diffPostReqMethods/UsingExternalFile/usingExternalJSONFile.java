package diffPostReqMethods.UsingExternalFile;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class usingExternalJSONFile {
    @Test
    void usingJSONFile() throws FileNotFoundException {

        File f = new File("C:\\Users\\VINCHAUD\\IdeaProjects\\apiAutomation\\src\\test\\java\\diffPostReqMethods\\UsingExternalFile\\body.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        given().contentType("application/json").body(data.toString()).header("x-api-key", "reqres-free-v1")
                .when().post("https://reqres.in/api/users")
                .then().log().all().body("name", equalTo("vinay"));


    }
}
