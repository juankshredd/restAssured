package ApiTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class HeadersCookiesAndParams {

    @Test
    public void whenUsingPathParam_thenOk(){

        JSONObject oJson = new JSONObject();
        oJson.put("name", "Test");
        oJson.put("id", 3);
        System.out.println(oJson.toString());

        baseURI = "https://reqres.in/api";
        given().
            header("ContentType", "application/json", "charset=UTF-8").
            contentType(JSON).
            accept(JSON).
        when().
            post("/subjects").
        then().
            statusCode(201).
            log().all();

    }

    @Test
    public void getJsonServer(){
        baseURI = "https://reqres.in/api";

        given().
            get("/users").
        then().
            statusCode(200) ;
    }
}
