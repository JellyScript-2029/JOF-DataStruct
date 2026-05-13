package com.maven.service;

import java.io.*;
import java.net.*;

import com.maven.model.InventoryService;

public class ClientHandler implements Runnable {

    private Socket socket;
    private InventoryService service;

    public ClientHandler(Socket socket, InventoryService service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("[" + Thread.currentThread().getName() + "] Client connected: " + socket.getInetAddress());

            String input;
            while ((input = in.readLine()) != null) {
                try {
                    String[] parts = input.split("\\|");
                    String command = parts[0];

                    switch (command) {
                        // CORE PAYMENT COMMANDS
                        case "GET_INVENTORY":
                            handleGetInventory(out);
                            break;
                        case "PAY_CASH":
                            if (parts.length >= 4) {
                                String result = service.processCashPayment(parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]));
                                out.println(result);
                            }
                            break;
                        case "PAY_CARD":
                            if (parts.length >= 5) {
                                String result = service.processCardPayment(parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
                                out.println(result);
                            }
                            break;

                        // ADMIN COMMANDS
                        case "ADMIN_VAULT":
                            out.println(service.getAdminReport());
                            break;
                        case "ADMIN_TRANSACTIONS":
                            sendTransactionHistory(out);
                            break;
                        case "ADMIN_INVENTORY":
                            sendInventoryStatus(out);
                            break;

                        default:
                            out.println("DENIED|Unknown command");
                    }
                } catch (Exception e) {
                    System.err.println("Error processing command: " + e.getMessage());
                    out.println("DENIED|System error: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("[" + Thread.currentThread().getName() + "] Client disconnected.");
        }
    }

    // Helper method: Send inventory to client
    private void handleGetInventory(PrintWriter out) {
        for (com.maven.model.Product p : service.getProducts()) {
            out.println(p.getCategory() + "|" + p.getId() + "|" + p.getName() + "|" + p.getPrice() + "|" + p.getStockQuantity());
        }
        out.println("END");
    }

    // Helper method: Send transaction history
    private void sendTransactionHistory(PrintWriter out) {
        String history = service.getTransactionHistory();
        for (String line : history.split("\n")) {
            out.println(line);
        }
        out.println("END_REPORT");
    }

    // Helper method: Send inventory status
    private void sendInventoryStatus(PrintWriter out) {
        String status = service.getInventoryStatus();
        for (String line : status.split("\n")) {
            out.println(line);
        }
        out.println("END_REPORT");
    }
}
