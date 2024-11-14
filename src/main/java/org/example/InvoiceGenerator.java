package org.example;// InvoiceGenerator.java
import java.util.List;

public class InvoiceGenerator {
    private static final double GST_RATE = 0.18; // 18% GST

    public double calculateTotal(List<Sale> sales) {
        double total = 0;
        for (Sale sale : sales) {
            total += sale.getPrice() * sale.getQuantity();
        }
        return total;
    }

    public double calculateGST(double total) {
        return total * GST_RATE;
    }

    public double calculateGrandTotal(double total, double gst) {
        return total + gst;
    }

    public void generateInvoice(List<Sale> sales) {
        double total = calculateTotal(sales);
        double gst = calculateGST(total);
        double grandTotal = calculateGrandTotal(total, gst);

        System.out.println("----- Invoice -----");
        for (Sale sale : sales) {
            System.out.println(sale.getItem() + " - " + sale.getQuantity() + " x " + sale.getPrice());
        }
        System.out.println("Subtotal: " + total);
        System.out.println("GST (18%): " + gst);
        System.out.println("Grand Total: " + grandTotal);
    }
}
