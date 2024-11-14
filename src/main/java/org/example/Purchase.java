package org.example;

// Purchase.java
public class Purchase {
    public String getHsnCode() {
        return hsnCode;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPurchaseRate() {
        return purchaseRate;
    }

    public double getSaleRate() {
        return saleRate;
    }

    private String hsnCode;
    private String item;
    private int quantity;
    private double purchaseRate;
    private double saleRate;

    public Purchase(String hsnCode, String item, int quantity, double purchaseRate, double saleRate) {
        this.hsnCode = hsnCode;
        this.item = item;
        this.quantity = quantity;
        this.purchaseRate = purchaseRate;
        this.saleRate = saleRate;
    }
    // Getters and Setters
}
