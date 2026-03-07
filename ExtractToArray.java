import java.io.*;
import java.util.*;

public class ExtractToArray { 
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        
        // read the file 
        try (BufferedReader reader = new BufferedReader(new FileReader("shop.txt"))) {
            String line; 
            // Read the first line
            while ((line = reader.readLine()) != null) {
                String entry = line + ", " +              // Brand
                               reader.readLine() + " " + // Model
                               reader.readLine() + " " + // Size
                               reader.readLine() + " " + // Color
                               reader.readLine();        // Price
                
                items.add(entry); 
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // Print the items
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + " " + items.get(i));
        }
    }
}