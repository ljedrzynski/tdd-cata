package pl.ljedrzynski.kata.tdd.discount;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountApplierTest {

    private DiscountApplier discountApplier;

    @Before
    public void setUp() {
        discountApplier = new DiscountApplier();
    }

    @Test
    public void discountForMacAndIphoneTogether() {
        Basket basket = new BasketBuilder()
                .w("MACBOOK", 100)
                .w("IPHONE", 50)
                .build();

        discountApplier.apply(basket);

        assertEquals((100 + 50) * 0.85, basket.getAmount(), 0.0001);
    }

    @Test
    public void discountForNotebookAndWindowsPhoneTogether() {
        Basket basket = new BasketBuilder()
                .w("NOTEBOOK", 100)
                .w("WINDOWS PHONE", 50)
                .build();

        discountApplier.apply(basket);

        assertEquals((100 + 50) * (1 - 0.12), basket.getAmount(), 0.0001);
    }

    @Test
    public void discountForXbox() {
        Basket basket = new BasketBuilder()
                .w("XBOX", 100)
                .build();

        discountApplier.apply(basket);

        assertEquals(100 * (1 - 0.7), basket.getAmount(), 0.0001);
    }

    @Test
    public void discountForLessThanTwoItemsLesserThanThousand() {
        Basket basket = new BasketBuilder()
                .w("REFRIGERATOR", 100)
                .build();

        discountApplier.apply(basket);

        assertEquals(100 * (1 - 0.02), basket.getAmount(), 0.0001);
    }

    @Test
    public void discountFor3or4products() {
        Basket basket = new BasketBuilder()
                .w("REFRIGERATOR", 2000)
                .w("DISH WASHER", 500)
                .w("TRASH CAN", 2500)
                .build();

        discountApplier.apply(basket);

        assertEquals((2000 + 500 + 2500) * (1 - 0.05), basket.getAmount(), 0.0001);
    }

    @Test
    public void discountForMoreThan5Products() {
        Basket basket = new BasketBuilder()
                .w("REFRIGERATOR", 2000)
                .w("DISH WASHER", 500)
                .w("TRASH CAN", 2500)
                .w("BED", 400)
                .w("TOILET", 200)
                .build();

        discountApplier.apply(basket);

        assertEquals((2000 + 500 + 2500 + 400 + 200) * (1 - 0.06), basket.getAmount(), 0.0001);
    }
}
