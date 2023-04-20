package auths;

import static io.restassured.RestAssured. *;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

@Test
public class Oauth {
    public void oauth2(){
        String accessToken = "";
        baseURI = "https://demoqa.com";
        given().
            auth().
            oauth2(accessToken).// Aqui va el token
        when().
            get(baseURI).
        then().
            assertThat().
            statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void oauth1a(){
        String consumerKey = "TollsQA";
        String accessToken = "";
        String consumerSecret = "";
        String tokenSecret = "";
        baseURI = "https://demoqa.com";
        given().
            accept(ContentType.JSON).
            auth().
            oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
        when().
            get(baseURI).
        then() .
            assertThat().
            statusCode(HttpStatus.SC_OK);
    }
}
