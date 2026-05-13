package MyProgrammingJourney;
import java.util.*;

import Item;

import java.io.*;


public class Final{
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Item> items = new ArrayList<>();
    public static void main(String[] args)throws InterruptedException {
         mainMenu();
    }

    public static void loading(String core) throws InterruptedException {
        System.out.println("\nLoading " + core);
        for (int i = 0; i < 18; i++) {
            Thread.sleep(90);
            System.out.print(". ");
        }
        System.out.println();
    }
 
    public static void mainMenu() throws InterruptedException {
        System.out.println("""
                \n====================================================================
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
 
        switch (choice) {
            case 1 -> {
                loading("Core-Mart Inventory & POS");
                grocery();
                mainMenu();
            }
            case 2 -> {
                loading("Core-Flix Rental & Booking");
               movies();
            mainMenu();
            }
            case 3 -> {
                loading("Core-Style Clothing Line");
                mainMenu();
            }
            case 0 -> System.out.println("""
                              THANK YOU FOR USING JF  CORE  SYSTEMS
                                          GOODBYE
                    ====================================================================
                    """);
            default -> {
                System.out.println("Invalid input. Please enter 0, 1, 2, or 3.");
                mainMenu();
            }
        }
    }

    public static void grocery(){
        String strProdName, strAnotherP, strCustomer;
        char cCustomer = 'y', cAnotherP = 'y';
        double dQty = 0, dBill, dPrice = 0; 
        double dTotal, dPay = 0, dChange = 0;

            do{
            dBill = 0;
            System.out.println("""
                    \n====================================================================
                                    Welcome to Core-Mart Inventory & POS
                    ====================================================================""");
            do {
                System.out.print("Product name: ");
                strProdName = input.nextLine(); // ← simple assignment, no try/catch

                System.out.print("Price: $");
                while (true) {
                    try {
                        dPrice = input.nextDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println("============== Invalid Input! Please Enter an Integer ==============");
                        System.out.print("Price: $");
                        input.nextLine();
                    }
                }

                System.out.print("Quantity: ");
                while (true) {
                    try {
                        dQty = input.nextDouble();
                        break;
                    } catch (Exception e) {
                        System.out.println("============== Invalid Input! Please Enter an Integer ==============");
                        System.out.print("Quantity: ");
                        input.nextLine();
                    }
                }
                input.nextLine();

                dTotal = dQty * dPrice;
                System.out.printf("Total: %.2f%n", dTotal);
                dBill += dTotal;

                System.out.print("Another product Y/N? ");
                strAnotherP = input.nextLine();
                cAnotherP = strAnotherP.charAt(0);

            }while (cAnotherP == 'Y' || cAnotherP == 'y');

            while (true) {
                System.out.printf("%nBill: %.2f%n", dBill);
                System.out.print("Payment: ");
                try {
                    dPay = input.nextDouble();
                    input.nextLine();
                    if (dPay >= dBill) {
                        dChange = dPay - dBill;
                        System.out.printf("Change: %.2f%n", dChange);
                        System.out.println("Thank you for shopping!");
                        break;
                    } else {
                        System.out.println("Money is not enough!");
                        System.out.println("======================== MONEY IS NOT ENOUGH =======================");
                    }
                } catch (Exception e) {
                    System.out.println("============== Invalid Input! Please Enter an Integer ==============");
                    input.nextLine();
                }
            }

            System.out.print("\nAnother customer Y/N? ");
            strCustomer = input.nextLine();
            cCustomer = strCustomer.charAt(0);

        } while (cCustomer == 'Y' || cCustomer == 'y');

        System.out.println("Grocery program is terminating...");
    }

    public static void movies(){
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
            int choice;
            while (true) {
                try {
                    choice = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("============== Invalid Input! Please Enter an Integer ==============");
                    System.out.print("Type: ");
                    input.nextLine();
                }
            }

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
            int choice2;
            while (true) {
                try {
                    choice2 = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("============== Invalid Input! Please Enter an Integer ==============");
                    System.out.print("Category: ");
                    input.nextLine();
                }
            }
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
            while (true) {
                try {
                    double minutes = input.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("============== Invalid Input! Please Enter an Integer ==============");
                    System.out.print("Input Duration (mins): ");
                    input.nextLine();
                }
            }
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
            int choice3;
            while (true) {
                try {
                    choice3 = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("============== Invalid Input! Please Enter an Integer ==============");
                    System.out.print("Transaction Type: ");
                    input.nextLine();
                }
            }

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

            System.out.println("Transaction Type: " + transactionType);

            System.out.print("Input Price: ");
            while (true) {
                try {
                    double price = input.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("============== Invalid Input! Please Enter an Integer ==============");
                    System.out.print("Transaction Type: ");
                    input.nextLine();
                }
            }
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
                """,
                rentalTotal, salesTotal, 
                horrorTotal, scifiTotal, dramaTotal, comedyTotal, cartoonsTotal,
                vcdTotal, dvdTotal, tapeTotal);
    }

    public static void brands(){
//         System.out.println("""
//                 ====================================================================
//                                                  M E N U
//                 ====================================================================
//                         [1] List All Products
//                         [2] Add Product
//                         [3] Search Product
//                         [4] Edit Product
//                         [5] Delete Product
//                         [6] Sort Products
//                         [0] Back to Main Menu
//                 ====================================================================""");
//         System.out.print("Enter choice: ");
//         int choice;
//         while (true) {
//             try {
//                 choice = input.nextInt();
//                 break;
//             } catch (Exception e) {
//                 System.out.println("============== Invalid Input! Please Enter an Integer ==============");
//                 System.out.print("Enter choice: ");
//                 input.nextLine();
//             }
//         }

//         switch (choice) {
//             case 1:
//                 viewAllItems();
//                 break;
//             case 2:
//                 addProduct();
//                 saveItems();
//                 break;
//             case 3:
//                 searchItem();
//                 break;
//             case 4:
//                 editItem();
//                  saveItems();
//                 break;
//             case 5:
//                 deleteItem();
//                  saveItems();
//                 break;
//             case 6:
//                 sortItems();
//                 saveItems();
//                 break;
//             case 0:
//                 System.out.println("Terminating...");
//                 break;
//             default:
//                 System.out.println("Invalid input, please enter an integer");
//                 return;
//         }
//     }

//     public static void addProduct() {
//         System.out.println("""
//                 \n====================================================
//                                     ADD  NEW  ITEM
//                 ====================================================
//                   Where would you like to add the item?
//                     [1] At the END   (last index)
//                     [2] At the START (index 0)
//                     [3] At a SPECIFIC position""");
//         System.out.print("Choice: ");
//         int choice = input.nextInt();
//         input.nextLine();

//         System.out.println("====================================================");
//         System.out.println("                 A D D   I T E M S                  ");
//         System.out.print("Brand name   : ");
//         String brand = input.nextLine();
//         System.out.print("Product name : ");
//         String prodName = input.nextLine();
//         System.out.print("Size         : ");
//         String size = input.nextLine();
//         System.out.print("Color        : ");
//         String color = input.nextLine();
//         System.out.print("Price        : $");
//         double price = input.nextInt();

//         Item newItem = new Item(brand, prodName, size, color, price);

//         switch (choice) {
//             case 1:
//                 items.add(newItem);
//             case 2:
//                 items.add(0, newItem);
//             case 3:
//                 System.out.println("Enter position [0 - %d] : " + items.size());
//                 int position = input.nextInt();
//                 input.nextLine();
//                 if (position < 0 || position > items.size()) {
//                     System.out.println("Invalid Position");
//                     System.out.println("Adding item at the end...");
//                     items.add(newItem);
//                     System.out.println("Item added");
//                 } else {
//                     items.add(position, newItem);
//                     System.out.println("Item added");
//                 }
//             default:
//                 items.add(newItem);
//                 System.out.println("Item added");
//         }

//     }

//     public static void viewAllItems() {
//         System.out.println("====================================================================");
//         System.out.println("                          LIST OF ALL ITEMS                         ");
//         System.out.println("====================================================================");

//         if (items.isEmpty()) {
//             System.out.println("No items recorded");
//             return;
//         } else {
//             System.out.printf("  %-4s %-12s %-22s %-8s %-10s %s%n",
//                     "Idx", "Brand", "Product", "Size", "Color", "Price");
//             System.out.println("------------------------------------------------------------------");
//             for (int i = 0; i < items.size(); i++) {
//                 System.out.printf("  [%d] %s%n", i, items.get(i));
//             }
//         }

//         System.out.println("------------------------------------------------------------------");
//         System.out.println("Total of items : %d" + items.size());
//     }

//     public static void searchItem() {
//         input.nextLine();
//         System.out.println("====================================================");
//         System.out.println("              S E A R C H   I T E M S                  ");
//         System.out.print("Enter brand or product name to search: ");
//         String item = input.nextLine().trim().toLowerCase();

//         boolean found = false;

//         for (Item i : items) {
//             if (i.brand.toLowerCase().contains(item) || i.prodName.toLowerCase().contains(item)) {
//                 System.out.println(i);
//                 found = true;
//             }
//         }
//         if (!found) {
//             System.out.println("No items found");
//         }
//     }

//     public static void editItem() {
//         if (items.isEmpty()) {
//             System.out.println("No items recorded");
//             return;
//         }

//         System.out.print("Enter index to edit [0 -%d]: " + items.size());
//         int index = input.nextInt();
//         input.nextLine();

//         if (index < 0 || index > items.size()) {
//             System.out.println("Invalid index");
//             return;
//         }

//         Item i = items.get(index);
//         System.out.println("--------------------------------------------------------------------");
//         System.out.println("Details: ");
//         System.out.println(i.toDetailString());
//         System.out.println("--------------------------------------------------------------------");

//         System.out.print("Continue editing the item [Y/N]: ");
//         String response = input.nextLine();

//         if (!response.equalsIgnoreCase("Y")) {
//             System.out.println("Edit cancelled");
//         }

//         System.out.println("Enter new values [Press Enter to Keep the value] ");
//         System.out.printf("  Brand   [%s]: ", i.getBrand());
//         String brand = input.nextLine();
//         if (!brand.isBlank())
//             i.setBrand(brand);

//         System.out.printf("  Product [%s]: ", i.getProdName());
//         String product = input.nextLine();
//         if (!product.isBlank())
//             i.setProdName(product);

//         System.out.printf("  Size    [%s]: ", i.getSize());
//         String size = input.nextLine();
//         if (!size.isBlank())
//             i.setSize(size);

//         System.out.printf("  Color   [%s]: ", i.getColor());
//         String color = input.nextLine();
//         if (!color.isBlank())
//             i.setColor(color);

//         System.out.printf("  Price   [$%.2f]: ", i.getPrice());
//         String price = input.nextLine();
//         if (!price.isBlank()) {
//             try {
//                 i.setPrice(Double.parseDouble(price));
//             } catch (NumberFormatException e) {
//                 System.out.println("Invalid price — keeping original value.");
//             }
//         }

//         System.out.println("Item Updated");
//         System.out.println("--------------------------------------------------------------------");
//         System.out.println(i.toDetailString());
//         System.out.println("--------------------------------------------------------------------");
//     }

//     public static void deleteItem() {
//         if (items.isEmpty()) {
//             System.out.println("No items recorded");
//         }

//         for (int i = 0; i < items.size(); i++) {
//             System.out.printf("[%d] %s | %s | %s | %s | %.2f", i, items.get(i).getBrand(), items.get(i).getProdName(),
//                     items.get(i).getColor(), items.get(i).getSize(), items.get(i).getPrice());
//         }

//         System.out.println("====================================================");
//         System.out.println("                  D E L E T E   I T E M S            ");

//         System.out.print("Enter index to delete: ");
//         int indix;
//         while (true) {
//             try {
//                 indix = input.nextInt();
//                 break;
//             } catch (Exception e) {
//                 System.out.println("Invalid Input");
//                 System.out.print("Enter index to delete: ");
//                 input.nextLine();
//             }
//         }
//         input.nextLine();

//         if (indix < 0 || indix >= items.size()) {
//             System.out.println("index out of bounds");
//             return;
//         }

//         System.out.print("Are you sure you want to delete this item [Y/N]: ");
//         String response = input.nextLine();

//         if (!response.equalsIgnoreCase("Y")) {
//             System.out.println("Delete cancelled");
//         } else {
//             items.remove(indix);
//             System.out.println("Items removed");
//         }
//     }

//     public static void sortItems() {
//         if (items.isEmpty()) {
//             System.out.println("No items to sort");
//             return;
//         }

//         System.out.println("====================================================");
//         System.out.println("                  S O R T   I T E M S               ");
//         System.out.println("""
//                 ====================================================
//                           [1] Ascending (A-Z / Low to High)
//                           [2] Descending (Z-A / High to Low)""");
//         System.out.print("Choice: ");
//         int choice;

//         while (true) {
//             try {
//                 choice = input.nextInt();
//                 break;
//             } catch (Exception e) {
//                 System.out.println("Invalid Input! Please entge an integer");
//                 System.out.print("Choice: ");
//                 input.nextLine();
//             }
//         }
//         input.nextLine();
//         for (int i = 0; i < items.size() - 1; i++) {
//             for (int j = 0; j < items.size() - i - 1; j++) {

//                 Item current = items.get(j);
//                 Item next = items.get(j + 1);

                
//                 boolean shouldSwap = false;
//                 if (choice == 1) {
//                     if (current.getBrand().compareToIgnoreCase(next.getBrand()) > 0)
//                         shouldSwap = true;
//                 } else {
//                     if (current.getBrand().compareToIgnoreCase(next.getBrand()) < 0)
//                         shouldSwap = true;
//                 }

//                 if (shouldSwap){
//                     items.set(j, next);
//                     items.set(j + 1, current);
//                 }
//             }
//         }
//         System.out.println("Items sorted by Brand!");
//     }

//     public static void saveItems() {
//         try{
//             BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\figue\\JOF-DataStruct\\finalAct\\items.txt"));
//             for(int i = 0; i < items.size(); i++){
//                 Item item = items.get(i);

//                 writer.write(item.getBrand());
//                 writer.newLine();
//                 writer.write(item.getProdName());
//                 writer.newLine();
//                 writer.write(item.getSize());
//                 writer.newLine();
//                 writer.write(item.getColor());
//                 writer.newLine();
//                 String priceStr = String.format("%.2f", item.getPrice());
//                 writer.write(priceStr);
//                 writer.newLine();
//             }
//             writer.close(); 
//             System.out.println("Progress saved to items.txt");
//         }catch(IOException e){
//             System.out.println("✘ Error: Could not write to file.");
//         }

//     }

//     public static void loadItems() {
//         try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\figue\\JOF-DataStruct\\finalAct\\items.txt"))){
//             String line;
//             while((line = reader.readLine()) != null){
//                 String brand = line.trim();
//                 String prodName = reader.readLine().trim();
//                 String size = reader.readLine().trim();
//                 String color = reader.readLine().trim();
//                 double price = Double.parseDouble(reader.readLine().trim());
//                 items.add(new Item(brand, prodName, size, color, price));
//             }
//             System.out.println("items loaded");
//         }catch(IOException e){
//             System.out.println("File could not read");
            
//         }

    }

}
