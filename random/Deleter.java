package random;
import java.util.Scanner;

import Item;

public class Deleter {
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

}
