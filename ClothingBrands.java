
import java.util.Scanner;

public class ClothingBrands {

    public static Scanner input = new Scanner(System.in);
    public static int registration = 0;

    public static void main(String[] args) {

        String strBrand; // brand name
        String strproduct; // tops, footwear, bottoms, Outerwear, accessory
        String strColor; //
        String strSize; // S, M , L XL, XS
        double dPrice; // $000.000
        char strResponse = 'y'; // another registration

        System.out.println("========================================");
        System.out.println("          WELCOME TO JXY STORE");
        System.out.println("========================================");

        do {

            System.out.println("\n          PRODUCT REGISTRATION");
            System.out.println();

            System.out.print("[ Brand Name ]  ");
            strBrand = input.nextLine();

            System.out.print("[ Product ]  ");
            strproduct = input.nextLine();

            System.out.print("[ Color ]  ");
            strColor = input.nextLine();

            System.out.print("[ Size ]  ");
            strSize = input.nextLine();

            System.out.print("[ Price ]  $");
            dPrice = input.nextDouble();
            input.nextLine();

            registration++; // counts number of registrations

            strResponse = anotherRegistration(); // asks user if another registration

        } while (strResponse == 'y' || strResponse == 'Y');

        int iCount = numberOfRegistrations();
        System.out.println(iCount + " items registered");
        System.out.println("========================================");
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

    public static char anotherRegistration() { // asks user if another registration

        System.out.println("----------------------------------------");
        System.out.print("\tAnother costumer? (Y/N): ");
        String another = input.nextLine();
        char cAnother = another.charAt(0);
        System.out.println("----------------------------------------");
        return cAnother;
    }

    public static int numberOfRegistrations() { // counts number of registrations
        return registration;
    }

}
