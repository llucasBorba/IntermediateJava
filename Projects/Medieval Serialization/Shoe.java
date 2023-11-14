import java.io.Serializable;

public class Shoe extends Armour implements Serializable {

    /* Class Variables */


    /* Constructors */
    public Shoe(String name, int durability, int defenseRating) {
        super(name, durability, defenseRating);
    }
}
