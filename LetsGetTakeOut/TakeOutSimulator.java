package LetsGetTakeOut;

import java.util.Scanner;

public class TakeOutSimulator <T> {

    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    public TakeOutSimulator(Customer customer, FoodMenu menu) {
        this.customer = customer;
        this.menu = menu;
        this.input = new Scanner(System.in);
    }

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriver<T> intUserInputRetriver) {

        return null;
    }
}
