package pl.ljedrzynski.kata.tdd.invoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class InvoiceFilterTest {

    private InvoiceFilter filter;
    private InvoiceRepository repo;

    @Before
    public void setUp() throws Exception {
        repo = Mockito.mock(InvoiceRepository.class);
        filter = new InvoiceFilter(repo);
    }

    @Test
    public void filterInvoicesHigherThan2000() throws Exception {
        Invoice inv = new Invoice(Calendar.getInstance(), "LUKASZ", 5000);
        Invoice inv2 = new Invoice(Calendar.getInstance(), "LUKASZ", 200);

        Mockito.when(repo.all()).thenReturn(Arrays.asList(inv, inv2));

        List<Invoice> result = filter.filter();

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(inv, result.get(0));
    }

    @Test
    public void filterMicrosoftInvoices() throws Exception {
        Invoice inv = new Invoice(Calendar.getInstance(), "MICROSOFT", 1000);

        Mockito.when(repo.all()).thenReturn(Collections.singletonList(inv));

        List<Invoice> result = filter.filter();

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(inv, result.get(0));
    }
}
