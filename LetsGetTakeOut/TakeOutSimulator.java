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

    public Food getMenuSelection(){
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

    public void  checkoutCustomer(ShoppingBag<Food> shoppingBag){
        System.out.println("Processing payment...");
        addDelay(2000);
        int remainingMoney = customer.getMoney() - shoppingBag.getTotalPrice();
        customer.setMoney(remainingMoney);
        System.out.println("Your remaining money is: " + customer.getMoney());
        addDelay(1000);
        System.out.println("Enjoy your meal");
    }

    public void takeOutPrompt(){
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        int customerMoneyLeft = customer.getMoney();
        boolean getOut = true;
            while(getOut){
            System.out.println("You have " + customerMoneyLeft);
            Food customerChose = getMenuSelection();
            if(customerMoneyLeft > customerChose.getPrice()){
                shoppingBag.addItem(customerChose);
                customerMoneyLeft -= customerChose.getPrice();
            } else if (customerMoneyLeft < customerChose.getPrice()) {
                System.out.println("Tá duro dorme, you don't have enough money");
            }
            getOut = isStillOrderingFood();
            }
            checkoutCustomer(shoppingBag);
    }
    public void startTakeOutSimulator(){
        System.out.println("Welcome to my restaurant!");
        boolean starter = true;
        while(starter){
            System.out.println(customer.getName());
            takeOutPrompt();
            starter = shouldsimulate();
        }


    }

    private void addDelay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
