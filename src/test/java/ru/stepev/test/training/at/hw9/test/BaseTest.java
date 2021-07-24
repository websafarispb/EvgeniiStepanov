package ru.stepev.test.training.at.hw9.test;

import static org.hamcrest.Matchers.containsString;
import static ru.stepev.core.BoardService.createBoard;
import static ru.stepev.core.BoardService.delete;
import static ru.stepev.core.CardService.createCard;
import static ru.stepev.core.ListService.createList;
import static ru.stepev.core.TrelloService.badResponseSpecification;
import static ru.stepev.core.TrelloService.requestBuilder;
import static ru.stepev.test.training.at.hw9.utils.PropertyReader.pageProperty;

import beans.Board;
import beans.Card;
import beans.List;
import io.restassured.http.Method;
import java.util.Objects;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static Board board = Board.builder().name("Board created by Rest Assure three").build();
    public static Board boardForCreate = Board.builder().name("Board for create. Created by Rest Assure three").build();
    public static Board boardForDelete = Board.builder().name("Board for delete").build();
    public static List list = List.builder().name("List created by Rest Assure").build();
    public static Card cardForUpdate = Card.builder().name("Card for test Update and Get").build();
    public static Card cardForDelete = Card.builder().name("Card for test Delete").build();

    @BeforeClass
    public void setUp() {
        System.out.println("<<<<<<<===Before class===>>>>>>");
        board = createBoard(requestBuilder()
            .setMethod(Method.POST)
            .buildBoardRequest()
            .sendCreateRequest(board));

        boardForDelete = createBoard(requestBuilder()
            .setMethod(Method.POST)
            .buildBoardRequest()
            .sendCreateRequest(boardForDelete));

        list.setIdBoard(board.getId());

        list = createList(requestBuilder()
            .setMethod(Method.POST)
            .buildListRequest()
            .sendCreateRequest(list));

        cardForUpdate.setIdBoard(board.getId());
        cardForUpdate.setIdList(list.getId());
        cardForUpdate = createCard(requestBuilder().setMethod(Method.POST)
                                                   .buildRequest()
                                                   .sendCreateRequest(cardForUpdate));

        cardForDelete.setIdBoard(board.getId());
        cardForDelete.setIdList(list.getId());
        cardForDelete = createCard(requestBuilder().setMethod(Method.POST)
                                                   .buildRequest()
                                                   .sendCreateRequest(cardForUpdate));
    }

    @AfterClass
    public void tearDown() {
        System.out.println("<<<<<<<===After class===>>>>>>");
        if (!Objects.isNull(board.getId())) {
            delete(board);
        }
        if (!Objects.isNull(boardForDelete.getId())) {
            delete(boardForDelete);
        }
        if (!Objects.isNull(boardForCreate.getId())) {
            delete(boardForCreate);
        }
    }
}
