package ApiTest;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredDemo extends BaseClass{
    @Test
    public void test(){

        // respuesta a la peticion
//        int code = given()
//        .when()
//            .get()
//            .getStatusCode();
//
//        System.out.println("Response code from server is " + code);
//
//        // autenticacion basica
//        RequestSpecification httpRequest = given().auth().basic("postman", "password");
//        Response res = httpRequest.get("https://postman-echo.com/basic-auth");
//        ResponseBody body = res.body();
//        //Converting the response body to string
//        String rbdy = body.asString();
//        System.out.println("Data from the GET API- "+rbdy);
//
//
//        // preemtive authentication
//        //Using the preemptive directive of basic auth to send credentials to the server
//        RequestSpecification httpRequest = given()
//                .auth().preemptive().basic("postman", "password");
//        Response res = httpRequest.get("https://postman-echo.com/basic-auth");
//        ResponseBody body = res.body();
//        //Converting the response body to string
//        String rbdy = body.asString();
//        System.out.println("Data from the GET API- "+rbdy);
//
//        // digestive authentication el password no se expone y solo hace de a 1 transaccion
//        //este codigo es solo ejemplo, no tiene URL endpoint
//        RequestSpecification httpRequest = given().auth().digest("your username", "your password").get("your end point URL");
//        Response res = httpRequest.get("https://postman-echo.com/basic-auth");
//        ResponseBody body = res.body();
//        //Converting the response body to string
//        String rbdy = body.asString();
//        System.out.println("Data from the GET API- "+rbdy);
//
////         form auth cuando las credenciales se insertan a un formulario html
////        given() .auth().form("your username", "your password").post("your end point URL");
////         con esto se maneja errores si la pagina es muy compleja y el context path no esta incluido en el atributo de accion del servicio
////         given().auth().form("your username", "your password", new FormAuthConfig("/perform_signIn","user","password"));
////         OAuth 1.0
////        Secured resources built using OAuth 1.0 requires passing consumer key, secret, access token, and token secret. The syntax it follows is -
////         given().auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).get("your end point URL");
////         OAuth 2.0
////         While using OAuth 2.0 you need to directly pass the access token generated when the user login using the below syntax-
////         given().auth().oauth2("Access token").get("your end point URL");
    }
}
