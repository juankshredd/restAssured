import static io.restassured.RestAssured. *;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;


public class RampUpPokemonApi {
    @Test
    public void getPokemon(){

        baseURI = "https://pokeapi.co/api/v2";

        given().
            get("/pokemon/ditto").
        then().
            statusCode(200).
            body("abilities[0].ability.name", equalTo("limber")).
            log().all();
        System.out.println();
    }
}
