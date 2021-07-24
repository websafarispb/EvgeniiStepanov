package ru.stepev.core;

import static org.hamcrest.Matchers.lessThan;
import static ru.stepev.utils.PropertyReader.pageProperty;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;

public abstract class TrelloService {

    protected static URI uri = URI.create("https://api.trello.com");
    protected Method requestMethod;
    protected String id;
    protected static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("key", pageProperty.getProperty("trello.key"));
        credentials.put("token", pageProperty.getProperty("trello.token"));
    }

    public TrelloService(String id, Method requestMethod) {
        this.requestMethod = requestMethod;
        this.id = id;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {

        private Method requestMethod;
        private String id;

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setId(String cardId) {
            id = cardId;
            return this;
        }

        public CardService buildRequest() {
            return new CardService(id, requestMethod);
        }

        public BoardService buildBoardRequest() {
            return new BoardService(id, requestMethod);
        }

        public ListService buildListRequest() {
            return new ListService(id, requestMethod);
        }
    }

    public RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setBaseUri(uri)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.ANY)
            .addParams(credentials)
            .build();
    }

    public RequestSpecification requestSpecificationForUpdate() {
        return new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON).setBaseUri(uri)
            .build();
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_OK)
            .build();
    }

    public static ResponseSpecification badResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.TEXT)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
            .build();
    }
}
