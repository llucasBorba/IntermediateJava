package LetsGetTakeOut;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBag <T extends PricedItem<Integer>>  {

    private Map<T,Integer> shoppingBag;

    public ShoppingBag(){
        shoppingBag = new HashMap<>();
    }

}
