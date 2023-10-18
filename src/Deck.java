import java.util.ArrayList;
import java.util.Random;

/**
 * This class will contain the the playing deck
 * Makes a brand new deck with 52 cards, 13 cards of each suit
 */
public class Deck {
    private ArrayList<Card> cards;
    private Random random = new Random(System.currentTimeMillis());
    private int decks;

    /**
     * Default only uses one deck
     */
    public Deck() {
        this.decks = 1;
        shuffle();
    }

    /**
     * Intialize the decks to use in this game
     * 
     * @param decks number of decks to use
     */
    public Deck(int decks) {
        this.decks = decks;
        shuffle();
    }

    /**
     * Builds a new deck
     */
    private void shuffle() {
        cards = new ArrayList<>();
        for (int deck = 0; deck < decks; deck++) {
            for (int suit = 0; suit < 4; suit++) {
                for (int card = 0; card < 13; card++) {
                    cards.add(new Card(suit, card));
                }
            }
        }
    }
/**
 * Gets a random card from the deck
 * Shuffle the deck if the number of cards dips below 30%
 * @return a single card
 */
    public Card deal() {
         int totalCards = 52*decks;
        if((cards.size()/totalCards)*100 <=30){
            shuffle();
        }
        int randCard = random.nextInt(0, cards.size());
        return cards.remove(randCard);
    }
}
