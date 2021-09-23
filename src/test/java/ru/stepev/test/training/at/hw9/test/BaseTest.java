package ru.stepev.test.training.at.hw9.test;

import static ru.stepev.core.BoardRequestService.createBoard;
import static ru.stepev.core.BoardRequestService.delete;
import static ru.stepev.core.BoardRequestService.getBoard;
import static ru.stepev.core.BoardRequestService.requestBuilder;
import static ru.stepev.core.CardRequestService.createCard;
import static ru.stepev.core.CardRequestService.getCard;
import static ru.stepev.core.ListRequestService.createList;
import static ru.stepev.core.ListRequestService.getList;
import static ru.stepev.test.training.at.hw9.utils.PropertyReader.pageProperty;

import beans.Board;
import beans.Card;
import beans.List;
import io.restassured.http.Method;
import java.util.Objects;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stepev.core.CardRequestService;
import ru.stepev.core.ListRequestService;

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
        board = createBoard(board);
        boardForDelete = createBoard(boardForDelete);
        list.setIdBoard(board.getId());
        list = createList(list);
        cardForUpdate.setIdList(list.getId());
        cardForUpdate = createCard(cardForUpdate);
        cardForDelete.setIdList(list.getId());
        cardForDelete = createCard(cardForDelete);
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
