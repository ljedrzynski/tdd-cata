package pl.ljedrzynski.kata.tdd.discount;

import java.util.List;

public class Basket {

    private double amount;
    private List<Item> items;

    public Basket(List<Item> items) {
        this.items = items;
        sumItems();
    }

    private void sumItems() {
        amount = items.stream()
                .mapToDouble(Item::getTotalPrice)
                .sum();
    }

    public void substract(double amount) {
        this.amount -= amount;
    }

    public int qtyOfItems() {
        return items.stream()
                .mapToInt(Item::getQty)
                .sum();
    }

    public boolean has(String product) {
        return items.stream()
                .anyMatch(item -> item.getName().equals(product));
    }

    public double getAmount() {
        return this.amount;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String toString() {
        return "Basket(amount=" + this.getAmount() + ", items=" + this.getItems() + ")";
    }
}
