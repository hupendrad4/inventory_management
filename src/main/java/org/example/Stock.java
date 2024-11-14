package org.example;

// Stock.java
public class Stock {
    private String itemName;
    private int quantity;
    private double price;
    double salePrice;

    // Corrected constructor name to match the class name
    public Stock(String itemCode, String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public void addStock(int quantity) {
        this.quantity += quantity;
    }

    public void reduceStock(int quantity) {
        this.quantity -= quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getSalePrice() {
        return salePrice;
    }
}
