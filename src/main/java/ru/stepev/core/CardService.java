package ru.stepev.core;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import beans.Card;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.List;
import org.apache.http.HttpStatus;

public class CardService extends TrelloService {

    private static final String CARDS = "/1/cards";
    private static final String CARD = CARDS + "/{cardId}";

    public CardService(String id, Method requestMethod) {
        super(id, requestMethod);
    }

    public Response sendRequest() {
        return RestAssured
            .given().log().all()
            .spec(requestSpecification())
            .pathParam("cardId", id)
            .when().request(requestMethod, CARD)
            .prettyPeek();
    }

    public Response sendUpdateRequest(Card card) {
        return given().spec(requestSpecificationForUpdate())
                      .pathParam("cardId", id)
                      .queryParams(credentials)
                      .body(new Gson().toJson(card))
                      .when()
                      .request(requestMethod, CARD);
    }

    public Response sendCreateRequest(Card card) {
        return given().spec(requestSpecificationForUpdate())
                      .queryParams(credentials)
                      .body(new Gson().toJson(card))
                      .when()
                      .request(requestMethod, CARDS);
    }

    public static Card getCard(Response response) {
        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<Card>() {
            }.getType());
    }

    public static Card createCard(Response response) {
        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<Card>() {
            }.getType());
    }
}
