package dsa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreManager {
    public static Scanner input = new Scanner(System.in);
    public static int registration = 0;
    public static ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        mainMenu();
    }

    public static void loading(String core) throws InterruptedException {
        System.out.println("Loading " + core);
        for (int i = 0; i < 18; i++) {
            Thread.sleep(90);
            System.out.print(". ");
        }

    }

    public static void mainMenu() throws InterruptedException {
        System.out.println("""
                ====================================================================
                                        W E L C O M E  TO
                                        JF  CORE  SYSTEMS
                -------------- "The heart of your digital operations" --------------

                                [1] Core-Mart Inventory & POS
                                [2] Core-Flix Rental & Booking
                                [3] Core-Style Clothing Line
                                [0] Exit
                ====================================================================""");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();
        System.out.println("====================================================================");
        String core = "";

        switch (choice) {
            case 1:
                core = "Core-Mart Inventory & POS";
                loading(core);
                mart();
                break;
            case 2:
                core = "Core-Flix Rental & Booking";
                loading(core);
                movies();
                break;
            case 3:
                core = "Core-Style Clothing Line";
                loading(core);
                ClothingBrands();
                break;
            case 0:
                System.out.println("""
                                        THANK YOU FOR USING JF  CORE  SYSTEMS
                                                    GOODBYE
                        ====================================================================
                            """);
                break;
            default:
                System.out.println("Invalid input");
                mainMenu();
                return;
        }

    }

    public static void mart() throws InterruptedException {
        String strProdName, strAnotherP;
        String strCustomer;
        char cCustomer = 'y', cAnotherP = 'y';
        double dQty, dBill, dPrice;
        double dTotal, dPay, dChange = 0;
        do {
            dBill = 0;
            System.out.println("""
                    \n====================================================================
                                    Welcome to Core-Mart Inventory & POS
                    ====================================================================""");
            input.nextLine();
            do {

                System.out.print("Product name: ");
                strProdName = input.nextLine();
                System.out.print("Price: ");
                dPrice = input.nextDouble();
                System.out.print("Quantity: ");
                dQty = input.nextDouble();
                input.nextLine();

                dTotal = dQty * dPrice;
                System.out.println("Total: " + dTotal);

                dBill = dBill + dTotal;

                System.out.print("Another product Y/N? ");
                strAnotherP = input.nextLine();
                cAnotherP = strAnotherP.charAt(0);
            } while ((cAnotherP == 'Y') || (cAnotherP == 'y'));

            while (true) {
                System.out.println("\nBill: " + dBill);
                System.out.print("Payment: ");
                dPay = input.nextDouble();
                input.nextLine();

                if (dPay >= dBill) {
                    dChange = dPay - dBill;
                    System.out.println("Change: " + dChange);
                    System.out.println("Thank you for shopping");
                    break;
                } else {
                    System.out.println("Money is not enough!");
                }
            }

            System.out.print("\nAnother costumer Y/N? ");
            strCustomer = input.nextLine();
            cCustomer = strCustomer.charAt(0);
        } while (cCustomer == 'Y' || cCustomer == 'y');

        System.out.println("Grocery program is terminating...");

        mainMenu();
    }

    public static void movies() throws InterruptedException {
        String response;
        int dvdTotal = 0;
        int vcdTotal = 0;
        int tapeTotal = 0;
        int horrorTotal = 0;
        int scifiTotal = 0;
        int dramaTotal = 0;
        int comedyTotal = 0;
        int cartoonsTotal = 0;
        int rentalTotal = 0;
        int salesTotal = 0;

        do {

            System.out.println("""
                    \n=====================================================================
                                     Welcome to Core-Flix Rental & Booking

                    =================== R E G I S T R A T I O N  H U B ==================
                    =====================================================================
                                                 T Y P E
                        Please Choose:
                                [1] DVD
                                [2] VCD
                                [3] TAPE""");
            System.out.print("Type: ");
            int choice = input.nextInt();
            input.nextLine();

            System.out.print("Input Title: ");
            String title = input.nextLine();

            String type = "";
            switch (choice) {
                case 1:
                    type = "DVD";
                    dvdTotal++;
                    break;
                case 2:
                    type = "VCD";
                    vcdTotal++;
                    break;
                case 3:
                    type = "Tape";
                    tapeTotal++;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            System.out.println("Selected Type: " + type);

            System.out.println("""
                    =====================================================================
                                             C A T E G O R Y
                        Please Choose:
                                [1] Horror
                                [2] Scifi
                                [3] Drama
                                [4] Comedy
                                [5] Cartoons """);
            System.out.print("Category: ");
            int choice2 = input.nextInt();

            String category = "";
            switch (choice2) {
                case 1:
                    category = "Horror";
                    horrorTotal++;
                    break;
                case 2:
                    category = "Scifi";
                    scifiTotal++;
                    break;
                case 3:
                    category = "Drama";
                    dramaTotal++;
                    break;
                case 4:
                    category = "Comedy";
                    comedyTotal++;
                    break;
                case 5:
                    category = "Cartoons";
                    cartoonsTotal++;
                    break;
                default:
                    System.out.println("Choose only from 1-5");

                    break;
            }

            System.out.println("Selected Category: " + category);
            System.out.print("Input Duration (mins): ");
            double minutes = input.nextDouble();
            input.nextLine();

            System.out.print("Input Setting: ");
            String setting = input.nextLine();

            System.out.println("""
                    =====================================================================
                                        T R A N S A C T I O N  T Y P E
                        Please Choose:
                                [1] Rental
                                [2] Sales""");
            System.out.print("Transaction Type: ");
            int choice3 = input.nextInt();

            String transactionType = "";
            switch (choice3) {
                case 1:
                    transactionType = "Rental";
                    rentalTotal++;
                    break;
                case 2:
                    transactionType = "Sales";
                    salesTotal++;
                    break;
                default:
                    System.out.println("Choose only from 1 and 2");
                    break;
            }

            System.out.println("Transaction Type : " + transactionType);
            System.out.print("Input Price: ");
            double price = input.nextDouble();
            input.nextLine();
            System.out.println("==================================================================");
            System.out.print("Display another Y/N? ");
            response = input.nextLine();
        } while (response.equalsIgnoreCase("Y"));

        System.out.println("""
                =====================================================================
                                    S Y S T E M   R E P O R T S
                =====================================================================
                       """);
        System.out.printf("""
                    [TRANSACTION SUMMARY]                   [GENRE BREAKDOWN]
                      For rent:      %d                      Horror:      %d
                      For sale:      %d                      Scifi:       %d
                                                            Drama:       %d
                                                            Comedy:      %d
                                                            Cartoons:    %d
                    [FORMAT TOTALS]
                     VCD:        %d
                     DVD:        %d
                     Tape:       %d

                =====================================================================
                                Core-Flix Rental & Booking Terminated
                =====================================================================

                        """, rentalTotal, horrorTotal, salesTotal, scifiTotal, dramaTotal,
                comedyTotal, cartoonsTotal, vcdTotal, dvdTotal, tapeTotal);

        mainMenu();
    }

    public static void ClothingBrands() throws InterruptedException {

        System.out.println("""
                \n====================================================================
                             Welcome to Core-Style Clothing Line""");

                             menu();

    }

    public static void menu()throws InterruptedException{
        System.out.println("""
                ====================================================
                               M A I N   M E N U
                    [1] Add item
                    [2] Search item
                    [3] Edit item
                    [4] Delete item
                    [5] Sort items
                    [6] List all items
                    [0] Exit""");
        System.out.print("Choice: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                addItem();
                break;
            case 2:
                searchItem();
                break;
            case 3:
                editItem();
                break;
            case 4:
                // delete
                break;
            case 5:
                // sort
                break;
            case 6:
                listItems();
                break;
            case 0:
                mainMenu();
            default:
                System.out.println("INVALID INPUT");
                menu();
                break;
        }

    }

    public static void listItems() {
        System.out.println("====================================================");
        System.out.println("                  A L L   I T E M S                ");
        System.out.println("====================================================");

        for (Item i : items) {
            System.out.println(i);
        }

        if (items.isEmpty()) {
            System.out.println("No items found");
        }
    }

    public static void addItem() {
        System.out.println("====================================================");
        System.out.println("                 A D D   I T E M S                  ");
        input.nextLine();
        System.out.print("Enter Brand: ");
        String brand = input.nextLine();
        System.out.print("Enter Product: ");
        String prodName = input.nextLine();
        System.out.print("Enter Color: ");
        String color = input.nextLine();
        System.out.print("Enter Size");
        String size = input.nextLine();
        System.out.print("Enter Price: $");
        double price = input.nextDouble();

        items.add(new Item(brand, prodName, size, color, price));

        System.out.println("Item successfully added");
    }

    public static void searchItem() {
        input.nextLine();
        System.out.println("====================================================");
        System.out.println("              S E A R C H   I T E M S                  ");
        System.out.print("Enter brand or product name to search: ");
        String item = input.nextLine().trim().toLowerCase();

        boolean found = false;

        for (Item i : items) {
            if (i.brand.toLowerCase().contains(item) || i.prodName.toLowerCase().contains(item)) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No items found");
        }
    }

    public static void editItem() {
        if (items.isEmpty()) {
            System.out.println("No items to edit");
        }

        listItems();

        System.out.print("Choose item to edit: ");
    }

    

    
}
