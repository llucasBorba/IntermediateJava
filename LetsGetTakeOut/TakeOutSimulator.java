package LetsGetTakeOut;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeOutSimulator {

    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    public TakeOutSimulator(Customer customer, FoodMenu menu) {
        this.customer = customer;
        this.menu = menu;
        this.input = new Scanner(System.in);
    }

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriver<T> intUserInputRetriver) {
         int userInput = 0;
        do{
            try {
                System.out.println(userInputPrompt);
                System.out.println("Your order: ");
                userInput = input.nextInt();

               return intUserInputRetriver.produceOutputOnIntUserInput(userInput);
            }catch (IllegalArgumentException e){
                System.out.printf("%d is not a valid input. Try again", userInput);
            }
        }while(true);

    }
}
