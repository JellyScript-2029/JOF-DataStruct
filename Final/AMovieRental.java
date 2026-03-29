import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AMovieRental {
    public static Scanner input = new Scanner(System.in);
    public String response;
    private int dvdTotal = 0;
    private int vcdTotal = 0;
    private int tapeTotal = 0;
    private int horrorTotal = 0;
    private int scifiTotal = 0;
    private int dramaTotal = 0;
    private int comedyTotal = 0;
    private int cartoonsTotal = 0;
    private int rentalTotal = 0;
    private int salesTotal = 0;

    public void movieRental() {
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

            String type = "";
            while (true) {
                System.out.print("Type: ");
                try {
                    int choice = input.nextInt();
                    input.nextLine(); // Clear buffer immediately
                    if (choice == 1) {
                        type = "DVD";
                        dvdTotal++;
                        break;
                    } else if (choice == 2) {
                        type = "VCD";
                        vcdTotal++;
                        break;
                    } else if (choice == 3) {
                        type = "Tape";
                        tapeTotal++;
                        break;
                    } else {
                        System.out.println("Invalid! Please choose 1, 2, or 3.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Input! Please Enter an Integer.");
                    input.nextLine(); // Clear the invalid input
                }
            }
            System.out.println("Selected Type: " + type);

            System.out.print("Input Title: ");
            String title = input.nextLine();

            System.out.println("""
                    =====================================================================
                                                 C A T E G O R Y
                                    Please Choose:
                                            [1] Horror
                                            [2] Scifi
                                            [3] Drama
                                            [4] Comedy
                                            [5] Cartoons """);

            String category = "";
            while (true) {
                System.out.print("Category: ");
                try {
                    int choice2 = input.nextInt();
                    input.nextLine(); // Clear buffer
                    boolean valid = true;
                    switch (choice2) {
                        case 1 -> {
                            category = "Horror";
                            horrorTotal++;
                        }
                        case 2 -> {
                            category = "Scifi";
                            scifiTotal++;
                        }
                        case 3 -> {
                            category = "Drama";
                            dramaTotal++;
                        }
                        case 4 -> {
                            category = "Comedy";
                            comedyTotal++;
                        }
                        case 5 -> {
                            category = "Cartoons";
                            cartoonsTotal++;
                        }
                        default -> {
                            System.out.println("Choose only from 1-5");
                            valid = false;
                        }
                    }
                    if (valid)
                        break;
                } catch (Exception e) {
                    System.out.println(" Invalid Input! Please Enter an Integer ");
                    input.nextLine();
                }
            }
            System.out.println("Selected Category: " + category);

            while (true) {
                System.out.print("Input Duration (mins): ");
                try {
                    double minutes = input.nextDouble();
                    input.nextLine(); // Clear buffer
                    break;
                } catch (Exception e) {
                    System.out.println(" Invalid Input! Please Enter a Number ");
                    input.nextLine();
                }
            }

            System.out.print("Input Setting: ");
            String setting = input.nextLine();

            System.out.println("""
                    =====================================================================
                                            T R A N S A C T I O N  T Y P E
                                    Please Choose:
                                            [1] Rental
                                            [2] Sales""");

            String transactionType = "";
            OUTER:
            while (true) {
                System.out.print("Transaction Type: ");
                try {
                    int choice3 = input.nextInt();
                    input.nextLine();
                    switch (choice3) {
                        case 1:
                            transactionType = "Rental";
                            rentalTotal++;
                            break OUTER;
                        case 2:
                            transactionType = "Sales";
                            salesTotal++;
                            break OUTER;
                        default:
                            System.out.println("Choose only from 1 and 2");
                            break;
                    }
                }catch (Exception e) {
                    System.out.println(" Invalid Input! Please Enter an Integer ");
                    input.nextLine();
                }
            }

            while (true) {
                System.out.print("Input Price: ");
                try {
                    double price = input.nextDouble();
                    input.nextLine(); // Clear buffer
                    break;
                } catch (Exception e) {
                    System.out.println(" Invalid Input! Please Enter a Number ");
                    input.nextLine();
                }
            }

            System.out.println("==================================================================");
            System.out.print("Display another Y/N? ");
            response = input.nextLine();
        } while (response.equalsIgnoreCase("Y"));

        StringBuilder reports = new StringBuilder();
        reports.append(String.format("""
                =====================================================================
                                     S Y S T E M   R E P O R T S
                =====================================================================

                        [TRANSACTION SUMMARY]
                            For rent:                                         %d
                            For sale:                                         %d

                        [GENRE BREAKDOWN]
                            Horror:                                           %d
                            Scifi:                                            %d
                            Drama:                                            %d
                            Comedy:                                           %d
                            Cartoons:                                         %d

                        [FORMAT TOTALS]
                            VCD:                                              %d
                            DVD:                                              %d
                            Tape:                                             %d
                =====================================================================
                """,
                rentalTotal, salesTotal,
                horrorTotal, scifiTotal, dramaTotal, comedyTotal, cartoonsTotal,
                vcdTotal, dvdTotal, tapeTotal));

        String finalReport = reports.toString();
        System.out.println(finalReport);
        saveToOutput(finalReport);
        System.out.println("Report successfully saved to output.txt");
    }

    private void saveToOutput(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }
}