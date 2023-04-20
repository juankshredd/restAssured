package deserializingTest;

import static io.restassured.RestAssured.*;

import deserializingPojo.ListUsersApiPojo;
import org.testng.annotations.Test;


public class deTest {
    @Test

    public void deserTest(){
        baseURI = "https://reqres.in/api/users?page=2";

        given().
        when().
            get().as(ListUsersApiPojo.class);
    }
}
