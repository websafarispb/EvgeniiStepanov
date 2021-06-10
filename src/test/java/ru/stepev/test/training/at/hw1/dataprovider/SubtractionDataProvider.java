package ru.stepev.test.training.at.hw1.dataprovider;

import org.testng.annotations.DataProvider;

public class SubtractionDataProvider {

    @DataProvider(name = "Subtraction Double Data Provider")
    public Object[][] subtractionDoubleDataSet() {
        return new Object[][] {
            {1.2, 2.3, -1.1},
            {22, 33, -11.0},
            {-6.0, -0.9, -5.1},
            {Double.MIN_VALUE, 1.0, -1.0}
        };
    }

    @DataProvider(name = "Subtraction Long Data Provider")
    public Object[][] subtractionLongDataSet() {
        return new Object[][] {
            {100, 200, -100},
            {2200, 330, 1870},
            {-600, -900, 300},
            {Long.MIN_VALUE, 1L, 9223372036854775807L}
        };
    }
}
