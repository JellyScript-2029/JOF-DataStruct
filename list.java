import java.util.ArrayList;
import java.util.Scanner;

public class list {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args){
    }

    public static void listAllItems(){
        System.out.println("====================================================");
        System.out.println("                  A L L   I T E M S                ");
        System.out.println("====================================================");
        
        for(Item i : items){
            System.out.println(i);
        }

        if(items.isEmpty()){
            System.out.println("No items found");
        }
    }
}
