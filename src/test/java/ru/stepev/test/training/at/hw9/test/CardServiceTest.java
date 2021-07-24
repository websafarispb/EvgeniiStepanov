package ru.stepev.test.training.at.hw9.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ru.stepev.core.CardService.badResponseSpecification;
import static ru.stepev.core.CardService.createCard;
import static ru.stepev.core.CardService.getCard;
import static ru.stepev.core.CardService.goodResponseSpecification;
import static ru.stepev.core.CardService.requestBuilder;
import static ru.stepev.test.training.at.hw9.utils.PropertyReader.pageProperty;

import beans.Card;
import io.restassured.http.Method;
import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw9.utils.DataProviderForCard;

public class CardServiceTest extends BaseTest {

    @Test(dataProvider = "cardDataProvider",
          dataProviderClass = DataProviderForCard.class)
    public void givenCard_whenCreatedCard_thenCreatedCardHaveCorrectFields(Card card) {
        card.setIdBoard(board.getId());
        card.setIdList(list.getId());

        Card actualCard = createCard(requestBuilder()
            .setId(card.getId())
            .setMethod(Method.POST)
            .buildRequest()
            .sendCreateRequest(card));

        assertThat(pageProperty.getProperty("trello.test.card.fail.reason"),
            actualCard,
            allOf((hasProperty("name", is(card.getName()))),
                hasProperty("idList", is(list.getId())),
                hasProperty("id", not("")),
                hasProperty("idBoard", is(board.getId()))));
    }

    @Test
    public void givenCardId_whenGetCardById_thenTheGottenCardHaveCorrectFields() {
        Card card = getCard(requestBuilder()
            .setId(cardForUpdate.getId())
            .setMethod(Method.GET)
            .buildRequest().sendRequest());
        assertThat(pageProperty.getProperty("trello.test.card.fail.reason"),
            card,
            allOf((hasProperty("name",
                is(cardForUpdate.getName()))),
                hasProperty("id",
                    is(cardForUpdate.getId()))));
    }

    @Test
    public void givenIncorrectCardId_whenGetCardById_thenGetResponseInvalidId() {
        requestBuilder()
            .setId(pageProperty.getProperty("trello.test.card.wrong.id"))
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
            .setId(pageProperty.getProperty("trello.test.card.wrong.id"))
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
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendRequest()
            .then().assertThat()
            .spec(goodResponseSpecification())
            .and();
    }

    @Test
    public void givenCardAndNewCardName_whenUpdateCard_thenCardUpdateAndGetGoodResponse() {
        cardForUpdate.setName(pageProperty.getProperty("trello.test.card.name_for_update"));

        requestBuilder()
            .setId(cardForUpdate.getId())
            .setMethod(Method.PUT)
            .buildRequest()
            .sendUpdateRequest(cardForUpdate)
            .then().assertThat()
            .spec(goodResponseSpecification())
            .and();
    }
}
