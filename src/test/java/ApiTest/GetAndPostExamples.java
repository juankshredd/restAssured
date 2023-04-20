package ApiTest;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
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
    public void testPostJsonObj(){

        JSONObject request = new JSONObject();
        request.put("name", "Juank");
        request.put("job", "QA Engineer");
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

    @Test
    public void testPostMapObj(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Juank");
        map.put("job", "QA automation");
        System.out.println(map);

        baseURI = "https://reqres.in";

        given().
            header("Content-Type", "application/json").
            body(map).
        when().
            post("/api/user").
        then().
            statusCode(201).
            log().all();
    }

    @Test
    public void IteratingHeaders()
    { baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("");
        // Get all the headers and then iterate over allHeaders to print each header
        Headers allHeaders = response.headers();
        // Iterate over all the Headers
        for(Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }
}
