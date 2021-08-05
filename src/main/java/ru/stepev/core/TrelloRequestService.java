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

public class TrelloRequestService {

    protected static URI uri = URI.create("https://api.trello.com");
    protected static String id;
    protected Method requestMethod;
    protected Map<String, String> parameters;
    protected static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("key", pageProperty.getProperty("trello.key"));
        credentials.put("token", pageProperty.getProperty("trello.token"));
    }

    public RequestSpecification requestGetDeleteSpecification() {
        return new RequestSpecBuilder()
            .setBaseUri(uri)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.ANY)
            .addParams(parameters)
            .build();
    }

    public RequestSpecification requestPostSpecification() {
        return new RequestSpecBuilder()
            .setBaseUri(uri)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.ANY)
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

    public static ResponseSpecification badKeyResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.TEXT)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_UNAUTHORIZED)
            .build();
    }
}
