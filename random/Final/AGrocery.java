import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AGrocery {
    public static Scanner input = new Scanner(System.in);
    private String strProdName;
    private String strAnotherP;
    private String strCustomer;
    private int iQty = 0;
    private double dBill;
    private double dPrice = 0;
    private double dTotal;
    private double dPay = 0;
    private double dChange = 0;
    private char cCustomer = 'y';
    private char cAnotherP = 'y';

    public void grocery() {
        do {
            dBill = 0;
            StringBuilder receipt = new StringBuilder();
            receipt.append("-----------------------------------------");
            receipt.append("\n        Core-Mart Inventory & POS        \n");
            receipt.append("-----------------------------------------\n");
            receipt.append(String.format("%-5s %-25s %8s\n", "QTY", "ITEM", "AMT"));
            receipt.append("-----------------------------------------\n");

            System.out.println("""
                    \n====================================================================
                                    Welcome to Core-Mart Inventory & POS
                    ====================================================================""");
            do {
                System.out.print("Product name: ");
                strProdName = input.nextLine();

                System.out.print("Price: $");
                while (true) {
                    try {
                        dPrice = input.nextDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid Input! Please Enter an Integer");
                        System.out.print("Price: $");
                        input.nextLine();
                    }
                }

                System.out.print("Quantity: ");

                while (true) {
                    try {
                        iQty = input.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid Input! Please Enter an Integer");
                        System.out.print("Quantity: ");
                        input.nextLine();
                    }
                }
                input.nextLine();

                dTotal = iQty * dPrice;
                System.out.printf("Total: %.2f%n", dTotal);
                dBill += dTotal;
                receipt.append(String.format(" %-5d %-25s %8.2f\n", iQty, strProdName, dPrice));

                System.out.print("Another product Y/N? ");
                strAnotherP = input.nextLine();
                if (strAnotherP.isEmpty()) {
                    cAnotherP = 'n';
                } else {
                    cAnotherP = strAnotherP.toLowerCase().charAt(0);
                }

            } while (cAnotherP == 'y');

            while (true) {
                System.out.printf("\nBill: %.2f\n", dBill);
                System.out.print("Payment: ");
                try {
                    dPay = input.nextDouble();
                    input.nextLine();
                    if (dPay >= dBill) {
                        dChange = dPay - dBill;
                        System.out.printf("Change: %.2f%n", dChange);

                        receipt.append("-----------------------------------------\n");

                        receipt.append(String.format("%-30s %10.2f\n", "TOTAL:", dBill));
                        receipt.append("-----------------------------------------\n");
                        receipt.append(String.format("%-3s %10.2f\n", "CASH:", dPay));
                        receipt.append(String.format("%-30s %10.2f\n", "CHANGE:", dChange));
                        receipt.append("=========================================\n");
                        receipt.append("\n         THANK YOU FOR PURCHASING        \n");
                        receipt.append("=========================================\n"); 

                        saveToOutput(receipt.toString());
                        break;
                    } else {
                        System.out.println("Money is not enough!");
                    }
                } catch (Exception e) {
                    input.nextLine();
                }
            }

            System.out.print("\nAnother customer Y/N? ");
            strCustomer = input.nextLine();
            if (strCustomer.isEmpty()) {
                cCustomer = 'n'; // Default to 'n' if they just hit Enter
            } else {
                cCustomer = strCustomer.toLowerCase().charAt(0);
            }

        } while (cCustomer == 'y');

        System.out.println("Grocery program is terminating...");
    }

    private void saveToOutput(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
            writer.write(data);
            System.out.println("[Receipt saved to output.txt]");
        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }
}