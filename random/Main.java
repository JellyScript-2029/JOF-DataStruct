package random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File output = new File("output.txt"); // File var = new File ("File name"); assigns a text to a var
        FileWriter fw = new FileWriter(output); // FileWriter var = new FileWriter(filevar); to write to the text file

        /*
         * write() - fwvar.write("text"); any of the datatypes
         * close()
         * java.io package
         */
        String names[] = { "Jee", "Jelly", "jelyan", "jilyan" };
        int ages[] = { 19, 20, 21, 22 };
        for (int i = 0; i < names.length; i++) {
            fw.write(names[i] + "\n");
            fw.write(ages[i] + "\n");
        }
        int age = 21;
        double weight = 34.35;
        System.out.println("Hello World");
        fw.write("Hello World");
        System.out.println("This is Data Structures!");
        fw.write("\nThis is Data Structures!");
        System.out.println("I am " + age + " years old");
        fw.write("\nI am " + age + " years old");
        System.out.println("Weight " + weight);
        fw.write("\nWeight " + weight);
        fw.close();
    }
}
