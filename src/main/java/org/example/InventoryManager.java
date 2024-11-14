package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    private Map<String, Stock> inventory = new HashMap<>();
    private List<Purchase> purchases = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();

    // Adds a purchase to the inventory
    public void addPurchase(String hsnCode, String item, int quantity, double purchaseRate, double saleRate) {
        if (inventory.containsKey(hsnCode)) {
            Stock itemInInventory = inventory.get(hsnCode);
            itemInInventory.addStock(quantity); // Update stock quantity
        } else {
            inventory.put(hsnCode, new Stock(hsnCode, item, quantity, purchaseRate));
        }
        purchases.add(new Purchase(hsnCode, item, quantity, purchaseRate, saleRate));
    }

    // Adds a sale and reduces the stock quantity
    public void addSale(String hsnCode, int quantity) {
        if (inventory.containsKey(hsnCode)) {
            Stock item = inventory.get(hsnCode);
            if (item.getQuantity() >= quantity) {
                item.reduceStock(quantity); // Reduce stock for the sale
                sales.add(new Sale(hsnCode, item.getItemName(), quantity, item.getSalePrice()));
            } else {
                System.out.println("Not enough stock for item: " + hsnCode);
            }
        } else {
            System.out.println("Item code not found in inventory: " + hsnCode);
        }
    }

    // Retrieves the sales list
    public List<Sale> getSales() {
        return sales;
    }

    // Retrieves the inventory
    public Map<String, Stock> getInventory() {
        return inventory;
    }
}
