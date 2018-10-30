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
    }

    @Test
    public void add_ShouldReturnSum_When_InputIsSeparatedWithNewLine() throws Exception {
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("1\n2,3"));
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("\n1,2,3"));
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("1,2,3\n"));
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("1\n2\n3"));
    }

    @Test
    public void add_ShouldReturnSum_When_InputIsSeparatedWithUserDefinedDelimiter() throws Exception {
        Assert.assertEquals(1 + 2, stringCalculator.add("//;\n1;2"));
    }

    @Test(expected = NegativeNumberException.class)
    public void add_ShouldThrowException_When_InputHasNegativeNumber() throws Exception {
        stringCalculator.add("-1,2");
    }

    @Test
    public void add_ShouldReturnReducedSumByNumbersGreaterThan1000_When_InputHasNumbersGreaterThan1000() throws Exception {
        Assert.assertEquals(2, stringCalculator.add("2,1001"));
    }

    @Test
    public void add_ShouldReturnSum_When_InputIsSeparatedByAnyLengthDelimiter() throws Exception {
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void add_ShouldReturnSum_When_InputIsSeparatedByManyDelimiters() throws Exception {
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void add_ShouldReturnSum_When_InputIsSeparatedByManyDelimitersLongerWhanOneChar() throws Exception {
        Assert.assertEquals(1 + 2 + 3 + 4, stringCalculator.add("//[***][%%%%]\n1***2***3%%%%4"));
    }
}
