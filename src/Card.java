/**
 * This class will contain one card
 * CardValue 2-10 Jack, Queen, King, Ace
 * Suit Heart, Club, Spade, Diamond
 */
public class Card {
    private final Suit suit;
    private final CardValue cardValue;

    /**
     * Initialize a card with suit and cardvalue
     * @param suit
     * @param cardValue
     */
    public Card(int suit, int cardValue) {
        this.suit = new Suit(suit);
        this.cardValue = new CardValue(cardValue);
    }

    /**
     * Gets the value of the card
     * @return
     */
    public int getValue(){
        return this.cardValue.getValue();
    }

    @Override
    public String toString() {
        return String.format("%s of %s%n",this.cardValue,this.suit);
    }

    
}
