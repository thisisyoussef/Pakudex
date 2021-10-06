import java.util.Arrays;
import java.util.Scanner;

public class PakuriProgram {

    public static Scanner scanner = new Scanner(System.in);

    public static Pakudex thisPakudex;

    //calls function to input and read pakudex capacity then calls function to open menu
    public static void main(String args[]) {
        int pakudexCapacity = 0;
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        capacityInputReader();
        openMenu();

    }

    public static int pakudexCapacity = 0;

    //reads max capacity from user, checks that user inputs a positive integer,
    // if so creates Pakudex thisPakudex and assigns the capacity,
    // otherwise prompts the user to enter a valid size and recalls the function
    public static void capacityInputReader(){

        System.out.println("Enter max capacity of the Pakudex: ");
        String input = scanner.next();

        try{ pakudexCapacity = Integer.parseInt(input);
            if(pakudexCapacity<0){System.out.println("Please enter a valid size.");
                capacityInputReader();
            }else{
            thisPakudex = new Pakudex(pakudexCapacity);
            System.out.println("The Pakudex can hold " + thisPakudex.getCapacity() + " species of Pakuri.");}
        }catch(NumberFormatException e) {
            System.out.println("Please enter a valid size.");
            capacityInputReader();
        }
    }
//outputs menu message and calls functions based on user input,
// if user input is invalid:
    //prints an unrecognized selection message and reopens menu
    public static void openMenu(){
        System.out.println(
                "\n" +
                        "Pakudex Main Menu   \n" +
                        "-----------------\n" +
                        "1. List Pakuri\n" +
                        "2. Show Pakuri\n" +
                        "3. Add Pakuri\n" +
                        "4. Evolve Pakuri\n" +
                        "5. Sort Pakuri\n" +
                        "6. Exit\n" +
                        "What would you like to do?\n");

        String input = scanner.next();
        try{
            int menuChoice = Integer.parseInt(input);
            String species = "x";

            switch (menuChoice){
                //checks that a species is in the Pakudex and proceeds to print every species in
                // thisPakudex.pakuriArray[] using getSpecies(); in a for loop that loops through the occupied
                // Pakuri spaces in pakuriArray[],
                // if there are no Pakuri in thisPakudex prints appropriate message and reopens menu
                case 1:
                    if(thisPakudex.speciesInPakudex){
                        System.out.println("Pakuri In Pakudex:");
                        for(int i =0; i< thisPakudex.size;i++){
                System.out.println((i+1) + ". " + thisPakudex.pakuriArray[i].getSpecies());}}
                    else{ System.out.println("No Pakuri in Pakudex yet!");}
                openMenu();
                break;
                case 2:
                    System.out.println("Enter the name of the species to display: ");
                    String pakuriName = scanner.next();
                    thisPakudex.getStats(pakuriName);
                    openMenu();
                    break;
                case 3:
                    //checks if pakudex is full before calling function and if so prints error message and reopens menu
                    if(thisPakudex.size == thisPakudex.capacity){
                        System.out.println("Error: Pakudex is full!");
                        openMenu();}
                    System.out.print("Enter the name of the species to add: ");
                    species = scanner.next();
                    thisPakudex.addPakuri(species);
                    openMenu();
                    break;
                case 4:
                    System.out.print("Enter the name of the species to evolve: ");
                    species = scanner.next();
                    thisPakudex.evolveSpecies(species);
                    openMenu();
                    break;
                case 5:
                    thisPakudex.sortPakuri();
                    openMenu();
                    break;
                case 6:
                    System.out.println("Thanks for using Pakudex! Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unrecognized menu selection!");
                    openMenu();


            }
        }catch(NumberFormatException e) {

           System.out.println("Unrecognized menu selection!");
           openMenu();
        }


    }
    }
