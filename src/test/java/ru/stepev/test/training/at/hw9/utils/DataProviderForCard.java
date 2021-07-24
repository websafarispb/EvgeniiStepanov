package ru.stepev.test.training.at.hw9.utils;

import beans.Card;
import org.testng.annotations.DataProvider;

public class DataProviderForCard {

    @DataProvider
    public Object[][] correctDataProviderForCard() {
        return new Object[][] {
            {"Card 1 created by rest assure"},
            {"Card 2 created by rest assure"},
            {"Card 3 created by rest assure"}
        };
    }

    @DataProvider
    public Object[][] cardDataProvider() {
        return new Object[][] {
            {Card.builder().name("Card 1 created by rest assure").build()},
            {Card.builder().name("Card 2 created by rest assure").build()},
            {Card.builder().name("Card 3 created by rest assure").build()}
        };
    }
}

