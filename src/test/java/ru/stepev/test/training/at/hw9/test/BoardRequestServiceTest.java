package ru.stepev.test.training.at.hw9.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static ru.stepev.core.BoardRequestService.getBoard;
import static ru.stepev.core.BoardRequestService.requestBuilder;
import static ru.stepev.core.TrelloRequestService.goodResponseSpecification;
import static ru.stepev.test.training.at.hw9.utils.PropertyReader.pageProperty;

import beans.Board;
import io.restassured.http.Method;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class BoardRequestServiceTest extends BaseTest {

    @Test
    public void givenBoard_whenCreateBoard_thenBoardCreateAndGetGoodResponse() {
        Board actualBoard = getBoard(requestBuilder()
            .setName(boardForCreate.getName())
            .setPrefsBackground("red")
            .setMethod(Method.POST)
            .buildRequest()
            .sendPostRequest());

        assertThat("API failed to find error in entity",
            actualBoard,
            allOf((hasProperty("name", is(boardForCreate.getName())))));

        boardForCreate.setId(actualBoard.getId());
    }

    @Test
    public void givenBoardId_whenBoardDelete_thenBoardDeleteAndGetGoodResponse() {
        requestBuilder()
            .setId(boardForDelete.getId())
            .setPrefsBackground("red")
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendGetAndDeleteRequest()
            .then().assertThat()
            .spec(goodResponseSpecification())
            .and();
    }

    @Test
    public void givenBoardId_whenGetBoard_thenBoardGetGoodResponse() {
        Board actualBoard = getBoard(requestBuilder()
            .setId("60ef45290539a902b11ee0bb")
            .setMethod(Method.GET)
            .buildRequest()
            .sendGetAndDeleteRequest());

        assertThat("API failed to find error in entity",
            actualBoard,
            allOf((hasProperty("name", is("Testing")))));
    }
}
