import java.util.Scanner;

public class Menu {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("====================================================");
            System.out.println("    W E L C O M E   T O   B R A N D   B A Z A A R   ");
            System.out.println("""
                    ====================================================
                                   M A I N   M E N U
                        [1] Add item
                        [2] Search item
                        [3] Edit item
                        [4] Delete item
                        [5] Sort items
                        [6] List all items
                        [0] Exit""");
            System.out.print("Choice: ");
            int choice = input.nextInt();
        }
    }
}
