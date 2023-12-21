package LetsGetTakeOut;

public class Main {
    public static void main(String[] args) {
        FoodMenu restaurant = new FoodMenu();
        System.out.println(restaurant);
        System.out.println(restaurant.getLowestCostFood());
        Customer lucas = new Customer("Lucas", 30);
        TakeOutSimulator take = new TakeOutSimulator(lucas, restaurant);
        take.shouldsimulate();
        take.getMenuSelection();


    }
}
