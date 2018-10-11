package pl.ljedrzynski.kata.tdd.invoice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InvoiceFilter {
    private InvoiceRepository invoiceRepository;

    public InvoiceFilter(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> filter() {

        List<Invoice> filtered = new ArrayList<>();

        for (Invoice invoice : invoiceRepository.all()) {
            if (invoice.getAmount() > 2000) filtered.add(invoice);
            else if (invoice.getAmount() < 2000 && invoice.getCustomer().equals("MICROSOFT")) filtered.add(invoice);
            else if (invoice.getDate().get(Calendar.YEAR) < 1999) filtered.add(invoice);
        }
        return filtered;
    }
}
