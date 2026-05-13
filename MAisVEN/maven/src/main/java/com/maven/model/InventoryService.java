package com.maven.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class InventoryService {

    private List<Product> products = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private double vaultCash = 2000.0;
    private final double baseCash = 2000.0;

    private final String receiptFile = "receipts.txt";
    private final String productsFile = "src/main/resources/Products.json";
    private final String accountsFile = "src/main/resources/Accounts.json";

    private final Gson gson = new Gson();
    private static int transactionCounter = 1000;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

    public InventoryService() {
        loadData();
    }

    /**
     * Helper to find the file in 'data/' folder or root.
     */
    private File resolveFile(String fileName) {
        File dataFolderFile = new File("data/" + fileName);
        if (dataFolderFile.exists()) {
            return dataFolderFile;
        }
        return new File(fileName);
    }

    private synchronized void loadData() {
        try {
            // Load Products
            File prodFile = resolveFile(productsFile);
            if (!prodFile.exists()) {
                System.err.println("✗ ERROR: Products file NOT FOUND at " + prodFile.getAbsolutePath());
            } else {
                try (BufferedReader reader = new BufferedReader(new FileReader(prodFile))) {
                    products = gson.fromJson(reader, new TypeToken<List<Product>>() {
                    }.getType());
                    if (products == null) {
                        products = new ArrayList<>();
                    }
                    System.out.println("✓ Loaded " + products.size() + " products from: " + prodFile.getPath());
                }
            }

            // Load Accounts
            File accFile = resolveFile(accountsFile);
            if (!accFile.exists()) {
                System.err.println("✗ ERROR: Accounts file NOT FOUND at " + accFile.getAbsolutePath());
            } else {
                try (BufferedReader reader = new BufferedReader(new FileReader(accFile))) {
                    accounts = gson.fromJson(reader, new TypeToken<List<Account>>() {
                    }.getType());
                    if (accounts == null) {
                        accounts = new ArrayList<>();
                    }
                    System.out.println("✓ Loaded " + accounts.size() + " accounts.");
                }
            }
        } catch (IOException e) {
            System.err.println("✗ Error loading data: " + e.getMessage());
        }
    }

    private synchronized void saveData() {
        try {
            File pFile = resolveFile(productsFile);
            File aFile = resolveFile(accountsFile);

            try (BufferedWriter pWriter = new BufferedWriter(new FileWriter(pFile)); BufferedWriter aWriter = new BufferedWriter(new FileWriter(aFile))) {
                gson.toJson(products, pWriter);
                gson.toJson(accounts, aWriter);
                System.out.println("✓ Data saved to disk.");
            }
        } catch (IOException e) {
            System.err.println("✗ Error saving data: " + e.getMessage());
        }
    }

    public synchronized String processCashPayment(String pid, int qty, double cashGiven) {
        Product p = findProduct(pid);
        if (p == null) {
            return "DENIED|Product not found";
        }
        if (!p.hasStock(qty)) {
            return "DENIED|Insufficient stock";
        }

        double total = p.getPrice() * qty;
        double change = cashGiven - total;
        if (change < 0) {
            return "DENIED|Insufficient cash (Total: ₱" + total + ")";
        }

        p.setStockQuantity(p.getStockQuantity() - qty);
        vaultCash += total;

        Transaction txn = new Transaction("TXN" + (transactionCounter++), pid, p.getName(), qty, p.getPrice(), total, "CASH", cashGiven, change, "", LocalDateTime.now());
        transactions.add(txn);
        saveData();
        return "SUCCESS|Change: ₱" + String.format("%.2f", change);
    }

    public synchronized String processCardPayment(String pid, int qty, String accNo, String pin) {
        Product p = findProduct(pid);
        Account acc = findAccount(accNo);

        if (p == null) {
            return "DENIED|Product not found";
        }
        if (acc == null) {
            return "DENIED|Account not found";
        }
        if (!acc.authenticate(pin)) {
            return "DENIED|Incorrect PIN";
        }
        if (!p.hasStock(qty)) {
            return "DENIED|Insufficient stock";
        }

        double total = p.getPrice() * qty;
        if (!acc.hasSufficientFunds(total)) {
            return "DENIED|Insufficient balance";
        }

        p.setStockQuantity(p.getStockQuantity() - qty);
        acc.setBalance(acc.getBalance() - total);
        vaultCash += total;

        Transaction txn = new Transaction("TXN" + (transactionCounter++), pid, p.getName(), qty, p.getPrice(), total, "CARD", 0, 0, accNo, LocalDateTime.now());
        transactions.add(txn);
        saveData();
        return "SUCCESS|Deducted: ₱" + String.format("%.2f", total);
    }

    private Product findProduct(String id) {
        return products.stream().filter(p -> p.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    private Account findAccount(String accNo) {
        return accounts.stream().filter(a -> a.getAccountNumber().equals(accNo)).findFirst().orElse(null);
    }

    public List<Product> getProducts() {
        List<Product> sorted = new ArrayList<>(products);
        sorted.sort(Comparator.comparing(Product::getCategory).thenComparing(Product::getId));
        return sorted;
    }

    public String getAdminReport() {
        return String.format("Vault: ₱%.2f | Net Profit: ₱%.2f | Txns: %d", vaultCash, (vaultCash - baseCash), transactions.size());
    }

    public String getTransactionHistory() {
        if (transactions.isEmpty()) {
            return "No history.";
        }
        StringBuilder sb = new StringBuilder();
        for (Transaction t : transactions) {
            sb.append(t.getTransactionId()).append(" | ").append(t.getProductName()).append("\n");
        }
        return sb.toString();
    }

    public String getInventoryStatus() {
        StringBuilder sb = new StringBuilder();
        for (Product p : products) {
            if (p.getStockQuantity() < 5) {
                sb.append("LOW STOCK: ").append(p.getName()).append("\n");
            }
        }
        return sb.length() == 0 ? "All stock levels healthy." : sb.toString();
    }
}
