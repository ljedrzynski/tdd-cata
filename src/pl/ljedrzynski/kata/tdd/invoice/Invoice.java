package pl.ljedrzynski.kata.tdd.invoice;

import java.util.Calendar;

public class Invoice {
    private int amount;
    private String customer;
    private Calendar date;

    public Invoice(Calendar date, String customer, int amount) {
        this.date = date;
        this.customer = customer;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (amount != invoice.amount) return false;
        if (customer != null ? !customer.equals(invoice.customer) : invoice.customer != null) return false;
        return date != null ? date.equals(invoice.date) : invoice.date == null;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
