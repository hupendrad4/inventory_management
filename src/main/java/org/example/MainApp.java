package org.example;// MainApp.java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainApp extends Application {

    private InventoryManager inventoryManager = new InventoryManager();
    private final InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inventory Management System");

        // UI Components
        TextField hsnCodeField = new TextField();
        hsnCodeField.setPromptText("HSN Code");
        TextField itemField = new TextField();
        itemField.setPromptText("Item Name");
        TextField quantityField = new TextField();
        quantityField.setPromptText("Quantity");
        TextField purchaseRateField = new TextField();
        purchaseRateField.setPromptText("Purchase Rate");
        TextField saleRateField = new TextField();
        saleRateField.setPromptText("Sale Rate");

        inventoryManager.addStock("001", "Widget", 50, 20.0);
        inventoryManager.recordSale("001", 5);
        invoiceGenerator.generateInvoice(inventoryManager.getSales());
        inventoryManager.addSale("001", 5); // records a sale of 5 items

        inventoryManager.addStock("001", "Widget", 50, 20.0);
        inventoryManager.addPurchase("001", 10); // adds 10 items to inventory
        inventoryManager.addSale("001", 5); // records a sale of 5 items
        invoiceGenerator.generateInvoice(inventoryManager.getSales());

        Button addPurchaseButton = new Button("Add Purchase");
        addPurchaseButton.setOnAction(e -> {
            String hsnCode = hsnCodeField.getText();
            String item = itemField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double purchaseRate = Double.parseDouble(purchaseRateField.getText());
            double saleRate = Double.parseDouble(saleRateField.getText());
            inventoryManager.addPurchase(new Purchase(hsnCode, item, quantity, purchaseRate, saleRate));
            System.out.println("Purchase added for item: " + item);
        });

        Button generateInvoiceButton = new Button("Generate Invoice");
        generateInvoiceButton.setOnAction(e -> {
            // Example Invoice generation (modify to match actual sales)
            ArrayList<Sale> sales = InvoiceGenerator.generateInvoice("INV001");
            for (Sale sale : sales) {
                System.out.println("Item: " + sale.getItem() + ", Qty: " + sale.getQuantity() + ", Amount: " + sale.getAmount());
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(hsnCodeField, itemField, quantityField, purchaseRateField, saleRateField, addPurchaseButton, generateInvoiceButton);

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
