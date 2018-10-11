package pl.ljedrzynski.kata.tdd.numbers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BiggerAndSmallerTest {

    private BiggerAndSmaller biggerAndSmaller;


    @Before
    public void setUp() {
        biggerAndSmaller = new BiggerAndSmaller();
    }

    private void assertNumbers(int smaller, int bigger) {
        Assert.assertEquals(bigger, biggerAndSmaller.getBigger());
        Assert.assertEquals(smaller, biggerAndSmaller.getSmaller());
    }


    @Test
    public void shouldUnderstandNumbersInIncreasingOrder() {
        biggerAndSmaller.find(new int[]{2, 3, 4});

        assertNumbers(2,4);
    }

    @Test
    public void numbersInDecreasingOrder() {
        biggerAndSmaller.find(new int[]{4, 3, 2});

        assertNumbers(2,4);
    }

    @Test
    public void numbersInAnyOrder() {
        biggerAndSmaller.find(new int[]{19, 5, 2, 17, 15, 10});

        assertNumbers(2,19);
    }


    @Test
    public void onlyOneNumber() {
        biggerAndSmaller.find(new int[]{16});

        assertNumbers(16,16);
    }
}
