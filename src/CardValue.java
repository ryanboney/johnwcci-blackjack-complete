/**
 * This class will contain the value
 * An Ace will either be a 1 = 11
 * King, Queen, Jack will be 10
 * Other card will be face value
 */
public class CardValue {
    private final String[] display = new String[]{"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    private final int[] values = new int[] {1,2,3,4,5,6,7,8,9,10,10,10,10};
    private final int value;
   
    public CardValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return values[value];
    }

    
    @Override
    public String toString() {
        return display[value];
    }

    
    

}
