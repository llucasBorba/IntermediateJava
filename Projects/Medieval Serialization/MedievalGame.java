import java.io.*;
import java.util.Scanner;

public class MedievalGame {

    /* Instance Variables */
    Player player;

    /* Main Method */
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        MedievalGame game = new MedievalGame();

        game.player = game.start(console);

        game.addDelay(500);
        System.out.println("\nLet's take a quick look at you to make sure you're ready to head out the door.");
        System.out.println(game.player);

        game.addDelay(1000);
        System.out.println("\nWell, you're off to a good start, let's get your game saved so we don't lose it.");
        game.save();

        game.addDelay(2000);
        System.out.println("We just saved your game...");
        System.out.println("Now we are going to try to load your character to make sure the save worked...");

        game.addDelay(1000);
        System.out.println("Deleting character...");
        String charName = game.player.getName();
        game.player = null;

        game.addDelay(1500);
        game.player = game.load(charName, console);
        System.out.println("Loading character...");

        game.addDelay(2000);
        System.out.println("Now let's print out your character again to make sure everything loaded:");

        game.addDelay(500);
        System.out.println(game.player);
    } // End of main

    /* Instance Methods */
    private Player start(Scanner console) {
        // Add start functionality here
        Player player;
        Art.homeScreen();
        System.out.println("Welcome to your latest adventure!");
        System.out.println("Tell me traveler, have you been here before?");
        System.out.print("   Enter 'y' to load a game, 'n' to create a new game: ");
        String answer = console.next().toLowerCase();

        while (true) {
            if (answer.equals("y")) {
                System.out.println("So you have been here before, I knew I remember you, tell me your character name so I can see if I find your backpack");
                player = load(console.next(), console);
                break;
            } else if (answer.equals("n")) {
                System.out.println("It's your first time than, tell me your name ");
                String nameResponse = console.next().toLowerCase();
                while (true) {
                    System.out.println("Welcome " + nameResponse + ", am I pronouncing that correctly? (Enter 'y' to confirm, 'n' to enter a new name");
                    String confirme = console.next().toLowerCase();
                    if (confirme.equals("y")) {
                        break;
                    }
                    System.out.println("Okay, that might be a mistake, can you spell it for me again please?");
                    nameResponse = console.next().toLowerCase();
                }
                player = new Player(nameResponse);
                break;
             }else{
                System.out.print("Sorry adventurer, I only speak the common tongue. Please enter 'y' to load a game or 'n' to start a new game: ");
                answer = console.next().toLowerCase();
             }
        }
        return player;
    } // End of start

    private void save() {
        // Add save functionality here
        String fileName = player.getName() + ".svr";

        try {
            FileOutputStream userSaveFile = new FileOutputStream(fileName);
            ObjectOutputStream playerSaver = new ObjectOutputStream(userSaveFile);
            playerSaver.writeObject(this.player);
        } catch (IOException e) {
            System.err.println("There was an error saving your game, your file might not be available the next time you go to load a game." + e.getMessage());
        }

    } // End of save

    private Player load(String playerName, Scanner console) {
        // Add load functionality here
        Player loadedPlayer;
        try {
            FileInputStream userLoadFile = new FileInputStream(playerName + ".svr");
            ObjectInputStream playerLoad = new ObjectInputStream(userLoadFile);
            loadedPlayer = (Player) playerLoad.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error loading your game");
            addDelay(1500);
            System.out.println("We are going to crete a new player");
            addDelay(2000);
            loadedPlayer = new Player(playerName);
        }

        return loadedPlayer;
    } // End of load

    // Adds a delay to the console, so it seems like the computer is "thinking"
    // or "responding" like a human, not instantly like a computer.
    private void addDelay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
