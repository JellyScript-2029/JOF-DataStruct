import java.io.*;
import java.util.*;

public class JXYStoreManager {
    private static final String FILE_NAME = "C:\\Users\\STUDENT\\Documents\\JOF-DataStruct\\dsa\\items.txt";
    private static ArrayList<String> inventory = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Initial Load: Extracts file to array
        loadFromFile();

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n========================================");
            System.out.println("          JXY STORE - MAIN MENU         ");
            System.out.println("========================================");
            System.out.println("1. List All Items");
            System.out.println("2. Add New Item");
            System.out.println("3. Search for Item");
            System.out.println("4. Edit Item");
            System.out.println("5. Delete Item");
            System.out.println("6. Sort Inventory");
            System.out.println("0. Exit");
            System.out.print("\nAction: ");

            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1 -> listItems();
                case 2 -> addItem();
                case 3 -> searchItem();
                case 4 -> editItem();
                case 5 -> deleteItem();
                case 6 -> sortItems();
                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // --- 2. EXTRACT FILE TO ARRAY (BufferedReader/FileReader) ---
    private static void loadFromFile() {
        inventory.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inventory.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // --- SAVE TO FILE (BufferedWriter/FileWriter) ---
    private static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String item : inventory) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // --- MENU ACTIONS ---

    private static void listItems() {
        System.out.println("\n--- CURRENT INVENTORY ---");
        if (inventory.isEmpty()) {
            System.out.println("[ Empty ]");
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println((i + 1) + ". " + inventory.get(i));
            }
        }
    }

    private static void addItem() {
        System.out.println("Enter details (Brand | Product | Color | Size | Price):");
        String details = input.nextLine();
        inventory.add(details);
        saveToFile();
        System.out.println("Item added and saved.");
    }

    private static void searchItem() {
        System.out.print("Search keyword: ");
        String query = input.nextLine().toLowerCase();
        boolean found = false;
        for (String item : inventory) {
            if (item.toLowerCase().contains(query)) {
                System.out.println("Match found: " + item);
                found = true;
            }
        }
        if (!found) System.out.println("No matching items.");
    }

    private static void editItem() {
        listItems();
        System.out.print("Enter index to edit: ");
        int idx = Integer.parseInt(input.nextLine()) - 1;
        if (idx >= 0 && idx < inventory.size()) {
            System.out.print("Enter new details: ");
            inventory.set(idx, input.nextLine());
            saveToFile();
            System.out.println("Update successful.");
        }
    }

    private static void deleteItem() {
        listItems();
        System.out.print("Enter product name to delete: ");
        String prod = input.nextLine().toLowerCase();
        if (prod == inventory) {
            inventory.remove(idx);
            saveToFile();
            System.out.println("Item removed.");
        }
    }

    private static void sortItems() {
        Collections.sort(inventory);
        saveToFile();
        System.out.println("Inventory sorted alphabetically.");
    }
}