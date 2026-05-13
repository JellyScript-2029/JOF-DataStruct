package com.maven.service;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CashierClient {

    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000); PrintWriter out = new PrintWriter(socket.getOutputStream(), true); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); Scanner sc = new Scanner(System.in)) {

            System.out.println(CYAN + "╔════════════════════════════════════════════════╗");
            System.out.println("║            WELCOME TO JJ STORE SYSTEM          ║");
            System.out.println("╚════════════════════════════════════════════════╝" + RESET);

            boolean running = true;
            while (running) {
                System.out.println("\n╔════════════════════════════════════════════════╗");
                System.out.println("║               M A I N   M E N U                ║");
                System.out.println("║                 [1] Shop products              ║");
                System.out.println("║                 [2] Exit                       ║");
                System.out.println("╚════════════════════════════════════════════════╝");
                System.out.print("Choice: ");
                String choice = sc.next().trim();

                if (choice.equals("1")) {
                    customerMenu(out, in, sc);
                } else if (choice.equals("2")) {
                    running = false;
                } else if (choice.equals("1216")) {
                    adminMenu(out, in, sc);
                } else {
                    System.out.println(RED + "Invalid option!" + RESET);
                }
            }
        } catch (IOException e) {
            System.err.println(RED + "Connection error: " + e.getMessage() + RESET);
        }
    }

    private static void customerMenu(PrintWriter out, BufferedReader in, Scanner sc) throws IOException {
        out.println("GET_INVENTORY");
        System.out.println(YELLOW + "\n╔════════════════════════════════════════════════╗" + RESET);
        System.out.println(YELLOW + "                    PRODUCTS                     " + RESET);

        String line;
        String currentCat = "";
        while (!(line = in.readLine()).equals("END")) {
            String[] p = line.split("\\|");
            if (!p[0].equals(currentCat)) {
                currentCat = p[0];
                System.out.println(CYAN + "\n> " + currentCat + RESET);
            }
            System.out.printf("  [%s] %-20s | ₱%-7s | Stock: %s\n", p[1], p[2], p[3], p[4]);
        }
        System.out.println("\n" + YELLOW + "╚════════════════════════════════════════════════╝" + RESET);

        System.out.print("\nEnter Product ID to buy (or 'exit'): ");
        String pid = sc.next().trim();
        if (pid.equalsIgnoreCase("exit")) {
            return;
        }

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        System.out.println("\n╔════════════════════════════════════════════════╗" + RESET);
        System.out.println("      [1] Add     [2] Pay     [3] Cancel       ");
        System.out.println("╚════════════════════════════════════════════════╝" + RESET);
        System.out.print("Choice: ");
        if (!sc.next().equals("1")) {
            return;
        }

        System.out.println(YELLOW + "\n╔════════════════════════════════════════════════╗");
        System.out.println("       P A Y M E N T   M E T H O D  " + RESET);
        System.out.println("              [1] Cash");
        System.out.println("              [2] Card");
        System.out.println(YELLOW + "╚════════════════════════════════════════════════╝" + RESET);
        System.out.print("Select payment method: ");
        String method = sc.next();

        if (method.equals("1")) {
            System.out.print("Amount Paid: ₱");
            double cash = sc.nextDouble();
            out.println("PAY_CASH|" + pid + "|" + qty + "|" + cash);
        } else {
            System.out.print("Account Number: ");
            String acc = sc.next();
            System.out.print("PIN: ");
            String pin = sc.next();
            out.println("PAY_CARD|" + pid + "|" + qty + "|" + acc + "|" + pin);
        }

        String response = in.readLine();
        if (response.startsWith("SUCCESS")) {
            System.out.println(GREEN + response + RESET);
        } else {
            System.out.println(RED + response + RESET);
        }
    }

    private static void adminMenu(PrintWriter out, BufferedReader in, Scanner sc) throws IOException {
        System.out.println(CYAN + "\n--- ADMIN ACCESS ---" + RESET);
        System.out.println("[1] Vault  [2] History  [3] Exit");
        String choice = sc.next();
        if (choice.equals("1")) {
            out.println("ADMIN_VAULT");
            System.out.println(in.readLine());
        } else if (choice.equals("2")) {
            out.println("ADMIN_TRANSACTIONS");
            String row;
            while (!(row = in.readLine()).equals("END_REPORT")) {
                System.out.println(row);
            }
        }
    }
}
