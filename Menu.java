import java.util.Scanner;
public class Menu {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("\n========================================");
            System.out.println("           Welcome to Jee Shop        ");
            System.out.println("========================================");
            System.out.println("[1] Add item");
            System.out.println("[2] Seach item");
            System.out.println("[3] Edit item");
            System.out.println("[4] Delete item");
            System.out.println("[5] Sort item");
            System.out.println("[6] List all item");
            System.out.println("[0] Exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();
    }
}
