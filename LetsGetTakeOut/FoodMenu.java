package LetsGetTakeOut;

import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    private List<Food> menu;

    public FoodMenu(){
    this.menu = new ArrayList<>();
    menu.add(new Food("Pizza","Peperoni", 20));
    menu.add(new Food("Burguer","Hero-Burguer", 12));
    menu.add(new Food("Soda","Coca", 3));
    }

    @Override
    public String toString() {
        StringBuilder menuString = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {
            menuString.append(i+1).append(".").append(menu.get(i)).append("\n");
        }
        return menuString.toString();
    }

    public Food getFood(int index){
        int realIndex = index - 1;
        try {
           return menu.get(realIndex);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public Food getLowestCostFood(){
        Food lowestCost = menu.get(0);
          for(Food food : menu){
                if( food.getPrice() < lowestCost.getPrice()){
                   lowestCost = food;
                }
          }
        return lowestCost;
    }

}
