package ru.stepev.core;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import beans.Board;
import beans.List;
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
import org.apache.http.HttpStatus;

public class ListService extends TrelloService {

    private static final String LISTS = "/1/lists";
    private static final String LIST = LISTS + "/{listId}";

    public ListService(String id, Method requestMethod) {
        super(id, requestMethod);
    }

    public Response sendCreateRequest(List list) {
        return given().spec(requestSpecificationForUpdate())
                      .queryParams(credentials)
                      .body(new Gson().toJson(list))
                      .when()
                      .request(requestMethod, LISTS);
    }

    public Response sendRequest() {
        return RestAssured
            .given().log().all()
            .spec(requestSpecification())
            .pathParam("listId", id)
            .when().request(requestMethod, LIST)
            .prettyPeek();
    }

    public static List createList(Response response) {
        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<List>() {
            }.getType());
    }
}
