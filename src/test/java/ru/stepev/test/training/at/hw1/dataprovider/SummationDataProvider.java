package ru.stepev.test.training.at.hw1.dataprovider;

import org.testng.annotations.DataProvider;

public class SummationDataProvider {

    @DataProvider(name = "Summation Double Data Provider")
    public Object[][] summationDoubleDataSet() {
        return new Object[][] {
            {1.2, 2.3, 3.5},
            {22.0, 33.0, 55.0},
            {-6.0, -0.9, -6.9},
            {Double.MIN_VALUE, 1.0, 1.0}
        };
    }

    @DataProvider(name = "Summation Long Data Provider")
    public Object[][] summationLongDataSet() {
        return new Object[][] {
            {100, 200, 300},
            {2200, -330, 1870},
            {-600, -900, -1500},
            {Long.MAX_VALUE, 1L, -9223372036854775808L}
        };
    }
}
