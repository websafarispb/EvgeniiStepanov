package ru.stepev.test.training.at.hw1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw1.dataprovider.SubtractionDataProvider;

public class CalculatorSubtractionTest extends CalculatorTest {

    public static final double DELTA = 0.001;

    @Test(dataProvider = "Subtraction Long Data Provider", dataProviderClass = SubtractionDataProvider.class)
    public void givenLongNumbers_whenCalculatorSubtraction_thenGiveCorrectLongDifference(long a, long b,
                                                                                         long expected) {
        long actual = calculator.sub(a, b);

        assertEquals(actual,
            expected,
            DELTA);
    }

    @Test(dataProvider = "Subtraction Double Data Provider", dataProviderClass = SubtractionDataProvider.class)
    public void givenDoubleNumbers_whenCalculatorSubtraction_thenGiveCorrectDoubleDifference(double a, double b,
                                                                                             double expected) {
        double actual = calculator.sub(a, b);

        assertEquals(actual,
            expected,
            DELTA);
    }
}
