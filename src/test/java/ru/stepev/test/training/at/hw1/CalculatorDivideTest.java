package ru.stepev.test.training.at.hw1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import ru.stepev.test.training.at.hw1.dataprovider.DivideDataProvider;

public class CalculatorDivideTest extends CalculatorTest {

    protected static final double DELTA = 0.01;

    @Test(dataProvider = "Divide Long Data Provider", dataProviderClass = DivideDataProvider.class)
    public void givenLongNumbers_whenCalculatorDivide_thenGiveCorrectLongQuotient(long a, long b,
                                                                                  long expected) {
        long actual = calculator.div(a, b);

        assertEquals(actual,
            expected,
            DELTA);
    }

    @Test(dataProvider = "Divide Double Data Provider", dataProviderClass = DivideDataProvider.class)
    public void givenDoubleNumbers_whenCalculatorDivide_thenGiveCorrectDoubleQuotient(double a, double b,
                                                                                      double expected) {
        double actual = calculator.div(a, b);

        assertEquals(actual,
            expected,
            DELTA);
    }

    @Test(expectedExceptions = NumberFormatException.class,
          dataProvider = "Divide By Zero Long Data Provider",
          dataProviderClass = DivideDataProvider.class)
    public void givenLongDivisorZero_whenCalculatorDivideByZero_thenGiveNumberFormatException(long a, long b) {
        long result = calculator.div(a, b);
    }

    @Test(dataProvider = "Divide By Zero Double Data Provider",
          dataProviderClass = DivideDataProvider.class)
    public void givenDoubleDivisorZero_whenCalculatorDivideByZero_thenGiveInfinity(double a, double b) {
        boolean expected = true;

        double result = calculator.div(a, b);

        boolean actual = Double.isInfinite(result);
        assertEquals(actual, expected);
    }
}
