package pl.ljedrzynski.kata.tdd.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    //SCENARIOS
    // ""
    // "1"
    // "1,2"
    // "3,6"
    // "3,6,10"

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void addEmptyInput() throws Exception {
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void addSingleNumberOne() throws Exception {
        Assert.assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void addSingleNumberTwo() throws Exception {
        Assert.assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    public void addNumberOneAndTwo() throws Exception {
        Assert.assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void addThreeNumbers() throws Exception {
        Assert.assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    public void addTenNumbers() throws Exception {
        Assert.assertEquals(278, stringCalculator.add("5,7,10,12,20,20,30,35,39,100"));
    }

    @Test
    public void addNumberInNewLine() throws Exception {
        Assert.assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void addCommaAndNumberBeforeNewLine() throws Exception {
        Assert.assertEquals(1, stringCalculator.add("1,\n"));
    }
}
