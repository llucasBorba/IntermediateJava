package IceCreamShop;

import java.util.Scanner;

class ShopItems {
    int totalCount;
        public class NonVegan{
            int iceCreamCount;
            int shakeCount;
            int totalCount;

            public void increaseCount(int type, int count){
                if(type == 1){
                    iceCreamCount += count;
                } else if (type == 2){
                    shakeCount += count;
                }
                ShopItems.this.totalCount += count;
                totalCount += count;
            }
        }

        public class Vegan{
            int smoothieCount;
            int slushieCount;
            int totalCount;

            public void increaseCount(int type, int count){
                if(type == 3){
                    smoothieCount += count;
                } else if (type == 4){
                    slushieCount += count;
                }
                ShopItems.this.totalCount += count;
                totalCount += count;
            }

        }

}

public class IceCreamShop {

    public static void main(String[] args) {
        int orderType = 0;
        Scanner input = new Scanner(System.in);
        int itemCount = 0;
        String itemName = "";
        ShopItems shopItems = new ShopItems();
        ShopItems.NonVegan  nonVegan = shopItems.new NonVegan();
        ShopItems.Vegan Vegan = shopItems.new Vegan();

        System.out.println("Hello! Welcome to the ice cream shop. We are ready to take your order. For ice-cream type 1, for shakes type 2, for smoothies type 3, and for slushies type 4. If you are done ordering type 0.");
        orderType = input.nextInt();

        while(orderType != 0) {
            System.out.println("How many items of this item would you like to order?");
            itemCount = input.nextInt();

            switch (orderType) {
                case 1:
                    itemName = "ice cream";
                    nonVegan.increaseCount(orderType,itemCount);
                    break;
                case 2:
                    itemName = "shake";
                    nonVegan.increaseCount(orderType,itemCount);
                    break;
                case 3:
                    itemName = "smoothie";
                    Vegan.increaseCount(orderType,itemCount);
                    break;
                case 4:
                    itemName = "slushie";
                    Vegan.increaseCount(orderType,itemCount);
                    break;
                default:
                    break;
            }

            System.out.println("Adding " + itemCount + " of the item "+ itemName + " to your order!");

            System.out.println("Type a number for the next item in your order:\n1: Ice cream\n2: Shake\n3: Smoothie\n4: Slushie\n");
            orderType = input.nextInt();
        }
        System.out.println("Thank you for your order ");
    }
}
