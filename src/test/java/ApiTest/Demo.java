package ApiTest;

import static io.restassured.RestAssured. *;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class Demo extends BaseClass{
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
        map.put("name", "Picasso");
        map.put("Job", "Painter");

        given()
            .log().all()
            .body(map.toString())
        .when()
            .post("/users")
        .then()
            .log().all()
            .statusCode(201);
    }

    @Test
    public void test_1(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test_2(){
        baseURI = "https://reqres.in/api";
            given()
                .get("/users?page=2").
            then().statusCode(200).
                body("data[1].id", equalTo(8)).
                log().all();
    }

    @Test
    public void preemptiveTest(){
        String complement = "/login/";
        String complement1 = "/forms/";
        int code =
            when().
                get(complement1).
                getStatusCode();
        System.out.println("Response Code From Server is: " + code);

        int code1 =
            when().
                get(complement).
                getStatusCode();
        System.out.println("Response Code From Server is: " + code1);
    }

    @Test
    public void testPostJSONServer(){
        baseURI = "https://reqres.in/api";
        String complement = "/users";
        String email = "helenita@mail.pez";
        String password = "PasswordHelena";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nickname", "Helena");
        map.put("password", "PasswordHelena");
        map.put("subjectId", 3);
        map.put("id", 5);

        given().
            header("Content-Type", "application/json", "charset=UTF-8").
            auth().
            basic(email, password).
            log().all().
        when().
            post(complement).
        then().
            log().all().
            statusCode(HttpStatus.SC_CREATED);
    }
}
