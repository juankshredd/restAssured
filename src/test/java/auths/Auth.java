package auths;

import static io.restassured.RestAssured. *;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


public class Auth {

    @Test
    public void basicAuth(){
        baseURI = "https://posqa1.novaventa.com.co/login";
        given().auth().
            basic("cajCart2", "cajCart2").
        when().
            get(baseURI).
        then().
            assertThat().
            statusCode(HttpStatus.SC_OK).log().all();
    }

    @Test
    public void preemptive(){
        baseURI = "https://posqa1.novaventa.com.co";
        String complement = "/login";
        String code =
                String.valueOf(given().
                    auth().
                    preemptive().
                    basic("cajCart2", "cajCart2").
                when().
                    get(complement).
                then().
                    assertThat().
                    statusCode(HttpStatus.SC_OK));
        //System.out.println(code);
    }

    @Test
    public void digestAuth(){
        baseURI = "https://posqa1.novaventa.com.co";
        String complement = "/login";
        ValidatableResponse code =
        given().
            auth().
            digest("cajCart2", "cajCart2").
        when().
            get(complement).
        then().
            assertThat().
            statusCode(HttpStatus.SC_OK);
        System.out.println(code.extract().body());
    }

    @Test
    public void formAuth(){
        baseURI = "https://demoqa.com";
        String complement = "/subjects";
        given().
            auth().
            form("TollsQA", "TestPassword", new FormAuthConfig("/perform_login", "username", "password")).
        when().
            get(complement).
        then().
            assertThat().
            statusCode(HttpStatus.SC_OK);
    }
}
