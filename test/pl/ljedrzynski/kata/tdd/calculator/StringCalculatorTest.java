package pl.ljedrzynski.kata.tdd.calculator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_ShouldReturnZero_When_InputIsNull() {
        Assert.assertEquals(0, stringCalculator.add(null));
    }

    @Test
    public void add_ShouldReturnZero_When_InputIsEmpty() throws Exception {        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void add_ShouldReturnInputValue_When_InputIsASingleNumber() throws Exception {
        Assert.assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void add_ShouldReturnSum_When_InputIsAnyAmountOfNumbersSeparatedByComma() throws Exception {
        Assert.assertEquals(1 + 2, stringCalculator.add("1,2"));
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("1,2,3"));
        Assert.assertEquals(1 + 2 + 3 + 10, stringCalculator.add("1,2,3,10"));
        Assert.assertEquals(1 + 2 + 3 + 8 + 15 + 20, stringCalculator.add("1,2,3,8,15,20"));
    }

    @Test
    public void add_ShouldReturnSum_When_InputHasNewLineInsteadOfComma() throws Exception {
        Assert.assertEquals(1 + 2 + 3, stringCalculator.add("1\n2,3"));
    }


}
