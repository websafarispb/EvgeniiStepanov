package ru.stepev.test.training.at.hw9.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ru.stepev.core.CardRequestService.getCard;
import static ru.stepev.core.CardRequestService.requestBuilder;
import static ru.stepev.core.TrelloRequestService.badKeyResponseSpecification;
import static ru.stepev.core.TrelloRequestService.badResponseSpecification;
import static ru.stepev.core.TrelloRequestService.goodResponseSpecification;
import static ru.stepev.test.training.at.hw9.utils.PropertyReader.pageProperty;

import beans.Card;
import io.restassured.http.Method;
import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw9.utils.DataProviderForCard;

public class CardRequestServiceTest extends BaseTest {

    @Test(dataProvider = "cardDataProvider",
          dataProviderClass = DataProviderForCard.class)
    public void givenCard_whenCreatedCard_thenCreatedCardHaveCorrectFields(Card card) {
        card.setIdBoard(board.getId());
        card.setIdList(list.getId());

        Card actualCard = getCard(
            requestBuilder()
                .setKey(pageProperty.getProperty("trello.key"))
                .setToken(pageProperty.getProperty("trello.token"))
                .setMethod(Method.POST)
                .setName(card.getName())
                .setIdList(list.getId())
                .buildRequest().sendCreateRequest());

        assertThat("API failed to find error in entity",
            actualCard,
            allOf((hasProperty("name", is(card.getName()))),
                hasProperty("idList", is(list.getId())),
                hasProperty("id", not("")),
                hasProperty("idBoard", is(board.getId()))));
    }

    @Test
    public void givenCardId_whenGetCardById_thenTheGottenCardHaveCorrectFields() {
        Card actualCard = getCard(
            requestBuilder()
                .setKey(pageProperty.getProperty("trello.key"))
                .setToken(pageProperty.getProperty("trello.token"))
                .setMethod(Method.GET)
                .setId(cardForUpdate.getId())
                .buildRequest().sendRequest());

        assertThat(pageProperty.getProperty("API failed to find error in entity"),
            actualCard,
            allOf((hasProperty("name",
                is(cardForUpdate.getName()))),
                hasProperty("id",
                    is(cardForUpdate.getId()))));
    }

    @Test
    public void givenIncorrectCardId_whenGetCardById_thenGetResponseInvalidId() {
        requestBuilder()
            .setId("60ef45aae73ceb18f1c80484WRONG")
            .setKey(pageProperty.getProperty("trello.key"))
            .setToken(pageProperty.getProperty("trello.token"))
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest()
            .then().assertThat()
            .spec(badResponseSpecification())
            .and()
            .body(containsString("invalid id"));
    }

    @Test
    public void givenIncorrectCardId_whenDeleteCardById_thenGetResponseInvalidId() {
        requestBuilder()
            .setId("60ef45aae73ceb18f1c80484WRONG")
            .setKey(pageProperty.getProperty("trello.key"))
            .setToken(pageProperty.getProperty("trello.token"))
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendRequest()
            .then().assertThat()
            .spec(badResponseSpecification())
            .and()
            .body(containsString("invalid id"));
    }

    @Test
    public void givenCardId_whenDeleteCardById_thenCardDeleteAndGetGoodResponse() {
        requestBuilder()
            .setId(cardForDelete.getId())
            .setKey(pageProperty.getProperty("trello.key"))
            .setToken(pageProperty.getProperty("trello.token"))
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendRequest()
            .then().assertThat()
            .spec(goodResponseSpecification())
            .and();
    }

    @Test
    public void givenCardAndNewCardName_whenUpdateCard_thenCardUpdateAndGetGoodResponse() {

        requestBuilder()
            .setId(cardForDelete.getId())
            .setKey(pageProperty.getProperty("trello.key"))
            .setToken(pageProperty.getProperty("trello.token"))
            .setName("This name was updated by rest assure")
            .setMethod(Method.PUT)
            .buildRequest()
            .sendUpdateRequest()
            .then().assertThat()
            .spec(goodResponseSpecification())
            .and();
    }

    @Test
    public void givenCardIdAndWrongKey_whenGetCardById_thenGetResponseInvalidKey() {
        requestBuilder()
            .setId(cardForUpdate.getId())
            .setKey("invalid_kay")
            .setToken(pageProperty.getProperty("trello.token"))
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest()
            .then().assertThat()
            .spec(badKeyResponseSpecification())
            .and()
            .body(containsString("invalid key"));
    }
}
