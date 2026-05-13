import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AClothingBrands {
    public static ArrayList<Item> items = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);

    public void brandsMenu() {
        loadItems();
        System.out.println("""
                \n===============================================================================
                                                    M E N U
                ===============================================================================
                                        [1] List All Products
                                        [2] Add Product
                                        [3] Search Product
                                        [4] Edit Product
                                        [5] Delete Product
                                        [6] Sort Products
                                        [0] Back to Main Menu
                ===============================================================================""");
        System.out.print("Enter choice: ");
        int choice;
        while (true) {
            try {
                choice = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input! Please Enter an Integer");
                System.out.print("Enter choice: ");
                input.nextLine();
            }
        }

        switch (choice) {
            case 1 -> {
                viewAllItems();
                brandsMenu();
            }
            case 2 -> {
                addProduct();
                saveItems();
                brandsMenu();
            }
            case 3 -> {
                searchItem();
                brandsMenu();
            }
            case 4 -> {
                editItem();
                saveItems();
                brandsMenu();
            }
            case 5 -> {
                deleteItem();
                saveItems();
                brandsMenu();
            }
            case 6 -> {
                sortItems();
                saveItems();
                brandsMenu();
            }
            case 0 -> System.out.println("Returning to Main Menu...");
            default -> {
                System.out.println("Invalid selection.");
                brandsMenu();
            }
        }
    }

    public static void loadItems() {
        items.clear();
        try (BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\figue\\JOF-DataStruct\\items.txt"))) {
            String brand;
            while ((brand = reader.readLine()) != null) {
                if (brand.isBlank())
                    continue;
                String prodName = reader.readLine();
                String size = reader.readLine();
                String color = reader.readLine();
                String priceStr = reader.readLine();

                if (prodName != null && size != null && color != null && priceStr != null) {
                    double price = Double.parseDouble(priceStr.trim());
                    items.add(new Item(brand.trim(), prodName.trim(), size.trim(), color.trim(), price));
                }
            }
        } catch (Exception e) {
            System.out.println("No existing data found in items.txt.");
        }
    }

    public static void saveItems() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("C:\\Users\\figue\\JOF-DataStruct\\items.txt"))) {
            for (Item item : items) {
                writer.write(item.getBrand() + "\n" + item.getProdName() + "\n" + item.getSize() + "\n"
                        + item.getColor() + "\n" + String.format("%.2f", item.getPrice()) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving items.");
        }
    }

    public static void viewAllItems() {
        StringBuilder receipt = new StringBuilder();

        System.out.println("================================================================================");
        System.out.println("                          LIST OF ALL ITEMS                         ");
        System.out.println("================================================================================");
        receipt.append("\n================================================================================\n");
        receipt.append("                                LIST OF ALL ITEMS                                ");
        receipt.append("\n================================================================================\n");
        receipt.append(String.format("%-15s %-25s %-10s %-15s %10s\n", "BRAND", "PRODUCT", "SIZE", "COLOR", "PRICE"));
        receipt.append("--------------------------------------------------------------------------------\n");
        if (items.isEmpty()) {
            System.out.println("No Items registered");
            return;
        }

        for (Item i : items) {
            System.out.printf("\n%-15s %-25s %-10s %-15s %10.2f",
                    i.getBrand(),
                    i.getProdName(),
                    i.getSize(),
                    i.getColor(),
                    i.getPrice());
            receipt.append(String.format("\n%-15s %-25s %-10s %-15s %10.2f",
                    i.getBrand(),
                    i.getProdName(),
                    i.getSize(),
                    i.getColor(),
                    i.getPrice()));
        }
        writeToOutput(receipt.toString());

    }

    public static void addProduct() {
        StringBuilder receipt = new StringBuilder();
        Scanner input = new Scanner(System.in);
        System.out.println("""
                \n===============================================================================
                                                 ADD  NEW  ITEM
                ===============================================================================
                                        Where would you like to add the item?
                                            [1] At the END   (last index)
                                            [2] At the START (index 0)
                                            [3] At a SPECIFIC position""");
        System.out.print("Choice: ");
        int choice = input.nextInt();
        input.nextLine();

        System.out.println("===============================================================================");
        System.out.println("                               A D D   I T E M S                               ");
        System.out.print("Brand name   : ");
        String brand = input.nextLine();
        System.out.print("Product name : ");
        String prodName = input.nextLine();
        System.out.print("Size         : ");
        String size = input.nextLine();
        System.out.print("Color        : ");
        String color = input.nextLine();
        double price = 0;
        while (true) {
            try {
                System.out.print("Price        : $");
                price = input.nextDouble();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid price format.");
                input.nextLine();
            }
        }

        Item newItem = new Item(brand, prodName, size, color, price);

        switch (choice) {
            case 1 -> {
                items.add(newItem);
                System.out.println("Item added at the end.");
                receipt.append("\n=========================== ACTION: ADD ITEM AT END ============================\n");
                receipt.append("New Item: ").append(newItem.toString()).append("\n");
                receipt.append("=================================== UPDATED LIST =================================\n");
                receipt.append(
                        String.format("%-15s %-25s %-10s %-15s %10s\n", "BRAND", "PRODUCT", "SIZE", "COLOR", "PRICE"));
                receipt.append("--------------------------------------------------------------------------------\n");

                for (Item i : items) {
                    receipt.append(String.format("%-15s %-25s %-10s %-15s %10.2f\n",
                            i.getBrand(),
                            i.getProdName(),
                            i.getSize(),
                            i.getColor(),
                            i.getPrice()));
                }
                receipt.append("--------------------------------------------------------------------------------\n");
                receipt.append("TOTAL ITEMS: ").append(items.size());
                writeToOutput(receipt.toString());
            }
            case 2 -> {

                items.add(0, newItem);
                System.out.println("Item added at the start.");
                receipt.append("\n=========================== ACTION: ADD ITEM AT START ==========================\n");
                receipt.append("New Item: ").append(newItem.toString()).append("\n");
                receipt.append("================================== UPDATED LIST ==================================\n");
                receipt.append(
                        String.format("%-15s %-25s %-10s %-15s %10s\n", "BRAND", "PRODUCT", "SIZE", "COLOR", "PRICE"));
                receipt.append("--------------------------------------------------------------------------------\n");
                for (Item i : items) {
                    receipt.append(String.format("%-15s %-25s %-10s %-15s %10.2f\n",
                            i.getBrand(),
                            i.getProdName(),
                            i.getSize(),
                            i.getColor(),
                            i.getPrice()));
                }
                receipt.append("--------------------------------------------------------------------------------\n");
                receipt.append("TOTAL ITEMS: ").append(items.size());
                writeToOutput(receipt.toString());
            }
            case 3 -> {
                System.out.printf("Enter position [0 - %d]: ", items.size());
                int position = input.nextInt();
                input.nextLine();

                String actionMsg;
                if (position < 0 || position > items.size()) {
                    actionMsg = "INVALID POSITION (" + position + ") Added to end instead.";
                    System.out.println(actionMsg);
                    items.add(newItem);
                } else {
                    items.add(position, newItem);
                    actionMsg = "Item added at position " + position;
                    System.out.println(actionMsg);
                }
                receipt.append("\n==================== ACTION: ADD ITEM AT A SPECIFIC POSITION ===================\n");
                receipt.append("New Item: ").append(newItem.toString()).append("\n");
                receipt.append("================================== UPDATED LIST ==================================\n");
                receipt.append(
                        String.format("%-15s %-25s %-10s %-15s %10s\n", "BRAND", "PRODUCT", "SIZE", "COLOR", "PRICE"));
                receipt.append("--------------------------------------------------------------------------------\n");
                for (Item i : items) {
                    receipt.append(String.format("%-15s %-25s %-10s %-15s %10.2f\n",
                            i.getBrand(),
                            i.getProdName(),
                            i.getSize(),
                            i.getColor(),
                            i.getPrice()));
                }
                receipt.append("--------------------------------------------------------------------------------\n");
                receipt.append("TOTAL ITEMS: ").append(items.size());
                writeToOutput(receipt.toString());
            }
            default -> {
                items.add(newItem);
                System.out.println("Invalid choice. Added to end by default.");
            }
        }
    }

    public static void searchItem() {
        StringBuilder receipt = new StringBuilder();
        Scanner input = new Scanner(System.in);
        System.out.println("====================================================================");
        System.out.println("                       S E A R C H   I T E M S                        ");
        System.out.print("Enter brand or product name to search: ");
        String item = input.nextLine().trim().toLowerCase();

        boolean found = false;
        receipt.append("\n============================= R E S U L T ===================================\n");
        receipt.append(String.format("%-15s %-25s %-10s %-15s %10s\n", "BRAND", "PRODUCT", "SIZE", "COLOR", "PRICE"));
        receipt.append("--------------------------------------------------------------------------------\n");

        for (Item i : items) {
            if (i.getBrand().toLowerCase().contains(item) || i.getProdName().toLowerCase().contains(item)) {
                System.out.println(i);
                receipt.append(i.toString()).append("\n");
                found = true;
            }
        }

        writeToOutput(receipt.toString());
        if (!found) {
            System.out.println("No items found");
        }
    }

    public static void editItem() {
        StringBuilder receipt = new StringBuilder();
        Scanner input = new Scanner(System.in);
        if (items.isEmpty()) {
            System.out.println("No items recorded");
            return;
        }

        System.out.printf("Enter index to edit [0 - %d]: ", items.size() - 1);
        int index = input.nextInt();
        input.nextLine();

        if (index < 0 || index >= items.size()) {
            System.out.println("Invalid index");
            return;
        }

        Item i = items.get(index);
        String originalDet = i.toDetailString();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Current Detail: ");
        System.out.println(originalDet);
        System.out.println("-------------------------------------------------------------------------------");

        System.out.print("Continue editing the item [Y/N]: ");
        String response = input.nextLine();

        if (!response.equalsIgnoreCase("Y")) {
            System.out.println("Edit cancelled");
        }

        System.out.println("Enter new values [Press Enter to Keep the value] ");
        System.out.printf("  Brand   [%s]: ", i.getBrand());
        String brand = input.nextLine();
        if (!brand.isBlank())
            i.setBrand(brand);

        System.out.printf("  Product [%s]: ", i.getProdName());
        String product = input.nextLine();
        if (!product.isBlank())
            i.setProdName(product);

        System.out.printf("  Size    [%s]: ", i.getSize());
        String size = input.nextLine();
        if (!size.isBlank())
            i.setSize(size);

        System.out.printf("  Color   [%s]: ", i.getColor());
        String color = input.nextLine();
        if (!color.isBlank())
            i.setColor(color);

        System.out.printf("  Price   [$%.2f]: ", i.getPrice());
        String price = input.nextLine();
        if (!price.isBlank()) {
            try {
                i.setPrice(Double.parseDouble(price));
            } catch (NumberFormatException e) {
                System.out.println("Invalid price — keeping original value.");
            }
        }

        System.out.println("Item Updated");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(i.toDetailString());
        System.out.println("-------------------------------------------------------------------------------");

        receipt.append("================== ACTION: EDIT PRODUCT (Index ").append(index)
                .append(") ================== \n");
        receipt.append("========================== BEFORE EDIT =============================\n")
                .append(i.toDetailString()).append("\n");
        receipt.append("=========================== AFTER EDIT =============================\n")
                .append(i.toDetailString()).append("\n");
        receipt.append("--------------------------------------------------------------------------------\n");
        receipt.append("TOTAL ITEMS: ").append(items.size());

        System.out.println("Item Updated Successfully!");
        writeToOutput(receipt.toString());
    }

    public static void deleteItem() {
        StringBuilder receipt = new StringBuilder();
        Scanner input = new Scanner(System.in);
        System.out.println("===============================================================================");
        System.out.println("                           D E L E T E   I T E M S                       ");
        if (items.isEmpty()) {
            System.out.println("No items recorded");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.printf("[%d] %-15s %-25s %-10s %-15s %10.2f\n",
                    i,
                    item.getBrand(),
                    item.getProdName(),
                    item.getSize(),
                    item.getColor(),
                    item.getPrice());
        }
        System.out.println("===============================================================================");

        System.out.print("Enter index to delete: ");
        int indix;
        while (true) {
            try {
                indix = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input");
                System.out.print("Enter index to delete: ");
                input.nextLine();
            }
        }
        System.out.println("===============================================================================");

        if (indix < 0 || indix >= items.size()) {
            System.out.println("index out of bounds");
            return;
        }

        Item removedItem = items.get(indix);
        String removedDetails = removedItem.toString();

        System.out.print("Are you sure you want to delete this item [Y/N]: ");
        String response = input.nextLine();

        if (!response.equalsIgnoreCase("Y")) {
            System.out.println("Delete cancelled");
        } else {
            items.remove(indix);
            System.out.println("Items removed");

            receipt.append("========================= ACTION: DELETE PRODUCT (SUCCESS) =====================\n");
            receipt.append("REMOVED ITEM:  ").append(removedDetails).append("\n");
            receipt.append("--------------------------------------------------------------------------------\n");
            receipt.append("TOTAL ITEMS: ").append(items.size());
        }
        writeToOutput(receipt.toString());
    }

    public static void sortItems() {
        StringBuilder receipt = new StringBuilder();
        if (items.isEmpty()) {
            System.out.println("No items to sort");
            return;
        }

        System.out.println("===============================================================================");
        System.out.println("                                S O R T   I T E M S                            ");
        System.out.println("""
                ===============================================================================
                                    [1] Ascending (A-Z)
                                    [2] Descending (Z-A)""");
        System.out.print("Choice: ");
        int choice;

        while (true) {
            try {
                choice = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input! Please entge an integer");
                System.out.print("Choice: ");
                input.nextLine();
            }
        }
        input.nextLine();
        for (int i = 0; i < items.size() - 1; i++) {
            for (int j = 0; j < items.size() - i - 1; j++) {

                Item current = items.get(j);
                Item next = items.get(j + 1);

                boolean swap = false;
                if (choice == 1) {
                    if (current.getBrand().compareToIgnoreCase(next.getBrand()) > 0)
                        swap = true;
                } else {
                    if (current.getBrand().compareToIgnoreCase(next.getBrand()) < 0)
                        swap = true;
                }

                if (swap) {
                    items.set(j, next);
                    items.set(j + 1, current);
                }
            }
        }
        if (choice == 1) {
            receipt.append("============================= IN ASCENDING ORDER ===============================\n");
        } else {
            receipt.append("============================= IN DESCENDING ORDER ==============================\n");
        }
        receipt.append(String.format("%-15s %-25s %-10s %-15s %10s\n", "BRAND", "PRODUCT", "SIZE", "COLOR", "PRICE"));
        receipt.append("--------------------------------------------------------------------------------\n");

        for (Item i : items) {
            receipt.append(String.format("%-15s %-25s %-10s %-15s %10.2f\n",
                    i.getBrand(),
                    i.getProdName(),
                    i.getSize(),
                    i.getColor(),
                    i.getPrice()));
        }

        System.out.println(receipt.toString());
        receipt.append("--------------------------------------------------------------------------------\n");
        receipt.append("TOTAL ITEMS: ").append(items.size());
        writeToOutput(receipt.toString());

        System.out.println("Items sorted by Brand!");

    }

    private static void writeToOutput(String data) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("C:\\Users\\figue\\JOF-DataStruct\\Output.txt", true))) {
            writer.write(data);
            writer.write("\n--------------------------------------------------------------------------------\n");
        } catch (IOException e) {
            System.out.println("Error writing to output.txt");
        }
    }

}
