package pl.ljedrzynski.kata.tdd.calculator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.ljedrzynski.kata.tdd.calculator.exceptions.NegativeNumberException;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_ShouldReturnZero_When_InputIsAnEmptyString() throws Exception {
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void add_ShouldReturnInput_When_InputIsASingleNumber() throws Exception {
        Assert.assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void add_ShouldReturnSume_When_InputIsAnyAmountOfNumbers() throws Exception {
        Assert.assertEquals(1 + 2, stringCalculator.add("1,2"));
        Assert.assertEquals(1 + 2 + 3 + 4, stringCalculator.add("1,2,3,4"));
        Assert.assertEquals(1 + 2 + 3 + 4 + 10 + 12 + 22 + 30, stringCalculator.add("1,2,3,4,10,12,22,30"));
        Assert.assertEquals(10 + 32 + 100 + 240 + 2500 + 100000, stringCalculator.add("10,32,100,240,2500,100000"));
    }

    @Test
    public void add_ShouldReturnSum_When_InputIsSeparatedWithNewLine() throws Exception {
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("1\n2,3"));
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("\n1,2,3"));
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("1,2,3\n"));
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("1\n2\n3"));
    }

    @Test
    public void add_ShouldReturnSum_When_InputIsSeparatedWithUserDefinedSeparator() throws Exception {
        Assert.assertEquals(1 + 2, stringCalculator.add("//;\n1;2"));
    }

    @Test(expected = NegativeNumberException.class)
    public void add_ShouldThrowException_When_InputHasNegativeNumber() throws Exception {
        stringCalculator.add("-1,2");
    }
}
