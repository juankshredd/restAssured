import static io.restassured.RestAssured. *;
import org.testng.annotations.BeforeClass;

public class BaseClass{
    @BeforeClass
    public void setup(){
        authentication = preemptive().basic("ToolsQA", "TestPassword");
        baseURI = "https://demoqa.com/forms/";
    }
}
