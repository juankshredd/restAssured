package pokemon;

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
    }
    @Test
    public void getPokemonV2(){

        baseURI = "https://pokeapi.co/api/v2";

        String body =
                given().
                when().
                    get().
                then().
                    statusCode(200).
                    extract().body().asString();
        System.out.println(body);

    }
}
