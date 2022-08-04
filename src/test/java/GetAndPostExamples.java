import jdk.jfr.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static jdk.jfr.ContentType.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {
    @Test
    public void testGet(){
        baseURI = "https://reqres.in/api";

        given().
            get("/users?page=2").
        then().
            statusCode(200).
            body("data[4].first_name", equalTo("George")).
            body("data.first_name", hasItems("George", "Rachel", "Byron"));

    }

    @Test
    public void testPost(){
        Map<String, Object> map = new HashMap<String, Object>();

//        map.put("name", "Juank");
//        map.put("job", "QA automation");
//
//        System.out.println(map);

        JSONObject request = new JSONObject();

        request.put("name", "Juank");
        request.put("Job", "QA Engineer");

        System.out.println(request.toString());

        baseURI = "https://reqres.in/api";

        given().
            header("Content-Type", "application/json").
            contentType(JSON).
            accept(JSON).
            body(request.toJSONString()).
        when().
            post("/user").
        then().
            statusCode(201).
            log().all();
    }
}
