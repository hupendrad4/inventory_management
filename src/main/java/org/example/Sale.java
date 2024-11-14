package org.example;


// Sale.java
public class Sale {
    private String invoiceNo;

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getRate() {
        return rate;
    }

    public double getGst() {
        return gst;
    }

    public double getAmount() {
        return amount;
    }

    private String hsnCode;
    private String item;
    private int quantity;
    private double rate;
    private double gst;
    private double amount;

    public double getPrice() {
        return price;
    }

    private double price;

    public Sale(String invoiceNo, String hsnCode, int quantity, double rate) {
        this.invoiceNo = invoiceNo;
        this.hsnCode = hsnCode;
        this.item = item;
        this.quantity = quantity;
        this.rate = rate;
        this.gst = rate * 0.05 * quantity;
        this.amount = (rate * quantity) + this.gst;
    }
    // Getters and Setters
}
