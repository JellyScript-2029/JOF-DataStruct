package random;
import java.util.Scanner;

import Item;

public class Edit {
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

}
