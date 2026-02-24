import java.io.*;
import java.util.*;

public class ExtractToArray{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("shop.txt"))){
            String line;
            while((line = br.readLine()) != null){
                list.add(line);
            }
            for(String s : list){
            System.out.println(s);
        }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}