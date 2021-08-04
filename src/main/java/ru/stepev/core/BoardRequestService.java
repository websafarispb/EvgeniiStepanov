package ru.stepev.core;

import static ru.stepev.utils.PropertyReader.pageProperty;

import beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class BoardRequestService extends TrelloRequestService {

    private static final String BOARDS = "/1/boards";
    private static final String BOARD = BOARDS + "/{boardId}";

    public BoardRequestService(Map<String, String> parameters, Method method) {
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

        public ApiRequestBuilder setId(String boardId) {
            id = boardId;
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

        public ApiRequestBuilder setPrefsBackground(String prefsBackground) {
            parameters.put("prefs_background", prefsBackground);
            return this;
        }

        public BoardRequestService buildRequest() {
            return new BoardRequestService(parameters, requestMethod);
        }
    }

    public Response sendPostRequest() {
        return RestAssured
            .given().log().all()
            .spec(requestPostSpecification())
            .queryParams(parameters)
            .when()
            .request(requestMethod, BOARDS)
            .prettyPeek();
    }

    public Response sendGetAndDeleteRequest() {
        return RestAssured
            .given().log().all()
            .spec(requestGetDeleteSpecification())
            .pathParam("boardId", id)
            .when().request(requestMethod, BOARD)
            .prettyPeek();
    }

    public static Board getBoard(Response response) {
        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<Board>() {
            }.getType());
    }

    public static Board createBoard(Board board) {
        return getBoard(requestBuilder()
            .setKey(pageProperty.getProperty("trello.key"))
            .setToken(pageProperty.getProperty("trello.token"))
            .setName(board.getName())
            .setMethod(Method.POST)
            .buildRequest()
            .sendPostRequest());
    }

    public static void delete(Board board) {
        requestBuilder()
            .setKey(pageProperty.getProperty("trello.key"))
            .setToken(pageProperty.getProperty("trello.token"))
            .setMethod(Method.DELETE)
            .setId(board.getId())
            .buildRequest()
            .sendGetAndDeleteRequest();
    }
}
