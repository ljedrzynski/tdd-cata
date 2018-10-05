package pl.ljedrzynski.cata.tdd.discount;

public class Item {

    private final String name;
    private final int qty;
    private final double unitPrice;

    public Item(String name, int qty, double unitPrice) {
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return unitPrice * qty;
    }

    public String getName() {
        return this.name;
    }

    public int getQty() {
        return this.qty;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public String toString() {
        return "Item(name=" + this.getName() + ", qty=" + this.getQty() + ", unitPrice=" + this.getUnitPrice() + ")";
    }
}
