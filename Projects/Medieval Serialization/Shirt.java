import java.io.Serializable;

public class Shirt extends Armour implements Serializable {

    /* Class Variables */


    /* Constructors */
    public Shirt(String name, int durability, int defenseRating) {
        super(name, durability, defenseRating);
    }
}
