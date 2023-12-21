package LetsGetTakeOut;

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

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriver) {
         int userInput = 0;
        while(true){
            try {
                System.out.println(userInputPrompt);
                userInput = input.nextInt();

               return intUserInputRetriver.produceOutputOnIntUserInput(userInput);
            }catch (IllegalArgumentException e){
                System.out.printf("%d is not a valid input. Try again", userInput);
                input.nextLine();
            }
        }

    }
    public boolean shouldsimulate(){
        String userPrompt = "Enter 1 to CONTINUE the simulation or 0 to EXIT program";

        IntUserInputRetriever<Boolean> intUserInputRetriever = selection -> {
            Food lowestcost = menu.getLowestCostFood();


            if(selection == 1 && customer.getMoney() >= lowestcost.getPrice()){
                return true;
            }else if (selection == 0 || customer.getMoney() < lowestcost.getPrice()){
                return false;
            } else {
                throw new IllegalArgumentException("Choose 1 or 0");
            }
        };
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    public Food getMEnuSelection(){
        String userPrompt = "Today's Menu: " + "\n" + menu.toString() + "\n" + "Choose: ";

        IntUserInputRetriever<Food> intUserInputRetriever = selection -> menu.getFood(selection);
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    public boolean isStillOrderingFood(){
        String userPrompt = "Enter 1 to CONTINUE the simulation or 0 to EXIT program";
        IntUserInputRetriever<Boolean> intUserInputRetriever = selection -> {
            if(selection == 1){
                return true;
            } else if (selection == 0) {
                return false;
            }else {
                throw new IllegalArgumentException("Choose 1 or 0");
            }
        };
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

}
