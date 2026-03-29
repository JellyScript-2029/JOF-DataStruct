import java.util.Scanner;

public class App {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        mainMenu();
    }

    public static void loading(String core) throws InterruptedException {
        System.out.println("\nLoading " + core);
        for (int i = 0; i < 18; i++) {
            Thread.sleep(50);
            System.out.print(". ");
        }
        System.out.println();
    }

    public static void mainMenu() throws InterruptedException {
        System.out.println("""
                \n====================================================================
                                        W E L C O M E  TO
                                        JF  CORE  SYSTEMS
                -------------- "The heart of your digital operations" --------------

                                [1] Core-Mart Inventory & POS
                                [2] Core-Flix Rental & Booking
                                [3] Core-Style Clothing Line
                                [0] Exit
                ====================================================================""");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();
        input.nextLine(); // Always clear buffer after nextInt()

        switch (choice) {
            case 1 -> {
                loading("Core-Mart Inventory & POS");
                AGrocery groceryApp = new AGrocery();
                // 2. Call the method inside that object
                groceryApp.grocery();
                mainMenu();
            }
            case 2 -> {
                loading("Core-Flix Rental & Booking");
                AMovieRental movieApp = new AMovieRental();
                movieApp.movieRental(); // Call the specific method in that class
                mainMenu();
            }
            case 3 -> {
                loading("Core-Style Clothing Line");
                AClothingBrands clothingApp = new AClothingBrands();
                // Pass the static 'input' scanner so you don't have to create a new one
                clothingApp.brandsMenu();
                mainMenu();
            }
            case 0 -> {
                System.out.println("THANK YOU FOR USING JF CORE SYSTEMS");
                System.exit(0); // Cleanly close the program
            }
            default -> {
                System.out.println("Invalid input.");
                mainMenu();
            }
        }
    }
}