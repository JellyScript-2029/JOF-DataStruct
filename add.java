import java.util.ArrayList;
import java.util.Scanner;

public class add {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Item> items = new ArrayList<>();
    public static void main(String[] args){

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
}
