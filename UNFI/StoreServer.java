package com.maven.service;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.maven.model.InventoryService;

public class StoreServer {

    private static final int PORT = 5000;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    private static InventoryService inventoryService;
    private static int clientCount = 0;

    public static void main(String[] args) {
        // Initialize inventory service
        inventoryService = new InventoryService();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("╔════════════════════════════════════════╗");
            System.out.println("║       JJ STORE SERVER ACTIVATED        ║");
            System.out.println("║       Port: " + PORT + "               ║");
            System.out.println("║       Status: LISTENING                ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("\n[" + LocalDateTime.now().format(formatter) + "] Server started successfully.\n");

            // Accept incoming client connections
            while (true) {
                Socket socket = serverSocket.accept();
                clientCount++;

                // Print connection info
                String clientInfo = String.format("[%s] Client #%d connected | IP: %s | Port: %d",
                        LocalDateTime.now().format(formatter),
                        clientCount,
                        socket.getInetAddress().getHostAddress(),
                        socket.getPort()
                );
                System.out.println(clientInfo);

                // Create new thread for client
                Thread clientThread = new Thread(new ClientHandler(socket, inventoryService));
                clientThread.setName("Client-" + clientCount);
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("✗ Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
