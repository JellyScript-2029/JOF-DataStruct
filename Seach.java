import java.util.ArrayList;
import java.util.Scanner;

public class Seach {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Item> items = new ArrayList<>();
    public static void main (String[] args){
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
}
