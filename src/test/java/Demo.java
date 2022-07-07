import static io.restassured.RestAssured. *;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    @Test
    public void testGetusers(){
        baseURI = "https://reqres.in/api";

        given()
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("data[1].first_name", equalTo("Janet"));
    }

    @Test
    public void testPostusers(){
        baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Alejandra");
        map.put("Job", "Costumer");

        given()
            .log().all()
            .body(map.toString())
        .when()
            .post("/users")
        .then()
            .log().all()
            .statusCode(201);
    }
}
