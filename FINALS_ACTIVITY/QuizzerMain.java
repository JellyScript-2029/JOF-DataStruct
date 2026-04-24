import java.util.*;
public class QuizzerMain{
    public static ArrayList<Player> players = new ArrayList<>();
    public static ArrayList<Question> questions = new ArrayList<>();
    
    public static void main(String[] args){
        menu();

    }
    public static void menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("""
            ============================================
                            MAIN MENU
                    [1] Player Registration
                    [2] Play
                    [3] Exit
        """);
        System.out.print("Choice: ");
        int choice = input.nextInt();

        switch(choice){
            case 1: 
                //register
                break;
            case 2:
                //play
                break;
            case 3:
                //exit
                break;
            default:
                //invalid
        }
    }                                                                                                                                                                                                                                                                       

    public static void registerPlayer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = input.nextLine();
        System.out.println("Enter id: ");
        String idNumber = input.nextLine();

        Player currentPlayer = new Player(name, idNumber);
        players.add(currentPlayer);
        //savePlayers();
        System.out.println("Registered successfully!");
    }

    public static void play(){
    }
}