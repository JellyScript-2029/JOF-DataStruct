package random;
public public static void sortItems() {
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
 {
    
}
