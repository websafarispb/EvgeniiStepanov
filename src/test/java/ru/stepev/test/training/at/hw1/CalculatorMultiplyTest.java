package ru.stepev.test.training.at.hw1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw1.dataprovider.MultiplyDataProvider;

public class CalculatorMultiplyTest extends CalculatorTest {

    protected static final double DELTA = 0.01;

    @Test(dataProvider = "Multiply Long Data Provider", dataProviderClass = MultiplyDataProvider.class)
    public void givenLongNumbers_whenCalculatorMultiply_thenGiveCorrectLongMultiply(long a, long b,
                                                                                         long expected) {
        long actual = calculator.mult(a, b);

        assertEquals(actual,
            expected,
            DELTA);
    }

    @Test(dataProvider = "Multiply Double Data Provider", dataProviderClass = MultiplyDataProvider.class)
    public void givenDoubleNumbers_whenCalculatorMultiply_thenGiveCorrectDoubleMultiply(double a, double b,
                                                                                             double expected) {
        double actual = calculator.mult(a, b);

        assertEquals(actual,
            expected,
            DELTA);
    }
}
