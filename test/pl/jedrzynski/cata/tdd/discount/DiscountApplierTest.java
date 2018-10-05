package pl.jedrzynski.cata.tdd.discount;

import org.junit.Before;
import org.junit.Test;
import pl.ljedrzynski.cata.tdd.discount.Basket;
import pl.ljedrzynski.cata.tdd.discount.DiscountApplier;
import pl.ljedrzynski.cata.tdd.discount.Item;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class DiscountApplierTest {

    private DiscountApplier discountApplier;

    @Before
    public void setUp() {
        discountApplier = new DiscountApplier();
    }

    @Test
    public void discountForMacAndIphoneTogether() {
        Item macbook = new Item("MACBOOK", 1, 100);
        Item iphone = new Item("IPHONE", 1, 50);

        Basket basket = new Basket(Arrays.asList(macbook, iphone));

        discountApplier.apply(basket);

        assertEquals((100 + 50) * 0.85, basket.getAmount(), 0.0001);
    }

    @Test
    public void discountForNotebookAndWindowsPhoneTogether() {
        Item notebook = new Item("NOTEBOOK", 1, 100);
        Item windowsPhone = new Item("WINDOWS PHONE", 1, 50);

        Basket basket = new Basket(Arrays.asList(notebook, windowsPhone));

        discountApplier.apply(basket);

        assertEquals((100 + 50) * (1 - 0.12), basket.getAmount(), 0.0001);
    }

    @Test
    public void discountForXbox() {
        Item xbox = new Item("XBOX", 1, 100);

        Basket basket = new Basket(Collections.singletonList(xbox));

        discountApplier.apply(basket);

        assertEquals(100 * (1 - 0.7), basket.getAmount(), 0.0001);
    }

    @Test
    public void discountForLessThanTwoItemsLesserThanThousand() {
        Item refrigerator = new Item("REFRIGERATOR", 1, 100);

        Basket basket = new Basket(Collections.singletonList(refrigerator));

        discountApplier.apply(basket);

        assertEquals(100 * (1 - 0.02), basket.getAmount(), 0.0001);
    }

    @Test
    public void discountFor3or4products() {
        Item refrigerator = new Item("REFRIGERATOR", 1, 2000);
        Item dishWasher = new Item("DISH WASHER", 1, 500);
        Item trashCan = new Item("TRASH CAN", 1, 2500);

        Basket basket = new Basket(Arrays.asList(refrigerator, dishWasher, trashCan));

        discountApplier.apply(basket);

        assertEquals((2000 + 500 + 2500) * (1 - 0.05), basket.getAmount(), 0.0001);
    }

    @Test
    public void discountForMoreThan5Products() {
        Item refrigerator = new Item("REFRIGERATOR", 1, 2000);
        Item dishWasher = new Item("DISH WASHER", 1, 500);
        Item trashCan = new Item("TRASH CAN", 1, 2500);
        Item bed = new Item("BED", 1, 400);
        Item toilet = new Item("TOILET", 1, 200);

        Basket basket = new Basket(Arrays.asList(refrigerator, dishWasher, trashCan, bed, toilet));

        discountApplier.apply(basket);

        assertEquals((2000 + 500 + 2500 + 400 + 200) * (1 - 0.06), basket.getAmount(), 0.0001);
    }
}
