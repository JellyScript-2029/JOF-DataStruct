
import java.util.Scanner;

public class Enterprise {

    public static Scanner input = new Scanner(System.in);
    public static int registration = 0;

    public static void main(String[] args) throws InterruptedException {

        mainMenu();

    }

    public static void loading(String core) throws InterruptedException {
        System.out.println("Loading " + core);
        for (int i = 0; i < 18; i++) {
            Thread.sleep(90);
            System.out.print(". ");
        }

    }

    public static void mainMenu() throws InterruptedException {
        System.out.println(""" 
====================================================================
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
        System.out.println("====================================================================");
        String core = "";

        switch (choice) {
            case 1:
                core = "Core-Mart Inventory & POS";
                loading(core);
                mart();
                break;
            case 2:
                core = "Core-Flix Rental & Booking";
                loading(core);
                movies();
                break;
            case 3:
                core = "Core-Style Clothing Line";
                loading(core);
                ClothingBrands();
                break;
            case 0:
                System.out.println("""
                  THANK YOU FOR USING JF  CORE  SYSTEMS
                              GOODBYE
====================================================================                                  
            """);
                break;
            default:
                System.out.println("Invalid input");
                mainMenu();
                break;
        }

    }

    public static void mart() throws InterruptedException {
        String strProdName, strAnotherP;
        String strCustomer;
        char cCustomer = 'y', cAnotherP = 'y';
        double dQty, dBill, dPrice;
        double dTotal, dPay, dChange = 0;
        do {
            dBill = 0;
            System.out.println("""
                \n====================================================================
                                Welcome to Core-Mart Inventory & POS
                ====================================================================""");
            input.nextLine();
            do {

                System.out.print("Product name: ");
                strProdName = input.nextLine();
                System.out.print("Price: ");
                dPrice = input.nextDouble();
                System.out.print("Quantity: ");
                dQty = input.nextDouble();
                input.nextLine();

                dTotal = dQty * dPrice;
                System.out.println("Total: " + dTotal);

                dBill = dBill + dTotal;

                System.out.print("Another product Y/N? ");
                strAnotherP = input.nextLine();
                cAnotherP = strAnotherP.charAt(0);
            } while ((cAnotherP == 'Y') || (cAnotherP == 'y'));

            while (true) {
                System.out.println("\nBill: " + dBill);
                System.out.print("Payment: ");
                dPay = input.nextDouble();
                input.nextLine();

                if (dPay >= dBill) {
                    dChange = dPay - dBill;
                    System.out.println("Change: " + dChange);
                    System.out.println("Thank you for shopping");
                    break;
                } else {
                    System.out.println("Money is not enough!");
                }
            }

            System.out.print("\nAnother costumer Y/N? ");
            strCustomer = input.nextLine();
            cCustomer = strCustomer.charAt(0);
        } while (cCustomer == 'Y' || cCustomer == 'y');

        System.out.println("Grocery program is terminating...");

        mainMenu();
    }

    public static void movies() throws InterruptedException {
        String response;
        int dvdTotal = 0;
        int vcdTotal = 0;
        int tapeTotal = 0;
        int horrorTotal = 0;
        int scifiTotal = 0;
        int dramaTotal = 0;
        int comedyTotal = 0;
        int cartoonsTotal = 0;
        int rentalTotal = 0;
        int salesTotal = 0;

        do {

            System.out.println("""
        \n=====================================================================
                         Welcome to Core-Flix Rental & Booking
    
        =================== R E G I S T R A T I O N  H U B ==================
        =====================================================================
                                     T Y P E
            Please Choose: 
                    [1] DVD
                    [2] VCD
                    [3] TAPE""");
            System.out.print("Type: ");
            int choice = input.nextInt();
            input.nextLine();

            System.out.print("Input Title: ");
            String title = input.nextLine();

            String type = "";
            switch (choice) {
                case 1:
                    type = "DVD";
                    dvdTotal++;
                    break;
                case 2:
                    type = "VCD";
                    vcdTotal++;
                    break;
                case 3:
                    type = "Tape";
                    tapeTotal++;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            System.out.println("Selected Type: " + type);

            System.out.println("""
        =====================================================================
                                 C A T E G O R Y
            Please Choose: 
                    [1] Horror
                    [2] Scifi
                    [3] Drama
                    [4] Comedy
                    [5] Cartoons """);
            System.out.print("Category: ");
            int choice2 = input.nextInt();

            String category = "";
            switch (choice2) {
                case 1:
                    category = "Horror";
                    horrorTotal++;
                    break;
                case 2:
                    category = "Scifi";
                    scifiTotal++;
                    break;
                case 3:
                    category = "Drama";
                    dramaTotal++;
                    break;
                case 4:
                    category = "Comedy";
                    comedyTotal++;
                    break;
                case 5:
                    category = "Cartoons";
                    cartoonsTotal++;
                    break;
                default:
                    System.out.println("Choose only from 1-5");

                    break;
            }

            System.out.println("Selected Category: " + category);
            System.out.print("Input Duration (mins): ");
            double minutes = input.nextDouble();
            input.nextLine();

            System.out.print("Input Setting: ");
            String setting = input.nextLine();

            System.out.println("""
        =====================================================================
                            T R A N S A C T I O N  T Y P E
            Please Choose:
                    [1] Rental
                    [2] Sales""");
            System.out.print("Transaction Type: ");
            int choice3 = input.nextInt();

            String transactionType = "";
            switch (choice3) {
                case 1:
                    transactionType = "Rental";
                    rentalTotal++;
                    break;
                case 2:
                    transactionType = "Sales";
                    salesTotal++;
                    break;
                default:
                    System.out.println("Choose only from 1 and 2");
                    break;
            }

            System.out.println("Transaction Type : " + transactionType);
            System.out.print("Input Price: ");
            double price = input.nextDouble();
            input.nextLine();
            System.out.println("==================================================================");
            System.out.print("Display another Y/N? ");
            response = input.nextLine();
        } while (response.equalsIgnoreCase("Y"));

        System.out.println("""
        =====================================================================
                            S Y S T E M   R E P O R T S
        =====================================================================
               """);
        System.out.printf("""
            [TRANSACTION SUMMARY]                   [GENRE BREAKDOWN]
              For rent:      %d                      Horror:      %d
              For sale:      %d                      Scifi:       %d
                                                    Drama:       %d
                                                    Comedy:      %d 
                                                    Cartoons:    %d   
            [FORMAT TOTALS]
             VCD:        %d
             DVD:        %d
             Tape:       %d
            
        =====================================================================
                        Core-Flix Rental & Booking Terminated
        =====================================================================

                """, rentalTotal, horrorTotal, salesTotal, scifiTotal, dramaTotal,
                comedyTotal, cartoonsTotal, vcdTotal, dvdTotal, tapeTotal);

        mainMenu();
    }

    public static void ClothingBrands() throws InterruptedException {
        String strBrand; // brand name
        String strproduct; // tops, footwear, bottoms, Outerwear, accessory
        String strColor; // blue, red, orange, black, white,...
        String strSize; // S, M , L XL, XS
        double dPrice; // $000.000
        char strResponse = 'y'; // another registration

        System.out.println("""
        \n====================================================================
                         Welcome to Core-Style Clothing Line """);

        do {

            System.out.println("======================== PRODUCT REGISTRATION =======================");
            System.out.print("Brand Name: ");
            strBrand = input.nextLine();
            input.nextLine();
            System.out.print("Product: ");
            strproduct = input.nextLine();
            System.out.print("Color: ");
            strColor = input.nextLine();
            System.out.print("Size: ");
            strSize = input.nextLine();
            System.out.print("Price: $");
            dPrice = input.nextDouble();
            input.nextLine();
            registration++; // counts number of registrations
            strResponse = anotherRegistration(); // asks user if another product
        } while (strResponse == 'y' || strResponse == 'Y');

        int iCount = numberOfRegistrations();
        System.out.println(iCount + " items registered");
        mainMenu();
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

        System.out.println("====================================================================");
        System.out.print("Another costumer? (Y/N): ");
        String another = input.nextLine();
        char cAnother = another.charAt(0);
        return cAnother;
    }

    public static int numberOfRegistrations() { // counts number of registrations
        return registration;
    }

}
