package pl.ljedrzynski.kata.tdd.fizzbuzz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void check_ShouldReturnNumber_When_InputIsNotDivisibleByThreeOrFive() {
        Assert.assertEquals("1", fizzBuzz.check(1));
    }

    @Test
    public void check_ShouldReturnFizz_When_InputIsDivisibleByThree() {
        Assert.assertEquals("Fizz", fizzBuzz.check(12));
    }

    @Test
    public void check_ShouldReturnBuzz_When_InputIsDivisibleByFive() {
        Assert.assertEquals("Buzz", fizzBuzz.check(20));
    }

    @Test
    public void check_ShouldReturnFizzBuzz_When_InputIsDivisibleByThreeAndFive() {
        Assert.assertEquals("FizzBuzz", fizzBuzz.check(30));
    }
}
