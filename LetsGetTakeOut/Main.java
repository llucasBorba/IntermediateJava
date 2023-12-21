package LetsGetTakeOut;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Can you tell me your name");
        String name = input.nextLine();
        System.out.println("I'm sorry.. but, could you tell me how rich are you? ");
        int money = input.nextInt();

        Customer customer = new Customer(name,money);
        FoodMenu foodMenu = new FoodMenu();
        TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer,foodMenu);
        takeOutSimulator.startTakeOutSimulator();

    }
}
