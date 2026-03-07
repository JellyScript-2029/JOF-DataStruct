
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImprovedClothing {
    public static ArrayList<Item> items = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        loadItems();
        while (true) {
            System.out.println("====================================================");
            System.out.println("    W E L C O M E   T O   B R A N D   B A Z A A R   ");
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
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    break;
                case 6:
                    listAllItems();
                    break;
                case 0:
                    return;

            }
        }
    }

    public static void addItem() {
        System.out.println("====================================================");
        System.out.println("                 A D D   I T E M S                  ");
        input.nextLine();
        System.out.print("Brand name: ");
        String brand = input.nextLine();
        System.out.print("Product name: ");
        String prodName = input.nextLine();
        System.out.print("Size: ");
        String size = input.nextLine();
        System.out.print("Color: ");
        String color = input.nextLine();
        System.out.print("Price: ");
        double price = input.nextInt();

        items.add(new Item(brand, prodName, size, color, price));

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
            return;
        }
    }
    
    public static void deleteItem(){
        System.out.println("====================================================");
        System.out.println("               D E L E T E   I T E M                ");
        input.nextLine();
        System.out.print("Enter brand or product name to delete: ");
        String item = input.nextLine().trim().toLowerCase();

        int indx = -1;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).brand.toLowerCase().contains(item) || items.get(i).prodName.toLowerCase().contains(item)){
                System.out.println("[" + i + "]" + items.get(i));
                indx = i;
            }
        }

        if(indx == -1){
            System.out.println("No item found");
            return;
        }

        System.out.print("Enter index to delete: ");
        int itemIndx = input.nextInt();

        if (itemIndx < 0 || itemIndx > items.size()){
            System.out.println("Invalid index");
            return;
        }
        items.remove(indx);
        System.out.println("Item successfully deleted!");
    }

    public static void listAllItems(){
        System.out.println("====================================================");
        System.out.println("                  A L L   I T E M S                ");
        System.out.println("====================================================");
        
        for(Item i : items){
            System.out.println(i);
        }

        if(items.isEmpty()){
            System.out.println("No items found");
        }
    }

    public static void loadItems() {
        String filename = "shop.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String brand = line.trim();
                String prodName = reader.readLine().trim();
                String size = reader.readLine().trim();
                String color = reader.readLine().trim();
                double price = Double.parseDouble(reader.readLine().trim());
                items.add(new Item(brand, prodName, size, color, price));
            }
            System.out.println("Items loaded");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    /*
     * public static void list() {
     * try (BufferedReader reader = new BufferedReader(new FileReader("shop.txt")))
     * {
     * String line;
     * // Read the first line
     * while ((line = reader.readLine()) != null) {
     * String entry = line + " " + // Brand
     * reader.readLine() + " " + // Model
     * reader.readLine() + " " + // Size
     * reader.readLine() + " " + // Color
     * reader.readLine(); // Price
     * 
     * items.add(entry);
     * }
     * } catch (IOException e) {
     * System.out.println(e.getMessage());
     * }
     * 
     * System.out.println("================== ALL ITEMS ===================");
     * // Print the items
     * for (int i = 0; i < items.size(); i++) {
     * System.out.println(i + " " + items.get(i));
     * }
     * }
     */
}
