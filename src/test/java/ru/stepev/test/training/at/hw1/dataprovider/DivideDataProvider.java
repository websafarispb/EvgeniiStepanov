package ru.stepev.test.training.at.hw1.dataprovider;

import org.testng.annotations.DataProvider;

public class DivideDataProvider {

    @DataProvider(name = "Divide Double Data Provider")
    public Object[][] divideDoubleDataSet() {
        return new Object[][] {
            {1.2, 2.3, 0.521},
            {220.0, -43.0, -5.116},
            {-6.0, -0.9, 6.66},
            {-6.0, -7.0, 0.85},
            {60.0, 2.0, 30}
        };
    }

    @DataProvider(name = "Divide Long Data Provider")
    public Object[][] divideLongDataSet() {
        return new Object[][] {
            {100, 200, 0},
            {2200, -330, -6},
            {-600, -900, 0},
            {10, 5, 2}
        };
    }

    @DataProvider(name = "Divide By Zero Long Data Provider")
    public Object[][] divideByZeroLongDataSet() {
        return new Object[][] {
            {100, 0},
            {2200, 0},
            {-600, 0}
        };
    }

    @DataProvider(name = "Divide By Zero Double Data Provider")
    public Object[][] divideByZeroDoubleDataSet() {
        return new Object[][] {
            {10.0, 0},
            {22.12, 0},
            {-60.0, 0},
            {-20.23, 0}
        };
    }
}
