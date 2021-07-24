package ru.stepev.test.training.at.hw9.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static ru.stepev.core.BoardService.createBoard;
import static ru.stepev.core.BoardService.goodResponseSpecification;
import static ru.stepev.core.TrelloService.requestBuilder;
import static ru.stepev.test.training.at.hw9.utils.PropertyReader.pageProperty;

import beans.Board;
import io.restassured.http.Method;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardServiceTest extends BaseTest {

    @Test
    public void givenBoard_whenCreateBoard_thenBoardCreateAndGetGoodResponse() {
        Board actualBoard = createBoard(requestBuilder()
            .setMethod(Method.POST)
            .buildBoardRequest()
            .sendCreateRequest(boardForCreate));
        assertThat(pageProperty.getProperty("trello.test.card.fail.reason"),
            actualBoard,
            allOf((hasProperty("name", is(boardForCreate.getName())))));

        boardForCreate.setId(actualBoard.getId());
    }

    @Test
    public void givenBoardId_whenBoardDelete_thenBoardDeleteAndGetGoodResponse() {
        requestBuilder()
            .setId(boardForDelete.getId())
            .setMethod(Method.DELETE)
            .buildBoardRequest()
            .sendRequest()
            .then().assertThat()
            .spec(goodResponseSpecification())
            .and();
    }
}
