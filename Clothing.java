
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Clothing {
    public static  Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        File output = new File("Clothing.txt"); // File var = new File ("File name"); assigns a text to a var
        FileWriter fw = new FileWriter(output); // FileWriter var = new FileWriter(filevar); to write to the text file
        StringBuilder sb = new StringBuilder();
        int registration = 0;
        char strResponse = 'y';

        System.out.println("""
                ========================================
                          WELCOME TO JXY STORE
                ========================================
                """);
        fw.write("""
                ========================================
                          WELCOME TO JXY STORE
                ========================================
                """);
    

        do {
            System.out.println("\t  PRODUCT REGISTRATION");
            fw.write("\t  PRODUCT REGISTRATION ");
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

            System.out.println("========================================");
            fw.write("========================================");
            System.out.print("\n\tAnother customer? (Y/N): ");
            strResponse = input.nextLine().charAt(0);
            fw.write("\n\tAnother customer? (Y/N): " + strResponse);
            sb.append("\n\tAnother customer? (Y/N): ").append(strResponse).append("\n");
            System.out.println("\n========================================");
            fw.write("\n========================================");

        } while (strResponse == 'y' || strResponse == 'Y');
    
        System.out.println("\n" + registration + " items registered");
        fw.write("\n" + registration + " items registered");
        System.out.println("\n========================================");
        fw.write("\n========================================");
        fw.close();

    }
}
