package com.maven.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String transactionId;
    private String productId;
    private String productName;
    private int quantity;
    private double price;
    private double totalAmount;
    private String paymentMethod; // cash or card

    // cash
    private double cashGiven;
    private double changeGiven;

    // card
    private String accountNumber;

    // LOCALDATETIME: Using LocalDateTime instead of Date
    private LocalDateTime timestamp;
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

    // CONSTRUCTOR: For both cash and card payments
    public Transaction(String transactionId, String productId, String productName, int quantity,
            double price, double totalAmount, String paymentMethod, double cashGiven,
            double changeGiven, String accountNumber, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.cashGiven = cashGiven;
        this.changeGiven = changeGiven;
        this.accountNumber = accountNumber;
        this.timestamp = timestamp;
    }

    // ENCAPSULATION: Getters for all fields
    public String getTransactionId() {
        return transactionId;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getCashGiven() {
        return cashGiven;
    }

    public double getChangeGiven() {
        return changeGiven;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // FORMATTING: Generate formatted receipt
    public String toReceipt() {
        double tax = totalAmount * 0.12;
        double subtotal = totalAmount - tax;

        StringBuilder sb = new StringBuilder();

        sb.append("╔════════════════════════════════════════╗\n");
        sb.append("║            J J   S T O R E            ║\n");
        sb.append("╠════════════════════════════════════════╣\n");
        sb.append(String.format("║ TXN: %-25s       ║\n", transactionId));
        sb.append(String.format("║ Date: %-23s     ║\n", timestamp.format(FMT)));
        sb.append("╠════════════════════════════════════════╣\n");
        sb.append(String.format("║ Product: %-29s ║\n", productName));
        sb.append(String.format("║ Qty: %-3d | Unit Price: ₱%-13.2f║\n", quantity, price));
        sb.append("╠════════════════════════════════════════╣\n");
        sb.append(String.format("║ Subtotal: ₱%-29.2f║\n", subtotal));
        sb.append(String.format("║ Tax (12%% VAT): ₱%-24.2f║\n", tax));
        sb.append(String.format("║ TOTAL: ₱%-31.2f║\n", totalAmount));
        sb.append("╠════════════════════════════════════════╣\n");
        sb.append(String.format("║ Payment Method: %-22s║\n", paymentMethod));

        if ("CASH".equals(paymentMethod)) {
            sb.append(String.format("║ Cash Given: ₱%-26.2f║\n", cashGiven));
            sb.append(String.format("║ Change: ₱%-30.2f║\n", changeGiven));
        } else if ("CARD".equals(paymentMethod)) {
            sb.append(String.format("║ Account: %-30s║\n", accountNumber));
        }

        sb.append("╠════════════════════════════════════════╣\n");
        sb.append("║  Thank you for shopping at JJ Store!   ║\n");
        sb.append("╚════════════════════════════════════════╝\n");

        return sb.toString();
    }
}
