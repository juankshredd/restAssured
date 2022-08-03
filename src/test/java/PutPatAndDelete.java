import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class PutPatAndDelete {
    @Test
    public void testPut(){

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
                put("/user/2").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testPatch(){

        JSONObject request = new JSONObject();

        request.put("name", "Juank");
        request.put("Job", "QA Automation");

        System.out.println(request.toString());

        baseURI = "https://reqres.in/";

        given().
                header("Content-Type", "application/json").
                contentType(JSON).
                accept(JSON).
                body(request.toJSONString()).
        when().
                patch("api/users/2").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testDelete(){

        JSONObject request = new JSONObject();

        request.put("name", "Juank");
        request.put("Job", "QA Automation");

        System.out.println(request.toString());

        baseURI = "https://reqres.in/";

        given().
                header("Content-Type", "application/json").
                contentType(JSON).
                accept(JSON).
                body(request.toJSONString()).
        when().
                delete("api/users/2").
        then().
                statusCode(204).
                log().all();
    }
}
