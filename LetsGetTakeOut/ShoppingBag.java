package LetsGetTakeOut;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBag <T extends PricedItem<Integer>>  {

    private Map<T,Integer> shoppingBag;

    public ShoppingBag(){
        shoppingBag = new HashMap<>();
    }

    public void addItem(T item){
        if(shoppingBag.containsKey(item)){
            int currentQuantity = shoppingBag.get(item);
            shoppingBag.put(item, currentQuantity + 1);
         } else {
            shoppingBag.put(item,1);
        }
    }

    public Integer getTotalPrice(){
        Integer bagPrice = 0;

        for (Map.Entry<T, Integer> entry : shoppingBag.entrySet()){
            int quantity =+ entry.getValue();
            bagPrice +=  entry.getKey().getPrice() * quantity;
        }
        return bagPrice;
    }
}
