import java.util.Scanner;

public class ClothingBrands {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String strBrand; // brand name
        String strItemCategory; // tops, footwear, bottoms, Outerwear, accessory
        String strProductName; //
        String strSize; // S, M , L XL, XS
        double dPrice; // $000.000
        String strResponse = "";

        do {
            System.out.println("\t\t  Welcome to JXY store");
            System.out.println("--------------------------------------------------------");
            System.out.println("\t\tR E G I S T R A T I O N ");
            System.out.print("Brand Name: ");
            strBrand = input.nextLine();
            System.out.print("Category: ");
            strItemCategory = input.nextLine();
            System.out.print("Product Name: ");
            strProductName = input.nextLine();
            System.out.print("Size: ");
            strSize = input.nextLine();
            System.out.print("Price: ");
            dPrice = input.nextDouble();
        } while (strResponse == "y" || strResponse == "Y");
        anotherRegistration();
    }

    public static String inputString() {
        return input.nextLine();
    }

    public static int inputInt() {
        return input.nextInt();
    }

    public static double inputDouble() {
        return input.nextDouble();

    }

    public static String anotherRegistration() {

        System.out.print("Another costumer Y/N? ");
        String another = input.nextLine();
        return another;
    }

}
