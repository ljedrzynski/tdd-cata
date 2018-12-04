package pl.ljedrzynski.kata.tdd.romannumeral;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RomanNumeralTest {

    private RomanNumeral romanNumeral;

    @Before
    public void setUp() {
        romanNumeral = new RomanNumeral();
    }

    @Test
    public void convert_ShouldReturnRomanNumeral_When_InputIsASingleDigitNumber() {
        Assert.assertEquals("I", romanNumeral.convert(1));
    }

}
