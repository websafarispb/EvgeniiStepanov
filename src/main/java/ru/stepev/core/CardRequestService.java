package ru.stepev.core;

import static io.restassured.RestAssured.given;
import static ru.stepev.utils.PropertyReader.pageProperty;

import beans.Card;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class CardRequestService extends TrelloRequestService {

    private static final String CARDS = "/1/cards";
    private static final String CARD = CARDS + "/{cardId}";

    public CardRequestService(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
        parameters.putIfAbsent("token", credentials.get("token"));
        parameters.putIfAbsent("key", credentials.get("key"));
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setId(String cardId) {
            id = cardId;
            return this;
        }

        public ApiRequestBuilder setToken(String token) {
            parameters.put("token", token);
            return this;
        }

        public ApiRequestBuilder setKey(String key) {
            parameters.put("key", key);
            return this;
        }

        public ApiRequestBuilder setName(String name) {
            parameters.put("name", name);
            return this;
        }

        public ApiRequestBuilder setIdList(String idList) {
            parameters.put("idList", idList);
            return this;
        }

        public CardRequestService buildRequest() {
            return new CardRequestService(parameters, requestMethod);
        }
    }

    public Response sendRequest() {
        return RestAssured
            .given().log().all()
            .spec(requestGetDeleteSpecification())
            .pathParam("cardId", id)
            .when().request(requestMethod, CARD)
            .prettyPeek();
    }

    public Response sendUpdateRequest() {
        return given().spec(requestPostSpecification())
                      .pathParam("cardId", id)
                      .queryParams(parameters)
                      .when()
                      .request(requestMethod, CARD);
    }

    public Response sendCreateRequest() {
        return given().spec(requestPostSpecification())
                      .queryParams(parameters)
                      .when()
                      .request(requestMethod, CARDS);
    }

    public static Card getCard(Response response) {
        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<Card>() {
            }.getType());
    }

    public static Card createCard(Card card) {
        return getCard(CardRequestService.requestBuilder()
                                         .setName(card.getName())
                                         .setMethod(Method.POST)
                                         .setIdList(card.getIdList())
                                         .buildRequest().sendCreateRequest());
    }
}
