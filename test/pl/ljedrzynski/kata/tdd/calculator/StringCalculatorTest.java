package pl.ljedrzynski.kata.tdd.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    //SCENARIOS
    // ""
    // "1"
    // "1, 2"
    // "3, 6"


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
}
