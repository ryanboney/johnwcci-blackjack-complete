/**
 * This will contain the Suit value
 * Heart, Spade, Club, Diamond
 */
public class Suit {
    private final String[] suites = new String[] {"Heart", "Spade", "Club", "Diamond"};
    private final int value;
   
    public Suit(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return suites[value];
    }

    


}
