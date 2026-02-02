
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Clothing {
    public static void main(String[] args) throws IOException {
        File output = new File("ClothingBrand.txt"); // File var = new File ("File name"); assigns a text to a var
        FileWriter fw = new FileWriter(output); // FileWriter var = new FileWriter(filevar); to write to the text file
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.println("========================================");
        fw.write("========================================");
        System.out.println("          WELCOME TO JXY STORE");
        fw.write("\n          WELCOME TO JXY STORE");
        System.out.println("========================================");
        fw.write("\n========================================");
        char strResponse = 'y';
        int registration = 0;

        do {
            System.out.println("          PRODUCT REGISTRATION");
            fw.write("\n         PRODUCT REGISTRATION ");
            System.out.print("Brand name: ");
            sb.append("\nBrand name: ").append(input.nextLine()).append("\n");
            System.out.print("Product: ");
            sb.append("Product: ").append(input.nextLine()).append("\n");
            System.out.print("Color: ");
            sb.append("Color: ").append(input.nextLine()).append("\n");
            System.out.print("Size: ");
            sb.append("Size: ").append(input.nextLine()).append("\n");
            System.out.print("Price: ");
            sb.append("Price:").append(input.nextLine()).append("\n");
            fw.write(sb.toString());
            registration++;
            System.out.println("----------------------------------------");
            fw.write("----------------------------------------");
            System.out.print("\tAnother costumer? (Y/N): ");
            fw.write("\tAnother costumer? (Y/N): ");
            sb.append("\tAnother costumer? (Y/N): ").append(input.nextLine().charAt(0)).append("\n");
            System.out.println("----------------------------------------");
            fw.write("----------------------------------------");

        } while (strResponse == 'y' || strResponse == 'Y');

        System.out.println(registration + " items registered");
        fw.write(registration + " items registered");
        System.out.println("========================================");
        fw.write("========================================");
        fw.close();

    }
}
