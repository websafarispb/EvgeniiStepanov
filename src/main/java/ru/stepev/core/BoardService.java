package ru.stepev.core;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class BoardService extends TrelloService {

    private static final String BOARDS = "/1/boards";
    private static final String BOARD = BOARDS + "/{boardId}";

    public BoardService(String id, Method requestMethod) {
        super(id, requestMethod);
    }

    public Response sendCreateRequest(Board board) {
        return given().spec(requestSpecificationForUpdate())
                      .queryParams(credentials)
                      .body(new Gson().toJson(board))
                      .when()
                      .request(requestMethod, BOARDS);
    }

    public Response sendRequest() {
        return RestAssured
            .given().log().all()
            .spec(requestSpecification())
            .pathParam("boardId", id)
            .when().request(requestMethod, BOARD)
            .prettyPeek();
    }

    public static Board createBoard(Response response) {
        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<Board>() {
            }.getType());
    }

    public static void delete(Board board) {
        requestBuilder().setId(board.getId()).setMethod(Method.DELETE).buildBoardRequest().sendRequest();
    }
}
