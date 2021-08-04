package ru.stepev.core;

import static io.restassured.RestAssured.given;
import static ru.stepev.utils.PropertyReader.pageProperty;

import beans.Card;
import beans.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import ru.stepev.core.CardRequestService.ApiRequestBuilder;

public class ListRequestService extends TrelloRequestService {

    private static final String LISTS = "/1/lists";
    private static final String LIST = LISTS + "/{listId}";

    public ListRequestService(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
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

        public ApiRequestBuilder setId(String listId) {
            id = listId;
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

        public ApiRequestBuilder setIdBoard(String idBoard) {
            parameters.put("idBoard", idBoard);
            return this;
        }

        public ListRequestService buildRequest() {
            return new ListRequestService(parameters, requestMethod);
        }
    }

    public Response sendRequest() {
        return RestAssured
            .given().log().all()
            .spec(requestGetDeleteSpecification())
            .pathParam("listId", id)
            .when().request(requestMethod, LIST)
            .prettyPeek();
    }

    public Response sendUpdateRequest() {
        return given().spec(requestPostSpecification())
                      .pathParam("listId", id)
                      .queryParams(parameters)
                      .when()
                      .request(requestMethod, LIST);
    }

    public Response sendCreateRequest() {
        return RestAssured
            .given().log().all()
            .spec(requestPostSpecification())
            .queryParams(parameters)
            .when()
            .request(requestMethod, LISTS)
            .prettyPeek();
    }

    public static List getList(Response response) {
        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<List>() {
            }.getType());
    }

    public static List createList(List list) {
        return getList(ListRequestService.requestBuilder()
                                                 .setKey(pageProperty.getProperty("trello.key"))
                                                 .setToken(pageProperty.getProperty("trello.token"))
                                                 .setName(list.getName())
                                                 .setMethod(Method.POST)
                                                 .setIdBoard(list.getIdBoard())
                                                 .buildRequest().sendCreateRequest());
    }
}
