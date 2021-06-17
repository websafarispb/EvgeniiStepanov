package ru.stepev.test.training.at.hw1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw1.dataprovider.SummationDataProvider;

public class CalculatorSummationTest extends CalculatorTest {

    protected static final double DELTA = 0.001;

    @Test(dataProvider = "Summation Long Data Provider", dataProviderClass = SummationDataProvider.class)
    public void givenLongNumbers_whenCalculatorSummation_thenGiveCorrectLongSum(long a, long b,
                                                                                         long expected) {
        long actual = calculator.sum(a, b);

        assertEquals(actual,
            expected,
            DELTA);
    }

    @Test(dataProvider = "Summation Double Data Provider", dataProviderClass = SummationDataProvider.class)
    public void givenDoubleNumbers_whenCalculatorSubtraction_thenGiveCorrectDoubleSum(double a, double b,
                                                                                             double expected) {
        double actual = calculator.sum(a, b);

        assertEquals(actual,
            expected,
            DELTA);
    }
}
