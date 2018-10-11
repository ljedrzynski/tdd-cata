package pl.ljedrzynski.kata.tdd.discount;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ProposalGeneratorTest {

    @Test
    public void discountWhenChristmas() throws Exception {
        Basket basket = new BasketBuilder()
                .w("MACBOOK", 1000)
                .build();

        Calendar christmas = new GregorianCalendar(2018, Calendar.DECEMBER, 25);

        Clock fakeClock = Mockito.mock(Clock.class);
        Mockito.when(fakeClock.now()).thenReturn(christmas);

        double finalAmount = new ProposalGenerator(fakeClock).calculateDiscount(basket);

        Assert.assertEquals(1000 * 0.15, finalAmount, 0.00001);
    }
}