import java.util.Scanner;

public class Movies {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

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

            System.out.println("    R E G I S T R A T I O N     ");
            System.out.println("--------------------------------");
            System.out.println("            T Y P E             ");

            System.out.println("Please Choose: ");
            System.out.println("""
                                1. DVD
                                2. VCD
                                3. TAPE
                    """);
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
                    System.out.println("Choose only from 1-3");
                    break;
            }
            System.out.println("Type: " + type);

            System.out.println("--------------------------------");
            System.out.println("       C A T E G O R Y");
            System.out.println("Please Choose: ");
            System.out.println("""
                                1. Horror
                                2. Scifi
                                3. Drama
                                4. Comedy
                                5. Cartoons
                    """);
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

            System.out.println("CATEGORY: " + category);
            System.out.print("Input minutes: ");
            double minutes = input.nextDouble();
            input.nextLine();

            System.out.print("Input Setting: ");
            String setting = input.nextLine();

            System.out.println("--------------------------------");
            System.out.println("        TRANSACTION TYPE        ");
            System.out.println("Please Choose: ");
            System.out.println("""
                    1. Rental
                    2. Sales
                    """);
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

            System.out.print("Display another Y/N? ");
            response = input.nextLine();
        } while (response.equalsIgnoreCase("Y"));

        System.out.println("REPORTS");
        System.out.printf("""
                For rent: %d
                For sale: %d
                VCD Total: %d
                DVD Total: %d
                Tape Total: %d
                Horror Movies: %d
                Scifi Movies: %d
                Drama Movies: %d
                Comedy Movies: %d
                Cartoons Movies: %d
                """, rentalTotal, salesTotal, vcdTotal, dvdTotal, tapeTotal, horrorTotal, scifiTotal, dramaTotal,
                comedyTotal, cartoonsTotal);

    }
}
