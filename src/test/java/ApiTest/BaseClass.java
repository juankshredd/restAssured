package ApiTest;

import static io.restassured.RestAssured. *;
import org.testng.annotations.BeforeClass;

public class BaseClass{
    String user = "TollsQA";
    String password = "TestPassword";
    @BeforeClass
    public void setup(){
        authentication = preemptive().basic(user, password);
        baseURI = "https://demoqa.com";
    }
}
