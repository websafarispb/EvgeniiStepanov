package ru.stepev.test.training.at.hw1.dataprovider;

import org.testng.annotations.DataProvider;

public class MultiplyDataProvider {

    @DataProvider(name = "Multiply Double Data Provider")
    public Object[][] multiplyDoubleDataSet() {
        return new Object[][] {
            {1.2, 2.3, 2.76},
            {22.0, -33.0, -726.0},
            {-6.0, -0.9, 5.4},
            {5.0, 0.0, 0.0},
            {0.0, 5.0, 0.0}
        };
    }

    @DataProvider(name = "Multiply Long Data Provider")
    public Object[][] multiplyLongDataSet() {
        return new Object[][] {
            {100, 200, 20_000},
            {2200, -330, -726_000},
            {-600, -900, 540_000},
            {5, 0, 0},
            {0, 5, 0}
        };
    }
}
